package com.technova.car_rental_system.repository;

import com.technova.car_rental_system.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CarRepository extends MongoRepository<Car, String> {


    List<Car> findByAvailableTrue();
    List<Car> findByModelContainingIgnoreCaseOrBrandContainingIgnoreCase(String model, String brand);
}

