# backend/app/main.py
from fastapi import FastAPI, Depends, HTTPException, Query
from fastapi.middleware.cors import CORSMiddleware
from sqlalchemy.orm import Session
from typing import List, Optional
from app.database import Base, engine, get_db
from app.models import SavedMovie
from pydantic import BaseModel
from app.tmdb_client import search_movies, get_trailer, get_popular, TMDB_API_KEY
import requests

# Initialize FastAPI
app = FastAPI(title="Movie Trailer App", version="1.0")

# Allow frontend URL for CORS
origins = [
    "http://127.0.0.1:5173",
    "http://localhost:5173",
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# Create database tables
Base.metadata.create_all(bind=engine)

# Pydantic schema
class Movie(BaseModel):
    id: int
    title: str
    overview: Optional[str] = None
    release_date: Optional[str] = None
    poster_path: Optional[str] = None
    vote_average: Optional[float] = None

# Root
@app.get("/")
def home():
    return {"message": "Welcome to Movie Trailer API!"}

# Popular movies
@app.get("/movies/popular", response_model=List[Movie])
def popular_movies_endpoint(page: int = 1):
    return get_popular(page)

# Search movies
@app.get("/movies/search", response_model=List[Movie])
def search_movies_endpoint(q: str = Query(..., min_length=1), page: int = 1):
    return search_movies(q, page)

# Get movie trailer
@app.get("/movies/{movie_id}/trailer")
def trailer_endpoint(movie_id: int, db: Session = Depends(get_db)):
    # 1️⃣ Try TMDB first
    # Fetch movie details from TMDB to get the title
    tmdb_url = f"https://api.themoviedb.org/3/movie/{movie_id}"
    params = {"api_key": TMDB_API_KEY, "language": "en-US"}
    res = requests.get(tmdb_url, params=params)
    if res.status_code != 200:
        raise HTTPException(status_code=404, detail="Movie not found in TMDB")
    tmdb_data = res.json()
    tmdb_title = tmdb_data.get("title", "")

    # 2️⃣ Use get_trailer function (TMDB + YouTube fallback)
    key = get_trailer(movie_id, tmdb_title)

    # 3️⃣ Check DB fallback
    if not key:
        movie = db.query(SavedMovie).filter(SavedMovie.id == movie_id).first()
        if movie and movie.trailer_url:
            key = movie.trailer_url

    # 4️⃣ Not found
    if not key:
        raise HTTPException(status_code=404, detail="Trailer not found")

    # 5️⃣ Return YouTube URL
    return {"youtube_url": f"https://www.youtube.com/watch?v={key}"}


# Save movie
@app.post("/movies/save")
def save_movie(movie: Movie, trailer_url: Optional[str] = None, db: Session = Depends(get_db)):
    existing = db.query(SavedMovie).filter(SavedMovie.id == movie.id).first()
    if existing:
        existing.title = movie.title
        existing.overview = movie.overview
        existing.release_date = movie.release_date
        existing.poster_path = movie.poster_path
        existing.vote_average = movie.vote_average
        if trailer_url:
            existing.trailer_url = trailer_url
    else:
        new_movie = SavedMovie(
            id=movie.id,
            title=movie.title,
            overview=movie.overview,
            release_date=movie.release_date,
            poster_path=movie.poster_path,
            vote_average=movie.vote_average,
            trailer_url=trailer_url
        )
        db.add(new_movie)
    db.commit()
    return {"message": f"Movie '{movie.title}' saved successfully."}

# Saved movies
@app.get("/movies/saved", response_model=List[Movie])
def saved_movies(db: Session = Depends(get_db)):
    movies = db.query(SavedMovie).all()
    return movies
