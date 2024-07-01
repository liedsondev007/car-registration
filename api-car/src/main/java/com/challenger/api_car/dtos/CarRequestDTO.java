package com.challenger.api_car.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CarRequestDTO {

    @NotBlank(message = "Modelo é obrigatório")
    private String model;

    @NotBlank(message = "Marca é obrigatória")
    private String brand;

    @NotBlank(message = "Cor é obrigatória")
    private String color;

    @NotBlank(message = "Ano de fabricação é obrigatório")
    private String fabricationYear;
}
