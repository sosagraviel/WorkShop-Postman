package com.refactorizando.werbflux.example.repository;

import com.refactorizando.werbflux.example.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CarRepository extends MongoRepository<Car, Long> {

}
