package com.refactorizando.postman.example.mapper;

import com.refactorizando.postman.example.domain.RentCar;
import com.refactorizando.postman.example.dto.RentCarDTO;
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
