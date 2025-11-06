create table Fire_EmrgcyRequest (
	uuid_ VARCHAR(75) null,
	requestId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	location VARCHAR(75) null,
	status VARCHAR(75) null,
	assignedTeam VARCHAR(75) null,
	requesterUserId LONG
);