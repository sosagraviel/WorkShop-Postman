package com.refactorizando.postman.example.repository;

import com.refactorizando.postman.example.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CarRepository extends MongoRepository<Car, Long> {

}
