package com.example.rentcarapi.mapper;

import com.example.rentcarapi.models.RentalCarEntity;
import com.example.rentcarapi.dto.RentalCarRequestDto;
import com.example.rentcarapi.dto.RentalCarResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalCarDtoMapper {

    public List<RentalCarResponseDto> toDtoList(List<RentalCarEntity> rentalProperties) {
        return rentalProperties.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public RentalCarResponseDto toDto(RentalCarEntity rentalCar) {
        return new RentalCarResponseDto(
                rentalCar.getId(),
                rentalCar.getBrand(),
                rentalCar.getModel(),
                rentalCar.getRentAmount(),
                rentalCar.getSecurityDepositAmount(),
                rentalCar.getNumberOfSeats(),
                rentalCar.getNumberOfDoors(),
                rentalCar.getHasAirConditioning()
        );
    }


    public RentalCarEntity toEntity(RentalCarRequestDto rentalCarsRequestDto) {
        RentalCarEntity rentalCar = new RentalCarEntity();
        rentalCar.setBrand(rentalCarsRequestDto.getBrand());
        rentalCar.setModel(rentalCarsRequestDto.getModel());
        rentalCar.setRentAmount(rentalCarsRequestDto.getRentAmount());
        rentalCar.setSecurityDepositAmount(rentalCarsRequestDto.getSecurityDepositAmount());
        rentalCar.setNumberOfSeats(rentalCarsRequestDto.getNumberOfSeats());
        rentalCar.setNumberOfDoors(rentalCarsRequestDto.getNumberOfDoors());
        rentalCar.setHasAirConditioning(rentalCarsRequestDto.getHasAirConditioning());
        return rentalCar;
    }

    public void updateEntityFromDto(RentalCarRequestDto rentalCarsRequestDto, RentalCarEntity rentalCarEntity) {
        rentalCarEntity.setBrand(rentalCarsRequestDto.getBrand());
        rentalCarEntity.setModel(rentalCarsRequestDto.getModel());
        rentalCarEntity.setRentAmount(rentalCarsRequestDto.getRentAmount());
        rentalCarEntity.setSecurityDepositAmount(rentalCarsRequestDto.getSecurityDepositAmount());
        rentalCarEntity.setNumberOfSeats(rentalCarsRequestDto.getNumberOfSeats());
        rentalCarEntity.setNumberOfDoors(rentalCarsRequestDto.getNumberOfDoors());
        rentalCarEntity.setHasAirConditioning(rentalCarsRequestDto.getHasAirConditioning());
    }
}
