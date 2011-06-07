create table wt_Request (
	uuid_ VARCHAR(75) null,
	requestId LONG not null primary key,
	name VARCHAR(75) null,
	fromLat DOUBLE,
	fromLng DOUBLE,
	fromAddress VARCHAR(75) null,
	toLat DOUBLE,
	toLng DOUBLE,
	toAddress VARCHAR(75) null,
	distance LONG,
	beginDate DATE null,
	duration INTEGER,
	state VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);