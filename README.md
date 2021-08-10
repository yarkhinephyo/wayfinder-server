# Wayfinder Server

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3.6](https://maven.apache.org)

## Running the application locally

Edit the database configurations accordingly at `src/main/resources/application-default.properties`

```
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

jwt.secret=
```

To run a Spring Boot application, execute the `main` method in the `com.wayfinder.app.Application` class from your IDE.
