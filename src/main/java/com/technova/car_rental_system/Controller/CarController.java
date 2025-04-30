package com.technova.car_rental_system.Controller;

import com.technova.car_rental_system.model.Car;
import com.technova.car_rental_system.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @Operation(summary = "Add a new car", description = "Adds a new car to the inventory")
    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.addCar(car));
    }

    @Operation(summary = "Get all available cars", description = "Retrieves all cars that are currently available")
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @Operation(summary = "Search cars", description = "Searches for cars by model or brand")
    @GetMapping("/search")
    public ResponseEntity<List<Car>> searchCars(@RequestParam String query) {
        return ResponseEntity.ok(carService.searchCars(query));
    }

    @Operation(summary = "Mark car as rented", description = "Marks the car as rented (soft delete)")
    @PutMapping("/rent/{id}")
    public ResponseEntity<String> markCarAsRented(@PathVariable String id) {
        boolean updated = carService.markCarAsRented(id);
        if (updated) {
            return ResponseEntity.ok("Car with ID " + id + " is now marked as rented.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
