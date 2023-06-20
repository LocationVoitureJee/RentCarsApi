package com.example.rentcarapi.model;
import com.example.rentcarapi.models.RentalCarEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalCarEntityTest {

    //N'est plus utile pour le coverage. On fait déjà ces tests ailleurs
    @Test
    void testRentalCarEntity() {
        RentalCarEntity rentalCarEntity = new RentalCarEntity();
        rentalCarEntity.setBrand("Tesla");
        rentalCarEntity.setModel("Model S");
        rentalCarEntity.setRentAmount(200);
        rentalCarEntity.setSecurityDepositAmount(500);
        rentalCarEntity.setNumberOfSeats(5);
        rentalCarEntity.setNumberOfDoors(4);
        rentalCarEntity.setHasAirConditioning(true);
        assertEquals("Tesla", rentalCarEntity.getBrand());
        assertEquals("Model S", rentalCarEntity.getModel());
        assertEquals(200, rentalCarEntity.getRentAmount());
        assertEquals(500, rentalCarEntity.getSecurityDepositAmount());
        assertEquals(5, rentalCarEntity.getNumberOfSeats());
        assertEquals(4, rentalCarEntity.getNumberOfDoors());
        assertEquals(true, rentalCarEntity.getHasAirConditioning());
    }
}
