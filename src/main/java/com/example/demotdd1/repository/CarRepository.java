package com.example.demotdd1.repository;

import com.example.demotdd1.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    Car findByName(String name);


}
