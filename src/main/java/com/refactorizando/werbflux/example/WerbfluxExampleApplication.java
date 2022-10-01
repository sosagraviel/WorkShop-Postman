package com.refactorizando.werbflux.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Spring Demo",
        version = "1.0",
        description = "Sample document"
))
public class WerbfluxExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WerbfluxExampleApplication.class, args);
    }

}
