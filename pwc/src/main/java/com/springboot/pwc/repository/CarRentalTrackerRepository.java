package com.springboot.pwc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pwc.entity.Car_Rental_Tracker;

public interface CarRentalTrackerRepository extends JpaRepository<Car_Rental_Tracker, Integer>{

	Car_Rental_Tracker findByName(String name);

}
