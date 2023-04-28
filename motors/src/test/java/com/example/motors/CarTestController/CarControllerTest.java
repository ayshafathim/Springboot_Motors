package com.example.motors.CarTestController;

import com.example.motors.controller.CarController;
import com.example.motors.entity.Car;
import com.example.motors.service.CarService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CarControllerTest {
//    @Autowired
    @InjectMocks
    private CarController carController;
    @Mock
    private CarService carService;
    @Test
    public void testGetCarDetails(){
        Car car=new Car();
        car.setCarId("123");
        car.setCarName("Toyota Corolla");
        car.setPrice("300000");
        car.setBrand("Toyota");
        car.setColor("Red");
        car.setNoOfSeats("6");
        car.setAvailabilityDate(LocalDate.of(2023,5,1));
        car.setStatus("Available");
        Mockito.when(carService.getCarById("123")).thenReturn(car);
        Car returnedCar=carController.getCarDetails("123");
        assertEquals(car,returnedCar);
    }
    @Test
    public void testGetCarByAvailabilityDate() {
         LocalDate date = LocalDate.of(2023, 5, 1);
         Car car1 = new Car();
         car1.setCarId("123");
         car1.setCarName("Toyota Corolla");
         car1.setPrice("20000");
         car1.setBrand("Toyota");
         car1.setColor("Red");
         car1.setNoOfSeats("5");
         car1.setAvailabilityDate(date);
         car1.setStatus("Available");

         Car car2 = new Car();
         car2.setCarId("456");
         car2.setCarName("Honda Civic");
         car2.setPrice("15000");
         car2.setBrand("Honda");
         car2.setColor("Blue");
         car2.setNoOfSeats("5");
         car2.setAvailabilityDate(date);
         car2.setStatus("Available");

         Mockito.when(carService.getAvailableCarsByDate(date)).thenReturn(Arrays.asList(car1, car2));


        List<Car> returnedCars = carController.getCarByAvailabilityDate(date);


        assertEquals(2, returnedCars.size());
        assertTrue(returnedCars.contains(car1));
        assertTrue(returnedCars.contains(car2));
        }




}



