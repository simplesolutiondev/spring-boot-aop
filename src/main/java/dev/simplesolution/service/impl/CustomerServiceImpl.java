package dev.simplesolution.service.impl;

import org.springframework.stereotype.Service;

import dev.simplesolution.domain.Customer;
import dev.simplesolution.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer get(Long id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Customer ID is invalid.");
		}
		Customer customer = new Customer();
		customer.setId(id);
		customer.setFirstName("John");
		customer.setLastName("Doe");
		customer.setPhone("123-456-789");
		return customer;
	}
	
}
