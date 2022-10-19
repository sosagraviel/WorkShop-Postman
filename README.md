# WorkShop Example

This project was born with the aim of show an how handle postman into a RESTFul

## How does it run?

### Launch a docker compose with mongodb
First off you need to run a docker compose.
In the root of the project run the next command from a terminal:


    docker-compose up 

### Run your Spring Boot application

    mvn spring-boot:run

### Verify your application

You can run a curl with event-stream to verify is it working well.

    curl --location --request GET 'http://localhost:8080/cars'

### Verify your swagger

You can verify into the following url.

    http://localhost:8080/swagger-ui/index.html
