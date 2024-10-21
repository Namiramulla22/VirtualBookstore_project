package com.virtualBookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualBookstore.entities.Customer;
import com.virtualBookstore.Dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired    
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getCustomer() {
		// Fetching all customers
		return customerDao.findAll();  
	}
	
	@Override
	public Customer getCustomer(String C_ID) {
		// Using findById to fetch customer by ID
		Optional<Customer> optionalCustomer = customerDao.findById(C_ID);
		// Return the customer if found, or throw an exception if not found
		return optionalCustomer.orElseThrow(() -> new RuntimeException("Customer not found with ID: " + C_ID));
	}
	
	@Override
	public Customer addCustomer(Customer customer) {
		// Saving new customer
		customerDao.save(customer);  
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// Updating existing customer
		customerDao.save(customer);  
		return customer;
	}

	@Override
	public void deleteCustomer(String C_ID) {
		// Using findById to check if customer exists
		Optional<Customer> optionalCustomer = customerDao.findById(C_ID);
		Customer customer = optionalCustomer.orElseThrow(() -> new RuntimeException("Customer not found with ID: " + C_ID));
		// Deleting the customer
		customerDao.delete(customer);  
	}
}
