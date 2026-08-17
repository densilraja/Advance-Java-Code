package com.jsp.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.car.entity.Car;
import com.jsp.car.service.CarService;
import com.jsp.car.util.ResponseStructure;


@RestController
public class CarController {
    
    @Autowired
    private CarService service;

    @PostMapping("/cars")
    public ResponseStructure<Car> insertCar(@RequestBody Car car){
        Car car2 = service.insert(car);
        ResponseStructure<Car> rs = new ResponseStructure<>();
        rs.setStatus(HttpStatus.CREATED.value());
        rs.setMessage("Car Added Successfully");
        rs.setData(car2);
        return rs;
    }

    @PatchMapping("/cars/{id}")
    public ResponseStructure<Car> updateCar(@RequestBody Car car, @PathVariable int id){ 
        Car car2 = service.update(car, id);
        ResponseStructure<Car> rs = new ResponseStructure<>();
        rs.setStatus(HttpStatus.OK.value());
        rs.setMessage("Car Updated Successfully");
        rs.setData(car2);
        return rs;
    }

    @PostMapping("/cars/{price}")
    public ResponseStructure<List<Car>> findCar(@PathVariable double price){
        List<Car> cars = service.find(price);
        ResponseStructure<List<Car>> rs = new ResponseStructure<>();
        rs.setStatus(HttpStatus.OK.value());
        rs.setMessage("Cars found successfully");
        rs.setData(cars);
        return rs;
    }
}
