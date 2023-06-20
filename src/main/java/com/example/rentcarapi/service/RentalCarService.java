package com.example.rentcarapi.service;

import com.example.rentcarapi.dto.RentAmountRequestDto;
import com.example.rentcarapi.dto.RentalCarRequestDto;
import com.example.rentcarapi.dto.RentalCarResponseDto;
import com.example.rentcarapi.exception.NotFoundRentalCarException;
import com.example.rentcarapi.mapper.RentalCarDtoMapper;
import com.example.rentcarapi.models.RentalCarEntity;
import com.example.rentcarapi.repository.RentalCarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RentalCarService {
    private final RentalCarRepository rentalCarRepository;
    private final RentalCarDtoMapper rentalCarDtoMapper;

    public RentalCarService(RentalCarRepository rentalCarRepository, RentalCarDtoMapper rentalCarDtoMapper) {
        this.rentalCarRepository = rentalCarRepository;
        this.rentalCarDtoMapper = rentalCarDtoMapper;
    }

    public List<RentalCarResponseDto> getAllRentalCars() {
        List<RentalCarEntity> rentalCars = rentalCarRepository.findAll();
        return rentalCars.stream()
                .map(rentalCarDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public RentalCarResponseDto getRentalCarById(UUID id) {
        RentalCarEntity rentalCar = rentalCarRepository.findById(id)
                .orElseThrow(() -> new NotFoundRentalCarException("Car not found with id " + id));
        return rentalCarDtoMapper.toDto(rentalCar);
    }

    @Transactional
    public void createRentalCar(RentalCarRequestDto rentalCarRequestDto) {
        RentalCarEntity rentalCar = rentalCarDtoMapper.toEntity(rentalCarRequestDto);
        rentalCarRepository.save(rentalCar);
    }

    @Transactional
    public void updateRentalCar(UUID id, RentalCarRequestDto rentalCarRequestDto) {
        RentalCarEntity rentalCar = rentalCarRepository.findById(id)
                .orElseThrow(() -> new NotFoundRentalCarException("Car not found with id " + id));
        rentalCarDtoMapper.updateEntityFromDto(rentalCarRequestDto, rentalCar);
        rentalCarRepository.save(rentalCar);
    }

    @Transactional
    public void partiallyUpdateRentalCar(UUID id, RentAmountRequestDto rentAmountRequestDto) {
        RentalCarEntity rentalCar = rentalCarRepository.findById(id)
                .orElseThrow(() -> new NotFoundRentalCarException("Car not found with id " + id));
        rentalCar.setRentAmount(rentAmountRequestDto.getRentAmount());
        rentalCarRepository.save(rentalCar);
    }

    @Transactional
    public void deleteRentalCar(UUID id) {
        if (!rentalCarRepository.existsById(id)) {
            throw new NotFoundRentalCarException("Car not found with id " + id);
        }
        rentalCarRepository.deleteById(id);
    }
}
