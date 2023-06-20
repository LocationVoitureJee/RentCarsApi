package com.example.rentcarapi.dto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RentalCarRequestDtoTest {

    @Test
    void testSetAndGetModel() {
        String model = "Model S";
        RentalCarRequestDto dto = new RentalCarRequestDto();
        dto.setModel(model);
        assertEquals(model, dto.getModel());
    }

    @Test
    void testSetAndGetBrand() {
        String brand = "Tesla";
        RentalCarRequestDto dto = new RentalCarRequestDto();
        dto.setBrand(brand);
        assertEquals(brand, dto.getBrand());
    }

    @Test
    void testSetAndGetRentAmount() {
        Double rentAmount = 120.0;
        RentalCarRequestDto dto = new RentalCarRequestDto();
        dto.setRentAmount(rentAmount);
        assertEquals(rentAmount, dto.getRentAmount());
    }
}
