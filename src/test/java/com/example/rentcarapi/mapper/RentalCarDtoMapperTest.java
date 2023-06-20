package com.example.rentcarapi.mapper;
import org.junit.jupiter.api.Test;
import com.example.rentcarapi.models.RentalCarEntity;
import com.example.rentcarapi.dto.RentalCarRequestDto;
import com.example.rentcarapi.dto.RentalCarResponseDto;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalCarDtoMapperTest {

    RentalCarDtoMapper mapper = new RentalCarDtoMapper();

    @Test
    void testToDtoList() {
        RentalCarEntity carEntity = new RentalCarEntity();
        carEntity.setBrand("Tesla");
        carEntity.setModel("Model S");
        List<RentalCarEntity> carEntities = Arrays.asList(carEntity);
        List<RentalCarResponseDto> responseDtos = mapper.toDtoList(carEntities);
        assertEquals(1, responseDtos.size());
        assertEquals(carEntity.getBrand(), responseDtos.get(0).getBrand());
        assertEquals(carEntity.getModel(), responseDtos.get(0).getModel());
    }

    @Test
    void testToDto() {
        RentalCarEntity carEntity = new RentalCarEntity();
        carEntity.setBrand("Tesla");
        carEntity.setModel("Model S");
        RentalCarResponseDto responseDto = mapper.toDto(carEntity);
        assertEquals(carEntity.getBrand(), responseDto.getBrand());
        assertEquals(carEntity.getModel(), responseDto.getModel());
    }

    @Test
    void testToEntity() {
        RentalCarRequestDto requestDto = new RentalCarRequestDto();
        requestDto.setBrand("Tesla");
        requestDto.setModel("Model S");
        RentalCarEntity carEntity = mapper.toEntity(requestDto);
        assertEquals(requestDto.getBrand(), carEntity.getBrand());
        assertEquals(requestDto.getModel(), carEntity.getModel());
    }

    @Test
    void testUpdateEntityFromDto() {
        RentalCarRequestDto requestDto = new RentalCarRequestDto();
        requestDto.setBrand("Tesla");
        requestDto.setModel("Model S");
        RentalCarEntity carEntity = new RentalCarEntity();
        carEntity.setBrand("BMW");
        carEntity.setModel("3 Series");
        mapper.updateEntityFromDto(requestDto, carEntity);
        assertEquals(requestDto.getBrand(), carEntity.getBrand());
        assertEquals(requestDto.getModel(), carEntity.getModel());
    }
}
