package com.springboot.pwc.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.pwc.entity.Car;
import com.springboot.pwc.entity.Car_Inventory;
import com.springboot.pwc.entity.Car_Rental_Tracker;
import com.springboot.pwc.repository.CarInventoryRepository;
import com.springboot.pwc.repository.CarRentalTrackerRepository;
import com.springboot.pwc.repository.CarRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;
		
	public Car saveCar(Car car) {
		return repository.save(car);
	}
	
	public List<Car> saveCars(List<Car> cars) {
		return repository.saveAll(cars);
	}
	
	public List<Car> getCars(){
		return repository.findAll();
	}
	
	public Car getCarByCar_id(int car_id){
		return repository.findById(car_id).orElse(null);
	}
	
	public Car getCarByName(String name){
		return repository.findByName(name);
	}
	
	public String deleteCar(int car_id) {
		repository.deleteById(car_id);
		return "Car deleted of id "+car_id;
	}
	
	public Car updateCar(Car car) {
		Car exisitingCar = repository.findById(car.getCar_id()).orElse(null);
		exisitingCar.setName(car.getName());
		exisitingCar.setColour(car.getColour());
		exisitingCar.setPrice(car.getPrice());
		
		return repository.save(exisitingCar);
	}
	
	@Autowired
	private CarInventoryRepository invrepo;
	
	public String borrowCar(Car_Inventory car) {
		//invrepo.deleteById(car_id);
		invrepo.delete(car);
		String mysqlUrl = "jdbc:mysql://localhost:8080/mydb";
	    Connection con;
		try {
			con = DriverManager.getConnection(mysqlUrl, "root", "admin");
			String query = "INSERT INTO CAR_RENTAL_TRACKER(car_id, start_time)VALUES (?, CURRENT_TIMESTAMP)";
			PreparedStatement pstmt = con.prepareStatement(query);
		    pstmt.setInt(1, 1);
		    pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return "Car borrowed of name: "+car.getName();
	}
	
	public Car_Inventory returnCar(Car_Inventory car) {

		String mysqlUrl = "jdbc:mysql://localhost:8080/mydb";
	    Connection con;
		try {
			con = DriverManager.getConnection(mysqlUrl, "root", "admin");
			String query = "INSERT INTO CAR_RENTAL_TRACKER(car_id, end_time)VALUES (?, CURRENT_TIMESTAMP)";
			PreparedStatement pstmt = con.prepareStatement(query);
		    pstmt.setInt(1, 1);
		    pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invrepo.save(car);
	}
	
	public List<Car_Inventory> getCarsInventory(){
		return invrepo.findAll();
	}
	
	@Autowired
	private CarRentalTrackerRepository trackrepo;
	
	public List<Car_Rental_Tracker> getCarsTracker(){
		return trackrepo.findAll();
	}
	
	
}