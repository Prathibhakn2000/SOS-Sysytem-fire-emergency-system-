create table Fire_EmergencyRequest (
	uuid_ VARCHAR(75) null,
	requestId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	requestTitle VARCHAR(75) null,
	description VARCHAR(75) null,
	location VARCHAR(75) null,
	exactAddress VARCHAR(75) null,
	contactNumber LONG,
	attachmentPath VARCHAR(75) null,
	status VARCHAR(75) null,
	allocatedTeamId LONG
);