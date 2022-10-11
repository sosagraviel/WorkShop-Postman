package com.refactorizando.postman.example.controller;

import com.refactorizando.postman.example.dto.RentCarDTO;
import com.refactorizando.postman.example.mapper.RentCarsMapper;
import com.refactorizando.postman.example.repository.RentCarRepository;
import com.refactorizando.postman.example.service.RentCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return ResponseEntity.ok(rentCarService.getRentRarById(id));
    }
}
