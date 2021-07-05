package com.pwc.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwc.cars.dao.CarsDAO;
import com.pwc.cars.entities.Cars;
@Service
public class CarsServiceImpl implements CarsService {
	@Autowired
	private CarsDAO carsDAO;
	@Override
	public Cars getByCar_id(int car_id) {
		Cars topic = carsDAO.getByCar_id(car_id);
		return topic;
	}	
	@Override
	public List<Cars> getAllCars(){
		return carsDAO.getAllCars();
	}
	@Override
	public synchronized boolean addCar(Cars car){
       if (carsDAO.carExists(car.getName(), car.getColour())) {
    	   return false;
       } else {
    	   carsDAO.addCar(car);
    	   return true;
       }
	}
	@Override
	public void updateCar(Cars car) {
		carsDAO.updateCar(car);
	}
	@Override
	public void deleteCar(int car_id) {
		carsDAO.deleteCar(car_id);
	}
}
