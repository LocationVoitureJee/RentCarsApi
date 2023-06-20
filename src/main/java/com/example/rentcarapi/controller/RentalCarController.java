package com.example.rentcarapi.controller;



import com.example.rentcarapi.dto.RentAmountRequestDto;
import com.example.rentcarapi.dto.RentalCarRequestDto;
import com.example.rentcarapi.dto.RentalCarResponseDto;
import com.example.rentcarapi.service.RentalCarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rent-cars-api/rental-cars")
public class RentalCarController {
    private final RentalCarService rentalCarService;

    public RentalCarController(RentalCarService rentalCarService) {
        this.rentalCarService = rentalCarService;
    }

    @GetMapping
    public List<RentalCarResponseDto> getAllRentalCars() {
        return rentalCarService.getAllRentalCars();
    }

    @GetMapping("/{id}")
    public RentalCarResponseDto getRentalCarById(@PathVariable UUID id) {
        return rentalCarService.getRentalCarById(id);
    }

    @PostMapping
    public ResponseEntity<Void> createRentalCar(@RequestBody RentalCarRequestDto rentalCarRequestDto) {
        rentalCarService.createRentalCar(rentalCarRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRentalCar(@PathVariable UUID id, @RequestBody RentalCarRequestDto rentalCarRequestDto) {
        rentalCarService.updateRentalCar(id, rentalCarRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> partiallyUpdateRentalCar(@PathVariable UUID id, @RequestBody RentAmountRequestDto rentAmountRequestDto) {
        rentalCarService.partiallyUpdateRentalCar(id, rentAmountRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRentalCar(@PathVariable UUID id) {
        rentalCarService.deleteRentalCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

