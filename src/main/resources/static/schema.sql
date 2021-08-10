DROP TABLE IF EXISTS events, users;

CREATE TABLE users
(
  userName varchar(50) NOT NULL,
  userPassword varchar(100) NOT NULL,
  PRIMARY KEY (userName)
);

CREATE TABLE events
(
  eventId INTEGER GENERATED ALWAYS AS IDENTITY,
  eventName varchar(100) NOT NULL,
  eventAddress varchar(100) DEFAULT NULL,
  eventEmail varchar(100) DEFAULT NULL,
  userName varchar(50) NOT NULL,
  PRIMARY KEY (eventId),
  CONSTRAINT fk_event_user FOREIGN KEY (userName) REFERENCES users (userName)
);