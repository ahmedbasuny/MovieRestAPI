# MovieRestApi 
Small app for Develop REST API endpoint with CRUD functionality on Movies data.
can list movies, delete movie, update movie, add new movie.
## Installation

### Requirements
* Java 8
* Maven
* MYSQL
* Docker

### Build and Run
* Build with Maven.

Download the app. Extract the zip file. go inside project folder and run this maven commend to build the image.

`$ mvn clean package spring-boot:repackage dockerfile:build`

* Build with docker-compose.

Download the app. Extract the zip file. go inside project folder and run this docker-compose commend.

`$ docker-compose docker-compose.yml -d`

## Built With
* SpringBoot
* MYSQL DB
* Docker

## Using the endpoints
* Once the app is up and running. you can check API documentation from this url
[Swagger API Documentation](http://localhost:8080/swagger-ui.html)
* You can check MovieController for endpoints
* Ex: http://localhost:8080/api/v1/movies       GET     List All Movies 
* Ex: http://localhost:8080/api/v1/movies/{id}  GET     get Movie with id 
* Ex: http://localhost:8080/api/v1/movies       POST    save Movie
* Ex: http://localhost:8080/api/v1/movies/{id}  PUT     update Movie with id 
* Ex: http://localhost:8080/api/v1/movies/{id}  DELETE  delete Movie with id 

* You can check MovieResourceController for endpoints that achieve heatoas principle
* Ex: http://localhost:8080/api/v2/movies       GET     List All Movies 
* Ex: http://localhost:8080/api/v2/movies/{id}  GET     get Movie with id 
* Ex: http://localhost:8080/api/v2/movies       POST    save Movie
* Ex: http://localhost:8080/api/v2/movies/{id}  PUT     update Movie with id 
* Ex: http://localhost:8080/api/v2/movies/{id}  DELETE  delete Movie with id 

## Unit/Integeration Test
* The project having integeration test for all endpoint with Junit.

## API Documentation
* [Swagger API Documentation](http://localhost:8080/swagger-ui.html)

## Actuator
* The project uses spring actuator for monitoring.
* [actuator metrics](http://localhost:8080/actuator/metrics)
* [actuator env](http://localhost:8080/actuator/env)
* [actuator health](http://localhost:8080/actuator/health)

## REST API style
* use Richardson Maturity Model for reference with Hateoas concept.


