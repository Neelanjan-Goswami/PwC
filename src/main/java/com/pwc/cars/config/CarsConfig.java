package com.pwc.cars.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.pwc.cars.endpoint.CarsRestService;

@Component
public class CarsConfig extends ResourceConfig{
	public CarsConfig() {
		register(CarsRestService.class);
	}
}