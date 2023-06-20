package com.example.rentcarapi.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RentAmountRequestDtoTest {

    @Test
    void testSetAndGetRentAmount() {
        Double rentAmount = 120.0;
        RentAmountRequestDto dto = new RentAmountRequestDto();
        dto.setRentAmount(rentAmount);
        assertEquals(rentAmount, dto.getRentAmount());
    }
}
