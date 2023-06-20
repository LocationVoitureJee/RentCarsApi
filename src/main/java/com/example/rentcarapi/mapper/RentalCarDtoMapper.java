package com.example.rentcarapi.mapper;

import com.example.rentcarapi.models.RentalCarEntity;
import com.example.rentcarapi.dto.RentalCarRequestDto;
import com.example.rentcarapi.dto.RentalCarResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalCarDtoMapper {

    public List<RentalCarResponseDto> mapToDtoList(List<RentalCarEntity> rentalProperties) {
        return rentalProperties.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public RentalCarResponseDto mapToDto(RentalCarEntity rentalCar) {
        return new RentalCarResponseDto(
                rentalCar.getBrand(),
                rentalCar.getModel(),
                rentalCar.getRentAmount(),
                rentalCar.getSecurityDepositAmount(),
                rentalCar.getNumberOfSeats(),
                rentalCar.getNumberOfDoors(),
                rentalCar.getHasAirConditioning()
                );
    }

    public RentalCarEntity mapToEntity(RentalCarRequestDto rentalCarsRequestDto) {
        return new RentalCarEntity(
                rentalCarsRequestDto.brand(),
                rentalCarsRequestDto.model(),
                rentalCarsRequestDto.rentAmount(),
                rentalCarsRequestDto.securityDepositAmount(),
                rentalCarsRequestDto.numberOfSeats(),
                rentalCarsRequestDto.numberOfDoors(),
                rentalCarsRequestDto.hasAirConditioning()
          );

}
}
