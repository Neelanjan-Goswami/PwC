package com.springboot.pwc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pwc.entity.Car;
import com.springboot.pwc.service.CarService;
import com.springboot.pwc.entity.Car_Inventory;
import com.springboot.pwc.entity.Car_Rental_Tracker;

@RestController
public class CarController {
	
	@Autowired
	private CarService service;
	
	
	@PostMapping("/addCar")
	public Car addCar(@RequestBody Car car) {
		return service.saveCar(car);
	}

	@PostMapping("/addCars")
	public List<Car> addCars(@RequestBody List<Car> cars) {
		return service.saveCars(cars);
	}
	
	@GetMapping("/cars")
	public List<Car> findAllCars(){
		return service.getCars();
	}
	@GetMapping("/car/{car_id}")
	public Car findCarByCar_id(@PathVariable int car_id) {
		return service.getCarByCar_id(car_id);
	}
	@GetMapping("/car/{name}")
	public Car findCarByName(@PathVariable String name) {
		return service.getCarByName(name);
	}
	
	@PutMapping("/update")
	public Car updateCar(@RequestBody Car car) {
		return service.updateCar(car);
	}
	
	@DeleteMapping("/delete/{car_id}")
	public String deleteCar(@PathVariable int car_id) {
		return service.deleteCar(car_id);
	}
	
	@DeleteMapping("/borrowCar/{car_id}")
	public String borrowCar(@PathVariable Car_Inventory car) {
		return service.borrowCar(car);
	}
	
	@PostMapping("/returnCar")
	public Car_Inventory returnCar(@RequestBody Car_Inventory car) {
		return service.returnCar(car);
	}
	
	@GetMapping("/carsInventory")
	public List<Car_Inventory> findAllCarsInventory(){
		return service.getCarsInventory();
	}
	
	@GetMapping("/carsTracker")
	public List<Car_Rental_Tracker> findAllCarsTracker(){
		return service.getCarsTracker();
	}
}
