package com.example.rentcarapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "rental_car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalCarEntity {
    @GeneratedValue
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "rent_amount")
    private double rentAmount;

    @Column(name = "security_deposit_amount")
    private double securityDepositAmount;

    @Column(name = "number_of_seats")
    private int numberOfSeats;


    @Column(name = "number_of_doors")
    private int numberOfDoors;



    @Column(name = "has_air_conditioning ")
    private Boolean hasAirConditioning ;


    public RentalCarEntity(String brand,
                           String model, double rentAmount,
                           double securityDepositAmount, int numberOfSeats,
                            int numberOfDoors,Boolean hasAirConditioning) {
        this.brand = brand;
        this.model = model;
        this.rentAmount = rentAmount;
        this.securityDepositAmount = securityDepositAmount;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.hasAirConditioning = hasAirConditioning;
    }
}
