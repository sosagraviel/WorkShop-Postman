package com.refactorizando.werbflux.example.configuration;

import com.refactorizando.werbflux.example.domain.Car;
import com.refactorizando.werbflux.example.domain.RentCar;
import com.refactorizando.werbflux.example.dto.CarDTO;
import com.refactorizando.werbflux.example.mapper.CarsMapper;
import com.refactorizando.werbflux.example.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
@RequiredArgsConstructor

public class Configuration implements CommandLineRunner {

    private final CarRepository carRepository;

    @Override
    public void run(String... args) {
        List<CarDTO> cars = new ArrayList<>();
        if (carRepository.count() == 0) {
            cars.add(new CarDTO(1L, "ferrary", "black", 1L ));

            for (int i = 0; i < cars.size(); i++) {
                carRepository.save(CarsMapper.INSTANCE.dtoToCar(cars.get(i)));
            }

        }
    }
}