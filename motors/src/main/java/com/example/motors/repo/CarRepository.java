package com.example.motors.repo;

import com.example.motors.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,String> {
    List<Car> findAllByAvailabilityDateAndStatus(LocalDate date, String available);
}
