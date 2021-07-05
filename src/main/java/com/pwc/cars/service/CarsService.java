package com.pwc.cars.service;
import java.util.List;
import com.pwc.cars.entities.Cars;
public interface CarsService {
	public abstract List<Cars> getAllCars();
    public abstract Cars getByCar_id(int car_id);
    public abstract boolean addCar(Cars car);
    public abstract void updateCar(Cars car);
    public abstract void deleteCar(int car_id);
    //public abstract void borrowCar(Cars car);
  	//public abstract void returnCar(Cars car);
}
