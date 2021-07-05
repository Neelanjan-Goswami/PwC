package com.pwc.cars.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pwc.cars.entities.Cars;
@Transactional
@Repository
public class CarsDAOImpl implements CarsDAO {
	@PersistenceContext	
	private EntityManager entityManager;	

	@Override
	public Cars getByCar_id(int car_id) {
		return entityManager.find(Cars.class, car_id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cars> getAllCars() {
		String hql = "FROM CAR as t ORDER BY t.car_id";
		return (List<Cars>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addCar(Cars car) {
		entityManager.persist(car);
	}
	@Override
	public void updateCar(Cars car) {
		Cars dbcar = getByCar_id(car.getCar_id());
		dbcar.setName(car.getName());
		dbcar.setColour(car.getColour());
		
		entityManager.flush();
	}
	@Override
	public void deleteCar(int car_id) {
		entityManager.remove(getByCar_id(car_id));
	}
	@Override
	public boolean carExists(String name, String colour) {
		String hql = "FROM CAR as car WHERE car.name = ? and car.colour = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .setParameter(2, colour).getResultList().size();
		return count > 0 ? true : false;
	}
	
}
