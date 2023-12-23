package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.ClientRepository;
import com.example.demo.entities.Client;

@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ClientRepository clientRepository) {
	    return args -> {
	        Stream.of("A", "B", "C").forEach(cn -> {
	            clientRepository.save(new Client(null, cn, Float.valueOf(19)));
	        });
	        clientRepository.findAll().forEach(System.out::println);
	    };
	}


}
