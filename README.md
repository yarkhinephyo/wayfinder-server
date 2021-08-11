# Wayfinder Server

## Requirements

For building and running the application locally you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3.6](https://maven.apache.org)
- [Docker](https://www.docker.com/)

## Running the application locally

1. Run PostgreSQL locally

```
docker run --rm -e POSTGRES_PASSWORD=password -e POSTGRES_DB=wayfinder -e POSTGRES_USER=postgres postgres:13.3
```


2. To run the Spring Boot application locally, execute the `main` method in the `com.wayfinder.app.Application` class from your IDE.
3. Test the endpoints with [Postman collections](postman/Wayfinder.postman_collection.json) (Refer to [docs](docs/README.md))

## Deployment Configurations
Edit the configurations accordingly at `src/main/resources/application-default.properties`

```
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

jwt.secret=
```
