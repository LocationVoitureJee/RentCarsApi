package com.example.rentcarapi.dto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RentalCarResponseDtoTest {

    @Test
    void testSetAndGetModel() {
        String model = "Model S";
        RentalCarResponseDto dto = new RentalCarResponseDto();
        dto.setModel(model);
        assertEquals(model, dto.getModel());
    }

    @Test
    void testSetAndGetBrand() {
        String brand = "Tesla";
        RentalCarResponseDto dto = new RentalCarResponseDto();
        dto.setBrand(brand);
        assertEquals(brand, dto.getBrand());
    }

    @Test
    void testSetAndGetRentAmount() {
        Double rentAmount = 120.0;
        RentalCarResponseDto dto = new RentalCarResponseDto();
        dto.setRentAmount(rentAmount);
        assertEquals(rentAmount, dto.getRentAmount());
    }

}
