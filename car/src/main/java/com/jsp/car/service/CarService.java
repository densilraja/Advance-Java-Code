package com.jsp.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.car.entity.Car;
import com.jsp.car.exception.BrandNotFound;
import com.jsp.car.repository.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository repo;

    public Car insert(Car car) {
        return repo.save(car);
    }

    public Car update(Car car, int id) {
        Optional<Car> optional = repo.findById(id);
        if (optional.isPresent()) {
            Car car2 = optional.get();
            car2.setBrand(car.getBrand());
            car2.setColor(car.getColor());
            car2.setPrice(car.getPrice());
            return repo.save(car2);
        }
        throw new BrandNotFound();
    }

    public List<Car> find(double price) {
        return repo.findByPriceGreaterThan(price);
    }
}
