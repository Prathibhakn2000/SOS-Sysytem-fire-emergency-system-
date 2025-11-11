// src/App.js
import React, { useEffect, useState } from "react";
import axios from "axios";
import Modal from "react-modal";

Modal.setAppElement("#root");

const API_BASE = "http://127.0.0.1:8000"; // Make sure backend is running here

function App() {
  const [movies, setMovies] = useState([]);
  const [trailerUrl, setTrailerUrl] = useState("");
  const [modalIsOpen, setModalIsOpen] = useState(false);
  const [loadingTrailer, setLoadingTrailer] = useState(false);
  const [searchQuery, setSearchQuery] = useState("");

  useEffect(() => {
    fetchPopularMovies();
  }, []);

  // Fetch popular movies
  const fetchPopularMovies = async () => {
    try {
      const res = await axios.get(`${API_BASE}/movies/popular`);
      setMovies(res.data);
    } catch (err) {
      console.error(err);
      alert("Failed to fetch popular movies. Is backend running?");
    }
  };

  // Search movies
  const searchMovies = async () => {
    if (!searchQuery.trim()) return;
    try {
      const res = await axios.get(
        `${API_BASE}/movies/search?q=${encodeURIComponent(searchQuery)}`
      );
      setMovies(res.data.results || res.data); // handle different response formats
    } catch (err) {
      console.error(err);
      alert("Failed to search movies");
    }
  };

  // Open trailer modal
  const openTrailer = async (movieId) => {
    try {
      setLoadingTrailer(true);
      const res = await axios.get(`${API_BASE}/movies/${movieId}/trailer`);
      if (res.data.youtube_url) {
        setTrailerUrl(res.data.youtube_url);
        setModalIsOpen(true);
      } else {
        alert("Trailer not found");
      }
    } catch (err) {
      console.error(err);
      alert("Trailer not found");
    } finally {
      setLoadingTrailer(false);
    }
  };

  // Save movie
  const saveMovie = async (movie) => {
    try {
      // Include trailer_url if you have it (optional)
      let trailer_url = trailerUrl || null;
      await axios.post(`${API_BASE}/movies/save`, { ...movie, trailer_url });
      alert(`Movie "${movie.title}" saved!`);
    } catch (err) {
      console.error(err);
      alert("Failed to save movie");
    }
  };

  return (
    <div style={{ padding: 20 }}>
      <h1>Movie Trailer App</h1>

      {/* Search */}
      <div style={{ marginBottom: 20 }}>
        <input
          type="text"
          placeholder="Search movies..."
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
          style={{ padding: 5, width: 200, marginRight: 10 }}
        />
        <button onClick={searchMovies}>Search</button>
        <button onClick={fetchPopularMovies} style={{ marginLeft: 10 }}>
          Popular
        </button>
      </div>

      {/* Movie list */}
      <div style={{ display: "flex", flexWrap: "wrap" }}>
        {movies.map((movie) => (
          <div
            key={movie.id}
            style={{
              border: "1px solid #ccc",
              margin: 10,
              padding: 10,
              width: 180,
              textAlign: "center",
              borderRadius: 8,
            }}
          >
            {movie.poster_path && (
              <img
                src={movie.poster_path}
                alt={movie.title}
                style={{ width: "100%", borderRadius: 5 }}
              />
            )}
            <h4>{movie.title}</h4>
            <button
              style={{ margin: 5 }}
              onClick={() => openTrailer(movie.id)}
            >
              Watch Trailer
            </button>
            <button style={{ margin: 5 }} onClick={() => saveMovie(movie)}>
              Save Movie
            </button>
          </div>
        ))}
      </div>

      {/* Modal for trailer */}
      <Modal
        isOpen={modalIsOpen}
        onRequestClose={() => setModalIsOpen(false)}
        contentLabel="Trailer"
        style={{
          content: {
            top: "50%",
            left: "50%",
            right: "auto",
            bottom: "auto",
            marginRight: "-50%",
            transform: "translate(-50%, -50%)",
            width: "80%",
            maxWidth: 800,
          },
        }}
      >
        <button onClick={() => setModalIsOpen(false)}>Close</button>
        {loadingTrailer ? (
          <p>Loading trailer...</p>
        ) : (
          trailerUrl && (
            <iframe
              width="100%"
              height="450"
              src={trailerUrl.replace("watch?v=", "embed/")}
              title="Trailer"
              frameBorder="0"
              allow="autoplay; encrypted-media"
              allowFullScreen
            ></iframe>
          )
        )}
      </Modal>
    </div>
  );
}

export default App;
