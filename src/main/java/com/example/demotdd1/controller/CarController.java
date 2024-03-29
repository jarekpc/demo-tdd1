package com.example.demotdd1.controller;

import com.example.demotdd1.exception.CarNotFoundException;
import com.example.demotdd1.model.Car;
import com.example.demotdd1.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name){
        return carService.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException e){

    }


}
