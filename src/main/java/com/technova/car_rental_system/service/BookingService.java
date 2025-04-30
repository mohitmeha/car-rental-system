
package com.technova.car_rental_system.service;

import com.technova.car_rental_system.model.Booking;
import com.technova.car_rental_system.model.Car;
import com.technova.car_rental_system.repository.BookingRepository;
import com.technova.car_rental_system.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;

    public Booking bookCar(String carId, String customerName, LocalDate startDate, LocalDate endDate) {
        Optional<Car> carOpt = carRepository.findById(carId);
        if (carOpt.isEmpty() || !carOpt.get().isAvailable()) {
            throw new RuntimeException("Car is not available for booking");
        }

        Car car = carOpt.get();
        car.setAvailable(false);
        carRepository.save(car);

        Booking booking = Booking.builder()
                .carId(carId)
                .customerName(customerName)
                .startDate(startDate)
                .endDate(endDate)
                .build();

        return bookingRepository.save(booking);
    }

    public void returnCar(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Car car = carRepository.findById(booking.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        car.setAvailable(true);
        carRepository.save(car);

        bookingRepository.deleteById(bookingId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
