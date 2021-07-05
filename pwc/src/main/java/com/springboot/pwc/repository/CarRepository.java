package com.springboot.pwc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pwc.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

	Car findByName(String name);

}
