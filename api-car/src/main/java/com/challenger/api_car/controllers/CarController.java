package com.challenger.api_car.controllers;

import com.challenger.api_car.dtos.CarRequestDTO;
import com.challenger.api_car.dtos.CarResponseDTO;
import com.challenger.api_car.services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<CarResponseDTO> createCar(@Valid @RequestBody CarRequestDTO carRequestDTO) {
        CarResponseDTO carResponseDTO = carService.createCar(carRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(carResponseDTO);
    }

    @GetMapping("/{chassiId}")
    public ResponseEntity<CarResponseDTO> getCar(@PathVariable Long chassiId) {
        CarResponseDTO carResponseDTO = carService.getCar(chassiId);
        return ResponseEntity.ok().body(carResponseDTO);
    }
}

