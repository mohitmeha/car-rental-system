package com.technova.car_rental_system.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "bookings")
public class Booking {

    @Id
    private String id;
    private String carId;
    private String customerName;
    private LocalDate startDate;
    private LocalDate endDate;

}

