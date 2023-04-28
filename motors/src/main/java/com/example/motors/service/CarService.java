package com.example.motors.service;

import com.example.motors.entity.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarService {
    Car getCarById(String carId);
    List<Car> getAvailableCarsByDate(LocalDate date);
}
