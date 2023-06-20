package com.example.rentcarapi.controller;

import com.example.rentcarapi.controller.RentalCarController;
import com.example.rentcarapi.dto.RentAmountRequestDto;
import com.example.rentcarapi.dto.RentalCarRequestDto;
import com.example.rentcarapi.dto.RentalCarResponseDto;
import com.example.rentcarapi.service.RentalCarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.http.HttpStatus.*;

public class RentalCarControllerTest {

    @InjectMocks
    private RentalCarController rentalCarController;

    @Mock
    private RentalCarService rentalCarService;

    private AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = openMocks(this);
    }

    @Test
    void testGetAllRentalCars() {
        List<RentalCarResponseDto> expected = new ArrayList<>();
        when(rentalCarService.getAllRentalCars()).thenReturn(expected);
        List<RentalCarResponseDto> actual = rentalCarController.getAllRentalCars();
        assertEquals(expected, actual);
        verify(rentalCarService).getAllRentalCars();
    }

    @Test
    void testGetRentalCarById() {
        RentalCarResponseDto expected = new RentalCarResponseDto();
        UUID id = UUID.randomUUID();
        when(rentalCarService.getRentalCarById(id)).thenReturn(expected);
        RentalCarResponseDto actual = rentalCarController.getRentalCarById(id);
        assertEquals(expected, actual);
        verify(rentalCarService).getRentalCarById(id);
    }

    @Test
    void testCreateRentalCar() {
        RentalCarRequestDto requestDto = new RentalCarRequestDto();
        ResponseEntity<Void> expected = new ResponseEntity<>(CREATED);
        ResponseEntity<Void> actual = rentalCarController.createRentalCar(requestDto);
        assertEquals(expected, actual);
        verify(rentalCarService).createRentalCar(any(RentalCarRequestDto.class));
    }

    @Test
    void testUpdateRentalCar() {
        UUID id = UUID.randomUUID();
        RentalCarRequestDto requestDto = new RentalCarRequestDto();
        ResponseEntity<Void> expected = new ResponseEntity<>(OK);
        rentalCarController.updateRentalCar(id, requestDto);
        verify(rentalCarService).updateRentalCar(eq(id), any(RentalCarRequestDto.class));
    }


    @Test
    void testPartiallyUpdateRentalCar() {
        UUID id = UUID.randomUUID();
        RentAmountRequestDto rentAmountRequestDto = new RentAmountRequestDto();
        rentalCarController.partiallyUpdateRentalCar(id, rentAmountRequestDto);
        verify(rentalCarService).partiallyUpdateRentalCar(eq(id), any(RentAmountRequestDto.class));
    }


    @Test
    void testDeleteRentalCar() {
        UUID id = UUID.randomUUID();
        ResponseEntity<Void> expected = new ResponseEntity<>(NO_CONTENT);
        ResponseEntity<Void> actual = rentalCarController.deleteRentalCar(id);
        assertEquals(expected, actual);
        verify(rentalCarService).deleteRentalCar(id);
    }
}
