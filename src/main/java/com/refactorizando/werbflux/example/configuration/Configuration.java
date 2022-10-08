package com.refactorizando.werbflux.example.configuration;

import com.refactorizando.werbflux.example.domain.Car;
import com.refactorizando.werbflux.example.domain.RentCar;
import com.refactorizando.werbflux.example.repository.CarRepository;
import com.refactorizando.werbflux.example.repository.RentCarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor

public class Configuration implements CommandLineRunner {

    private final CarRepository carRepository;
    private final RentCarRepository rentCarRepository;

    @Override
    public void run(String... args) {
        List<Car> cars = new ArrayList<>();
        List<RentCar> rentCars = new ArrayList<>();
        if (rentCarRepository.count() == 0) {
            rentCars.add(new RentCar(1L, "default name"));
            rentCarRepository.saveAll(rentCars);
        }
        if (carRepository.count() == 0) {
            cars.add(new Car(1L, "ferrary", "black", new RentCar(1L, "default name")));
            carRepository.saveAll(cars);
        }
    }
}