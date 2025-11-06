create table ATS_TicketMgmt (
	uuid_ VARCHAR(75) null,
	ticket_id LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	busNumber VARCHAR(75) null,
	fromLocation VARCHAR(75) null,
	toLocation VARCHAR(75) null,
	journeyDate DATE null,
	seatNumber INTEGER,
	fareAmount LONG
);