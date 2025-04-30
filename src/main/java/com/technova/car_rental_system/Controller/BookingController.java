
package com.technova.car_rental_system.controller;

import com.technova.car_rental_system.dto.BookingRequest;
import com.technova.car_rental_system.model.Booking;
import com.technova.car_rental_system.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/bookings")
    @Operation(summary = "Book a car")
    public ResponseEntity<Booking> bookCar(@RequestBody BookingRequest request) {
        Booking booking = bookingService.bookCar(
                request.getCarId(),
                request.getCustomerName(),
                request.getStartDate(),
                request.getEndDate()
        );
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/return/{bookingId}")
    @Operation(summary = "Return a booked car")
    public ResponseEntity<String> returnCar(@PathVariable String bookingId) {
        bookingService.returnCar(bookingId);
        return ResponseEntity.ok("Car returned and booking deleted.");
    }

    @GetMapping
    @Operation(summary = "Get all bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
}
