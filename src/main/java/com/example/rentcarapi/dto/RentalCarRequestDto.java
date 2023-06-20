package com.example.rentcarapi.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
@Builder
public record RentalCarRequestDto(
        @NotNull
        @Size(max = 200)
        String brand,

        @NotNull
        String model,

        @NotNull
        Double rentAmount,

        @NotNull
        Double securityDepositAmount,


        @Positive
        Integer numberOfSeats,


        @Positive
        Integer numberOfDoors,


        Boolean hasAirConditioning) {

}
