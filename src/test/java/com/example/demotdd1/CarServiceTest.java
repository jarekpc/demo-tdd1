package com.example.demotdd1;


import com.example.demotdd1.exception.CarNotFoundException;
import com.example.demotdd1.model.Car;
import com.example.demotdd1.repository.CarRepository;
import com.example.demotdd1.service.CarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setup() {
        carService = new CarService(carRepository);
    }

    @Test
    public void getCarDetails_returnCarInfo() {
        given(carRepository.findByName("prius")).willReturn(new Car(1L,"hybrid", "prius"));

        Car car = carService.getCarDetails("prius");

        assertThat(car.getName()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");

    }

    @Test(expected = CarNotFoundException.class)
    public void getCarDetails_whenCarNotFound() {
        given(carRepository.findByName("honda")).willReturn(null);

        carService.getCarDetails("honda");

    }


}
