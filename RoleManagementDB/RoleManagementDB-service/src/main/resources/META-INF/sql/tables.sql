create table UserRoleTable (
	userRoleId LONG not null primary key,
	userId LONG,
	roleId LONG
);

create table fire_RoleTable (
	uuid_ VARCHAR(75) null,
	roleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	roleName VARCHAR(75) null,
	description VARCHAR(75) null
);