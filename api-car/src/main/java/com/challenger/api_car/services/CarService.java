package com.challenger.api_car.services;

import com.challenger.api_car.dtos.CarRequestDTO;
import com.challenger.api_car.dtos.CarResponseDTO;
import com.challenger.api_car.entities.Car;
import com.challenger.api_car.excepitions.CarServiceException;
import com.challenger.api_car.repositories.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    private static final Set<String> ALLOWED_BRANDS = Set.of("Ford", "Chevrolet", "BMW", "Volvo");

    public CarResponseDTO createCar(CarRequestDTO carRequestDTO) {
        validateCarRequest(carRequestDTO);

        if (!ALLOWED_BRANDS.contains(carRequestDTO.getBrand())) {
            throw new CarServiceException("Marca não permitida: " + carRequestDTO.getBrand());
        }

        Car car = new Car();
        car.setModel(carRequestDTO.getModel());
        car.setBrand(carRequestDTO.getBrand());
        car.setColor(carRequestDTO.getColor());
        car.setFabricationYear(carRequestDTO.getFabricationYear());

        try {
            Car savedCar = carRepository.save(car);

            CarResponseDTO carResponseDTO = new CarResponseDTO();
            carResponseDTO.setChassiId(savedCar.getChassiId());
            carResponseDTO.setModel(savedCar.getModel());
            carResponseDTO.setBrand(savedCar.getBrand());
            carResponseDTO.setColor(savedCar.getColor());
            carResponseDTO.setFabricationYear(savedCar.getFabricationYear());

            return carResponseDTO;
        } catch (DataAccessException e) {
            throw new CarServiceException("Erro ao cadastrar carro: " + e.getMessage(), e);
        }
    }

    public CarResponseDTO getCar(Long chassiId) {
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

    private void validateCarRequest(CarRequestDTO carRequestDTO) {
        if (carRequestDTO.getModel() == null ||
                carRequestDTO.getColor() == null ||
                carRequestDTO.getFabricationYear() == null) {
            throw new IllegalArgumentException("Todos os campos são obrigatórios.");
        }
    }
}

