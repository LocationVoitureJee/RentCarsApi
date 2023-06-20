package com.example.rentcarapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalCarResponseDto {

    private UUID id;
    private String brand;
    private String model;
    private double rentAmount;
    private double securityDepositAmount;
    private int numberOfSeats;
    private int numberOfDoors;
    private Boolean hasAirConditioning;
}
