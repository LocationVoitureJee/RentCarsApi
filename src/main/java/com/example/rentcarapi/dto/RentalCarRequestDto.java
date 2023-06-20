package com.example.rentcarapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalCarRequestDto {

        private String brand;
        private String model;
        private double rentAmount;
        private double securityDepositAmount;
        private int numberOfSeats;
        private int numberOfDoors;
        private Boolean hasAirConditioning;
}
