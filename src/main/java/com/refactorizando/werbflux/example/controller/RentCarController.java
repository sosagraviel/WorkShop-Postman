package com.refactorizando.werbflux.example.controller;

import com.refactorizando.werbflux.example.domain.Car;
import com.refactorizando.werbflux.example.domain.RentCar;
import com.refactorizando.werbflux.example.repository.CarRepository;
import com.refactorizando.werbflux.example.repository.RentCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rent_cars")
public class RentCarController {

    private static final int DELAY_PER_ITEM_MS = 100;

    private final RentCarRepository rentCarRepository;

    @PostMapping
    public Mono<RentCar> register(@RequestBody RentCar rentCar) {
        return rentCarRepository.save(rentCar);
    }

    @GetMapping("/{id}")
    public Mono<RentCar> getById(@PathVariable Long id) {
        return rentCarRepository.findById(id);
    }

    @GetMapping()
    public Flux<RentCar> getCars() {
        return rentCarRepository.findAll().delayElements(Duration.ofMillis(DELAY_PER_ITEM_MS));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return rentCarRepository.deleteById(id);
    }
}
