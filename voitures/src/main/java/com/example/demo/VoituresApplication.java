package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.example.dao.CarRepository;
import com.example.demo.entities.Car;

@SpringBootApplication
public class VoituresApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoituresApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate=new RestTemplate();
		SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(5000);
		requestFactory.setReadTimeout(5000);
		restTemplate.setRequestFactory(requestFactory);
		return restTemplate;
	}
	
	/*
	 * @Bean CommandLineRunner start(CarRepository carRepository) { return args -> {
	 * Stream.of("A", "B", "C").forEach(cn -> { carRepository.save(new
	 * Car(null,cn,"test","test",Long.valueOf(0))); });
	 * carRepository.findAll().forEach(System.out::println); }; }
	 */
}
