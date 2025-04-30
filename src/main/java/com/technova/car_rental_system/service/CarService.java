
package com.technova.car_rental_system.service;

import com.technova.car_rental_system.model.Car;
import com.technova.car_rental_system.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car addCar(Car car) {
        car.setAvailable(true); // By default car available hai
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findByAvailableTrue(); // Sirf available cars
    }

    public List<Car> searchCars(String query) {
        return carRepository.findByModelContainingIgnoreCaseOrBrandContainingIgnoreCase(query, query);
    }

    // Soft delete: available = false
    public boolean markCarAsRented(String id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setAvailable(false); // Soft delete
            carRepository.save(car);
            return true;
        }
        return false;
    }
}
