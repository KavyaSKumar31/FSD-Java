package com.example.crud.rest;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Customer;

@RestController
@RequestMapping("/api")
public class CustomerOperations {
	
	
	
	private List<Customer>customers=new ArrayList<Customer>();
	@PostConstruct
	public void init()
	{
		
		
		customers.add(new Customer("John", "Doe", "john@spring.io"));
		customers.add(new Customer("Shane", "Warne", "shane@luv2code.com"));
	}
	

	@GetMapping("/customers")
	public List<Customer> getAllCustomer()
	{
		return customers;
	}
	@PostMapping("/customers")
	public List<Customer> addCustomers(@RequestBody Customer theCustomer)
	{
		customers.add(theCustomer);
		return customers;
	}
	
	@PreDestroy
	public void destroy()
	{
	
		customers=null;
	}
	
}