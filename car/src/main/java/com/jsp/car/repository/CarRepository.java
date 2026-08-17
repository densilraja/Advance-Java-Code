package com.jsp.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.car.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

    public List<Car> findByPriceGreaterThan(double price);    
}
