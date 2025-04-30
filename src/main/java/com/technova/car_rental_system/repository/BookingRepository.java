
package com.technova.car_rental_system.repository;

import com.technova.car_rental_system.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByCarId(String carId);
    List<Booking> findByCustomerName(String customerName);
}
