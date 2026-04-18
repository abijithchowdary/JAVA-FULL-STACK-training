package com.capg.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.entity.Address;
import com.capg.springboot.repository.AddressRepository;

@RestController
@RequestMapping("/address")
public class AddressController {
	private final AddressRepository addressRepository;
	public AddressController(AddressRepository addressRepository) {
		this.addressRepository =addressRepository;
	}
	
	@PostMapping
	public Address save(@RequestBody Address a) {
		return addressRepository.save(a);
	}
	@GetMapping
	public List<Address> getAll(){
		return addressRepository.findAll();
	}
}
