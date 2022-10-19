package com.refactorizando.postman.example.repository;

import com.refactorizando.postman.example.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CarRepository extends MongoRepository<Car, Long> {
    List<Car> findByRentCar_Id(Long id);
}
