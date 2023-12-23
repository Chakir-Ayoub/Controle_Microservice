package com.example.dao.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.service.CarService;
import com.example.model.CarResponse;

@RestController
@RequestMapping("car")
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping
	public List<CarResponse> findAll(){
		return carService.findAll();
	}
}
