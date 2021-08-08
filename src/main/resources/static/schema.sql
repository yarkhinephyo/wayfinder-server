DROP TABLE IF EXISTS events;

CREATE TABLE events
(
  eventName varchar(100) NOT NULL,
  eventId varchar(11) NOT NULL ,
  eventAddress varchar(100) DEFAULT NULL,
  eventEmail varchar(100) DEFAULT NULL,
  PRIMARY KEY (eventId)
);