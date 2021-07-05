package com.springboot.pwc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pwc.entity.Car_Inventory;

public interface CarInventoryRepository extends JpaRepository<Car_Inventory, Integer>{

	Car_Inventory findByName(String name);

}
