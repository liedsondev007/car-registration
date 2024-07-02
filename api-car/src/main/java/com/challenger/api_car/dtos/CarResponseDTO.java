package com.challenger.api_car.dtos;

import lombok.Data;

@Data
public class CarResponseDTO {

    private Long chassiId;
    private String model;
    private String brand;
    private String color;
    private String fabricationYear;
}
