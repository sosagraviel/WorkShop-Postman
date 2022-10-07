package com.refactorizando.werbflux.example.controller;

import com.refactorizando.werbflux.example.domain.Car;
import com.refactorizando.werbflux.example.dto.CarDTO;
import com.refactorizando.werbflux.example.mapper.CarsMapper;
import com.refactorizando.werbflux.example.repository.CarRepository;
import com.refactorizando.werbflux.example.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;
    private final CarService carService;

    @PostMapping
    public ResponseEntity<CarDTO> register(@RequestBody CarDTO carDTO) throws Exception {
        return ResponseEntity.ok(carService.createCar(carDTO));
    }

    @GetMapping()
    public List<Car> getCars() {
        return carRepository.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable String id, @RequestBody CarDTO carDTO) throws Exception {
        return ResponseEntity.ok(carService.updateCar(id, carDTO));
    }
}
