package com.example.motors.controller;

import com.example.motors.entity.Car;
import com.example.motors.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping("/{carId}")
    public Car getCarDetails(@PathVariable String carId) {
        return carService.getCarById(carId);
    }
    @GetMapping("/available")
    public List<Car> getCarByAvailabilityDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
        { return carService.getAvailableCarsByDate(date);
        }






}
