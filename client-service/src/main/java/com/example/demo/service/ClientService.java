package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.entities.Client;


@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	
	public List<Client> findAll(){
		return  this.clientRepository.findAll();
	}
	
	public Client GetById(long id) {
		return this.clientRepository.findById(id).get();
	}
	
	public Client Add(Client client) {
		return this.clientRepository.save(client);
	}
}
