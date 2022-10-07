package com.refactorizando.werbflux.example.service;

import com.refactorizando.werbflux.example.domain.Car;
import com.refactorizando.werbflux.example.domain.RentCar;
import com.refactorizando.werbflux.example.dto.CarDTO;
import com.refactorizando.werbflux.example.mapper.CarsMapper;
import com.refactorizando.werbflux.example.repository.CarRepository;
import com.refactorizando.werbflux.example.repository.RentCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final RentCarRepository rentCarRepository;
    private final CarRepository carRepository;

    public CarDTO createCar(CarDTO carDTO) throws Exception {
        Car car = CarsMapper.INSTANCE.dtoToCar(carDTO);
        if (carDTO.getRentCarId() != null) {
            if (rentCarRepository.findById(carDTO.getRentCarId()).isPresent()) {
                car.setRentCar(getRentCarById(String.valueOf(carDTO.getId())));
                carRepository.save(car);
            } else {
                throw new Exception("sdfjdsjfjdhf");
            }
        }
        carRepository.save(car);
        return CarsMapper.INSTANCE.carsToDTO(car);
    }

    private RentCar getRentCarById(String rent_card_Id) throws Exception {
        Optional<RentCar> optionalRentCard = rentCarRepository.findById(rent_card_Id);
        if (optionalRentCard.isPresent()) {
            return optionalRentCard.get();
        } else {
            throw new Exception("");
        }
    }

    public Car updateCar(String carId, CarDTO carDTO) throws Exception {
        Optional<Car> carOpt = carRepository.findById(Long.valueOf(carId));
        Optional<RentCar> rentCarOpt = rentCarRepository.findById(carDTO.getRentCarId());
        if (carOpt.isPresent()) {
            Car car = carOpt.get();
            if (rentCarOpt.isPresent()) {
                if (rentCarOpt.get().getId() != null) {
                    car.setRentCar(new RentCar());
                    car.setRentCar(rentCarOpt.get());
                    carRepository.save(car);
                } else {
                    throw new Exception("missing");
                }
            }
            return car;
        } else {
            throw new Exception("missing");
        }
    }
}
