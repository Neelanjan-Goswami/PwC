package com.pwc.cars.endpoint;

import java.net.URI;
import java.util.List;

import javax.validation.constraints.Past;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pwc.cars.entities.Cars;
import com.pwc.cars.service.CarsService;

@Component
//@Past("/Cars")
public class CarsRestService {
	private static final Logger logger = LoggerFactory.getLogger(CarsRestService.class);	
	
	@Autowired
	private CarsRestService carService;
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public Response createCar(Cars car) {
        boolean isAdded = ((CarsService) carService).addCar(car);
        if (!isAdded) {
        	logger.info("Car already exits.");
	        return Response.status(Status.CONFLICT).build();
        }
        return Response.created(URI.create("/Cars/car/"+ car.getCar_id())).build();
	}	
	
	@PUT
	@Path("/car/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public Response updateCar(Cars car) {
		carService.updateCar(car);
		return Response.ok(car).build();
	}

	@GET
	@Path("/car_id/{car_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public Response getTopicById(@PathParam("car_id") Integer car_id) {
		Cars car = ((CarsService) carService).getByCar_id(car_id);
		return Response.ok(car_id).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public Response getAllCars() {
		List<Cars> list = ((CarsService) carService).getAllCarz(); 
		return Response.ok(list).build();
	}
	
	@DELETE
	@Path("/car_id/{car_id}")
	@Consumes(MediaType.APPLICATION_JSON)	
	@CrossOrigin
	public Response deleteTopic(@PathParam("car_id") Integer car_id) {
		carService.deleteTopic(car_id);
		return Response.noContent().build();
	}	
}
