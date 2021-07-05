package com.pwc.cars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pwc.cars.entities.Cars;


@SpringBootApplication
public class CarsApplication {
	public static void main(String[] args) {
		SpringApplication.run(Cars.class, args);
	}

}
