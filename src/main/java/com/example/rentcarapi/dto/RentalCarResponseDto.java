package com.example.rentcarapi.dto;

import lombok.Builder;

@Builder
public record RentalCarResponseDto(String brand,
                                   String model,
                                   Double rent_amount,
                                   Double security_deposit_amount,
                                   Integer number_of_seats ,
                                   Integer number_of_doors,
                                   Boolean has_air_conditioning
                                   ) {
}
