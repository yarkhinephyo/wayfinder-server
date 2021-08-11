## API

### Auth Endpoints 
Do not require the bearer token in the header.

| Endpoint                  | Description                                      |
| ------------------------- | ------------------------------------------------ |
| POST /auth/authenticate   | Retrieves an access token with user credentials  |
| POST /auth/signup         | Adds user to database                            |

### Event Endpoints
Require the bearer token in the header.

| Endpoint                 | Description                                  |
| ------------------------ | -------------------------------------------- |
| GET /event/all           | Retrieves all events in the database         |
| POST /event/new          | Adds a new event                             |
| PUT /event/executeUpdate | Updates an event                             |
| DELETE /event/{eventId}  | Deletes an event                             |

### Comment Endpoints
Require the bearer token in the header.

| Endpoint                     | Description                              |
| ---------------------------- | ---------------------------------------- |
| GET /comment/event/{eventId} | Retrieves all comments from an event     |
| POST /comment/new            | Adds a new comment to an event           |
| DELETE /comment/{commentId}  | Deletes a comment                        |