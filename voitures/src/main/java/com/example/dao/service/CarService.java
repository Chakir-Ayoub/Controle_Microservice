package com.example.dao.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dao.CarRepository;
import com.example.demo.entities.Car;
import com.example.demo.entities.client;
import com.example.model.CarResponse;

import ch.qos.logback.core.net.server.Client;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private RestTemplate restTemplate;
	private final String URL="http://localhost:8081/client";
	
	
	public List<CarResponse> findAll() {
	    List<Car> cars = carRepository.findAll();
	    ResponseEntity<client[]> response =
	            restTemplate.getForEntity(this.URL, client[].class);
	    client[] clients = response.getBody();
	    return cars.stream().map((Car car) -> 
	    mapToCarResponse(car, clients)).toList();
	}
	
	private CarResponse mapToCarResponse(Car car,client[] clients) {
		client foundClient=Arrays.stream(clients)
				.filter(client->client.getId().equals(car.getClient_id()))
				.findFirst()
				.orElse(null);
		
		return  CarResponse.builder()
				.id(car.getId())
				.brand(car.getBrand())
				.client(foundClient)
				.matricue(car.getMatricule())
				.model(car.getModel())
				.build();
				
	}
	
	/*
	 * public CarResponse findById(Long id) throws Exception{ Car
	 * car=carRepository.findById(id).orElseThrow(()-> new
	 * Exception("Invalid Car Id")); client
	 * client=restTemplate.getForObject(this.URL+"/"+car.getClient_id(),Client.class
	 * );
	 * 
	 * return CarResponse.builder() .id(car.getId()) .brand(car.getBrand())
	 * .client(client) .matricue(car.getMatricule()) .model(car.getModel())
	 * .build(); }
	 */

}
