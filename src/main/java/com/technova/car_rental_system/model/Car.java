
package com.technova.car_rental_system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "cars")
public class Car {

    @Id
    private String id;

    @Indexed
    private String model;

    @Indexed
    private String brand;

    private double rentalPricePerDay;

    @Builder.Default
    private boolean available = true;


    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", available=" + available +
                '}';
    }
}
