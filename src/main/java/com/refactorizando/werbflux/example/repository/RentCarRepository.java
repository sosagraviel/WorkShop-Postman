package com.refactorizando.werbflux.example.repository;

import com.refactorizando.werbflux.example.domain.Car;
import com.refactorizando.werbflux.example.domain.RentCar;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RentCarRepository extends ReactiveMongoRepository<RentCar, Long> {

}
