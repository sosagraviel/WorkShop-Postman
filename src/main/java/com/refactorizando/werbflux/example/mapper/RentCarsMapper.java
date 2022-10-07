package com.refactorizando.werbflux.example.mapper;

import com.refactorizando.werbflux.example.domain.Car;
import com.refactorizando.werbflux.example.domain.RentCar;
import com.refactorizando.werbflux.example.dto.CarDTO;
import com.refactorizando.werbflux.example.dto.RentCarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RentCarsMapper {
    RentCarsMapper INSTANCE = Mappers.getMapper(RentCarsMapper.class);
    RentCarDTO rentCarToDTO(RentCar rentCar);
    RentCar dtoToRentCar(RentCarDTO rentCarDTO);
    List<RentCarDTO> toCarsDTO(List<RentCar> rentCars);
}
