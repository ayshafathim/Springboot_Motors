package com.example.motors.service;

import com.example.motors.entity.Car;
import com.example.motors.repo.CarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
  private final CarRepository carRepository;



         public CarServiceImpl(CarRepository carRepository) {
           this.carRepository = carRepository;
        }

        @Override
        public Car getCarById(String carId) {
        return carRepository.findById(carId).orElse(null);
        }

        @Override
        public List<Car> getAvailableCarsByDate(LocalDate date) {
        return carRepository.findAllByAvailabilityDateAndStatus(date, "Available");
        }
}

