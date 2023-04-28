package com.example.motors.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    private String  carId;
    private String carName;
    private String price;
    private String brand;

    private String color;
    private String noOfSeats;
    private LocalDate availabilityDate;
    private String status;
}
