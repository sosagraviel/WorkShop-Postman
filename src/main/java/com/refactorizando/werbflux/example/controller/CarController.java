package com.refactorizando.werbflux.example.controller;

import com.refactorizando.werbflux.example.domain.Car;
import com.refactorizando.werbflux.example.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private static final int DELAY_PER_ITEM_MS = 100;

    private final CarRepository carRepository;

    @PostMapping
    public Mono<Car> register(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @GetMapping("/{id}")
    public Mono<Car> getById(@PathVariable Long id) {
        return carRepository.findById(id);
    }

    @GetMapping()
    public Flux<Car> getCars() {
        return carRepository.findAll().delayElements(Duration.ofMillis(DELAY_PER_ITEM_MS));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return carRepository.deleteById(id);
    }
}
