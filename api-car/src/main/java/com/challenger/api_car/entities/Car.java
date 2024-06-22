package com.challenger.api_car.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cars")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chassiId;
    private String model;
    private String brand;
    private String color;
    private String fabricationYear;

}
