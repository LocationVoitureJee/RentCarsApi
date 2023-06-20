package com.example.rentcarapi.service;
import com.example.rentcarapi.dto.RentalCarRequestDto;
import com.example.rentcarapi.dto.RentAmountRequestDto;
import com.example.rentcarapi.models.RentalCarEntity;
import com.example.rentcarapi.mapper.RentalCarDtoMapper;
import com.example.rentcarapi.repository.RentalCarRepository;
import com.example.rentcarapi.exception.NotFoundRentalCarException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RentalCarServiceTest {

    @Mock
    private RentalCarRepository rentalCarRepository;
    @Mock
    private RentalCarDtoMapper rentalCarDtoMapper;
    @InjectMocks
    private RentalCarService rentalCarService;
    @Test
    void shouldThrowExceptionWhenCarNotFound() {
        UUID id = UUID.randomUUID();
        when(rentalCarRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundRentalCarException.class, () -> rentalCarService.getRentalCarById(id));
    }

    @Test
    void shouldCreateRentalCar() {
        RentalCarRequestDto rentalCarRequestDto = new RentalCarRequestDto("Tesla", "Model S", 200, 500, 5, 4, true);
        RentalCarEntity rentalCar = new RentalCarEntity("Tesla", "Model S", 200, 500, 5, 4, true);
        when(rentalCarDtoMapper.toEntity(rentalCarRequestDto)).thenReturn(rentalCar);
        rentalCarService.createRentalCar(rentalCarRequestDto);
        verify(rentalCarRepository).save(rentalCar);
    }

    @Test
    void shouldUpdateRentalCar() {
        UUID id = UUID.randomUUID();
        RentalCarRequestDto rentalCarRequestDto = new RentalCarRequestDto("Tesla", "Model S", 200, 500, 5, 4, true);
        RentalCarEntity rentalCar = new RentalCarEntity("Tesla", "Model S", 200, 500, 5, 4, true);
        when(rentalCarRepository.findById(id)).thenReturn(Optional.of(rentalCar));
        rentalCarService.updateRentalCar(id, rentalCarRequestDto);
        verify(rentalCarDtoMapper).updateEntityFromDto(rentalCarRequestDto, rentalCar);
        verify(rentalCarRepository).save(rentalCar);
    }

    @Test
    void shouldPartiallyUpdateRentalCar() {
        UUID id = UUID.randomUUID();
        RentAmountRequestDto rentAmountRequestDto = new RentAmountRequestDto(200);
        RentalCarEntity rentalCar = new RentalCarEntity("Tesla", "Model S", 200, 500, 5, 4, true);
        when(rentalCarRepository.findById(id)).thenReturn(Optional.of(rentalCar));
        rentalCarService.partiallyUpdateRentalCar(id, rentAmountRequestDto);
        verify(rentalCarRepository).save(rentalCar);
    }

    @Test
    void shouldDeleteRentalCar() {
        UUID id = UUID.randomUUID();
        when(rentalCarRepository.existsById(id)).thenReturn(true);
        rentalCarService.deleteRentalCar(id);
        verify(rentalCarRepository).deleteById(id);
    }
}
