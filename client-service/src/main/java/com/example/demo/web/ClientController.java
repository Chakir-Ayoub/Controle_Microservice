package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.service.ClientService;

@RestController
@RequestMapping("client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	
	@GetMapping
	public List<Client> getAllClient(){
		return this.clientService.findAll();
	}
	@GetMapping(path = "{id}")
	public Client GetById(@PathVariable Long id) {
		return this.clientService.GetById(id);
	}
	
	@PostMapping
	public Client Add(@RequestBody Client client) {
		return this.clientService.Add(client);
	}
}
