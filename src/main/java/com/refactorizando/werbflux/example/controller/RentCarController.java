package com.refactorizando.werbflux.example.controller;

import com.refactorizando.werbflux.example.domain.RentCar;
import com.refactorizando.werbflux.example.dto.RentCarDTO;
import com.refactorizando.werbflux.example.mapper.RentCarsMapper;
import com.refactorizando.werbflux.example.repository.RentCarRepository;
import com.refactorizando.werbflux.example.service.RentCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rent_cars")
public class RentCarController {

    private final RentCarService rentCarService;
    private final RentCarRepository rentCarRepository;

    @PostMapping
    public ResponseEntity<RentCarDTO> register(@RequestBody RentCarDTO rentCarDTO) {
        return ResponseEntity.ok(rentCarService.createRentCar(rentCarDTO));
    }

    @GetMapping()
    public List<RentCarDTO> getCars() {
        return RentCarsMapper.INSTANCE.toCarsDTO(rentCarRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentCarDTO> getCars(@PathVariable String id) {
        Optional<RentCar> rentCar = rentCarRepository.findById(Long.valueOf(id));
        return ResponseEntity.ok(RentCarsMapper.INSTANCE.rentCarToDTO(rentCar.get()));
    }
}
