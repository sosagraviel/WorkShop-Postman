package com.refactorizando.postman.example.service;

import com.refactorizando.postman.example.domain.RentCar;
import com.refactorizando.postman.example.dto.RentCarDTO;
import com.refactorizando.postman.example.exeptions.ErrorConstants;
import com.refactorizando.postman.example.exeptions.MissingRentCardException;
import com.refactorizando.postman.example.mapper.RentCarsMapper;
import com.refactorizando.postman.example.repository.RentCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentCarService {

    private final RentCarRepository rentCarRepository;
    private final RentCarsMapper rentCarsMapper;

    public RentCarDTO createRentCar(RentCarDTO rentCarDTO) {
        RentCar toRentCard;
        rentCarRepository.save(toRentCard = rentCarsMapper.dtoToRentCar(rentCarDTO));
        return rentCarsMapper.rentCarToDTO(toRentCard);
    }

    private RentCar getRentCarById(String rent_card_Id) {
        Optional<RentCar> optionalRentCard = rentCarRepository.findById(rent_card_Id);
        if (optionalRentCard.isPresent()) {
            return optionalRentCard.get();
        } else {
            throw new MissingRentCardException(ErrorConstants.MISSING_RENT_CAR);
        }
    }

    public RentCarDTO getRentRarById(String id) {
        Optional<RentCar> rentCar = rentCarRepository.findById(id);
        if (rentCar.isPresent()) {
            return RentCarsMapper.INSTANCE.rentCarToDTO(rentCar.get());
        } else {
            throw new MissingRentCardException(ErrorConstants.MISSING_RENT_CAR);
        }
    }
}
