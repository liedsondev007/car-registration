package com.challenger.api_car.services;

import com.challenger.api_car.dtos.CarRequestDTO;
import com.challenger.api_car.dtos.CarResponseDTO;
import com.challenger.api_car.entities.Car;
import com.challenger.api_car.repositories.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    private static final Set<String> ALLOWED_BRANDS = Set.of("Ford", "Chevrolet", "BMW", "Volvo");

    public CarResponseDTO createCar(CarRequestDTO carRequestDTO){
        if (!ALLOWED_BRANDS.contains(carRequestDTO.getBrand())) {
            throw new EntityNotFoundException("Marca não encontrada.");
        }

        Car car = new Car();
        car.setModel(carRequestDTO.getModel());
        car.setBrand(carRequestDTO.getBrand());
        car.setColor(carRequestDTO.getColor());
        car.setFabricationYear(carRequestDTO.getFabricationYear());

        Car savedCar = carRepository.save(car);

        CarResponseDTO carResponseDTO = new CarResponseDTO();
        car.setChassiId(carResponseDTO.getChassiId());
        car.setModel(carResponseDTO.getModel());
        car.setBrand(carResponseDTO.getBrand());
        car.setColor(carResponseDTO.getColor());
        car.setFabricationYear(carResponseDTO.getFabricationYear());

        return carResponseDTO;
    }

    public CarResponseDTO getCar(Long chassiId){
        Car car = carRepository.findById(chassiId)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado."));

                CarResponseDTO carResponseDTO = new CarResponseDTO();
                carResponseDTO.setChassiId(car.getChassiId());
                carResponseDTO.setModel(car.getModel());
                carResponseDTO.setBrand(car.getBrand());
                carResponseDTO.setColor(car.getColor());
                carResponseDTO.setFabricationYear(car.getFabricationYear());

                return carResponseDTO;
    }
}
