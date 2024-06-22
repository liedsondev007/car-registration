package com.challenger.api_car.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CarRequestDTO {

    @NotBlank
    private String model;
    @NotBlank
    private String brand;
    @NotBlank
    private String color;
    @NotBlank
    private String fabricationYear;
}
