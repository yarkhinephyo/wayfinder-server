DROP TABLE IF EXISTS events, users;

CREATE TABLE events
(
  eventName varchar(100) NOT NULL,
  eventId varchar(11) NOT NULL ,
  eventAddress varchar(100) DEFAULT NULL,
  eventEmail varchar(100) DEFAULT NULL,
  PRIMARY KEY (eventId)
);

CREATE TABLE users
(
  userName varchar(50) NOT NULL,
  userPassword varchar(100) NOT NULL,
  PRIMARY KEY (userName)
);