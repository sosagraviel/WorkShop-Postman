package com.refactorizando.werbflux.example.repository;

import com.refactorizando.werbflux.example.domain.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

public interface CarRepository extends ReactiveMongoRepository<Car, Long> {

}
