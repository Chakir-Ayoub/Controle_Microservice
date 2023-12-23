package com.example.model;

import com.example.demo.entities.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
	
	private Long id;
	private String brand;
	private String model;
	private String matricue;
	private client client;
}
