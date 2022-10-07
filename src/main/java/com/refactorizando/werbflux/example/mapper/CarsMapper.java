package com.refactorizando.werbflux.example.mapper;
import org.mapstruct.Mapper;
import com.refactorizando.werbflux.example.domain.Car;
import com.refactorizando.werbflux.example.dto.CarDTO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarsMapper {
    CarsMapper INSTANCE = Mappers.getMapper(CarsMapper.class);
    @Mapping(source = "rentCar.id",target = "rentCarId")
    CarDTO carsToDTO(Car car);
    Car dtoToCar(CarDTO carDTO);
//    @Mapping(source = "rentCar.id",target = "rentCarId")
    List<CarDTO> toCarsDTO(List<Car> cars);
}
