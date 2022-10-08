package com.refactorizando.werbflux.example.service;

import com.refactorizando.werbflux.example.domain.RentCar;
import com.refactorizando.werbflux.example.dto.RentCarDTO;
import com.refactorizando.werbflux.example.exeptions.ErrorConstants;
import com.refactorizando.werbflux.example.exeptions.MissingRentCardException;
import com.refactorizando.werbflux.example.mapper.RentCarsMapper;
import com.refactorizando.werbflux.example.repository.RentCarRepository;
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
}
