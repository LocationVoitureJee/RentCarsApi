package com.example.rentcarapi.controller;



import com.example.rentcarapi.dto.RentalCarRequestDto;
import com.example.rentcarapi.dto.RentalCarResponseDto;
import com.example.rentcarapi.exception.NotFoundRentalCarException;
import com.example.rentcarapi.mapper.RentalCarDtoMapper;
import com.example.rentcarapi.models.RentalCarEntity;
import com.example.rentcarapi.repository.RentalCarRepository;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/rent-cars-api")
@Validated
public class RentalCarController {

    private final RentalCarRepository rentalCarRepository;

    private final RentalCarDtoMapper rentalCarDtoMapper;

    public RentalCarController(RentalCarRepository rentalCarRepository, RentalCarDtoMapper rentalCarDtoMapper) {
        this.rentalCarRepository = rentalCarRepository;
        this.rentalCarDtoMapper = rentalCarDtoMapper;
    }

    @GetMapping("/rental-cars")
    public List<RentalCarResponseDto> getRentalcars() {
        List<RentalCarEntity> rentalcars = rentalCarRepository.findAll();
        System.out.println(rentalcars.get(0).getId());
        return rentalCarDtoMapper.mapToDtoList(rentalcars);
    }

    @GetMapping("/rental-cars/{id}")
    public RentalCarResponseDto getRentalPropertyById(@PathVariable String id) {
        return rentalCarRepository.findById(UUID.fromString(id))
                .map(rentalCarDtoMapper::mapToDto)
                .orElseThrow(() -> new NotFoundRentalCarException("Le bien immobilier " + id + " est introuvable"));
    }

    @PostMapping("/rental-cars")
    @ResponseStatus(CREATED)
    public void createRentalProperty(@Valid @RequestBody RentalCarRequestDto rentalPropertyRequestDto){



        RentalCarEntity rentalCarEntity = rentalCarDtoMapper.mapToEntity(rentalPropertyRequestDto );

        rentalCarRepository.save(rentalCarEntity);
    }

    @PutMapping("/rental-cars/{id}")
    @ResponseStatus(OK)
    public void updateRentalProperty(@PathVariable UUID id, @Valid @RequestBody RentalCarRequestDto rentalPropertyRequestDto) {

        RentalCarEntity rentalCarEntityOld = rentalCarRepository.findById(id) .orElseThrow(() -> new NotFoundRentalCarException("Le bien  " + id + " est introuvable"));


        RentalCarEntity rentalCarEntity = rentalCarDtoMapper.mapToEntity(rentalPropertyRequestDto);
        rentalCarEntity.setId(rentalCarEntityOld.getId());
        rentalCarRepository.save(rentalCarEntity);
    }

   /* @PatchMapping("/rental-cars/{id}")
    @ResponseStatus(OK)
    public void updateRentalPropertyAmount(@PathVariable UUID id, @Valid @RequestBody RentAmountRequestDto rentAmountRequestDto) {

        RentalCarEntity rentalCarEntity = rentalCarRepository.findById(id) .orElseThrow(() -> new NotFoundRentalCarException("Le bien  " + id + " est introuvable"));
        rentalCarEntity.setRentAmount(rentAmountRequestDto.rentAmount());
        rentalCarRepository.save(rentalCarEntity);
    }*/

    @DeleteMapping("/rental-cars/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteRentalPropertyById(@PathVariable UUID id) {
        Optional<RentalCarEntity> rentalProperty = rentalCarRepository.findById(id);
        if(rentalProperty.isPresent())
            rentalCarRepository.delete(rentalProperty.get());
    }

}
