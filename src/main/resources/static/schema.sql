DROP TABLE IF EXISTS events, users, comments;

CREATE TABLE users
(
  userName varchar(50) NOT NULL,
  userPassword varchar(100) NOT NULL,
  PRIMARY KEY (userName)
);

CREATE TABLE events
(
  eventId integer GENERATED ALWAYS AS IDENTITY,
  userName varchar(50) NOT NULL,
  eventName varchar(100) NOT NULL,
  eventDesc varchar(300) NOT NULL,
  eventUnixTime bigint NOT NULL,
  eventUnixExpiry bigint NOT NULL,
  eventCategory varchar(50) NOT NULL,
  eventSubCategory varchar(50) NOT NULL,
  eventImageURL varchar(300) NOT NULL,
  eventAddress varchar(100) NOT NULL,
  PRIMARY KEY (eventId)
);

ALTER TABLE events ADD CONSTRAINT fk_event_user FOREIGN KEY (userName) REFERENCES users (userName) ON DELETE CASCADE;

CREATE TABLE comments
(
  commentId integer GENERATED ALWAYS AS IDENTITY,
  commenterName varchar(50) NOT NULL,
  eventId integer NOT NULL,
  commentUnixTime bigint NOT NULL,
  commentString varchar(300) NOT NULL,
  PRIMARY KEY (commentId)
);

ALTER TABLE comments ADD CONSTRAINT fk_comment_event FOREIGN KEY (eventId) REFERENCES events (eventId) ON DELETE CASCADE;
ALTER TABLE comments ADD CONSTRAINT fk_comment_user FOREIGN KEY (commenterName) REFERENCES users (userName) ON DELETE CASCADE;
