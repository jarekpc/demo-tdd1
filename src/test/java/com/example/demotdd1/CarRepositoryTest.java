package com.example.demotdd1;

import com.example.demotdd1.model.Car;
import com.example.demotdd1.repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void getCar_returnCarDetails() {
//        given(carRepository.findByName("prius")).willReturn(new Car(1L,"hibrid","prius"));
        Car car = carRepository.save(new Car(1L, "hibrid", "prius"));
        assertThat(car.getName()).isEqualTo("prius");
    }
}
