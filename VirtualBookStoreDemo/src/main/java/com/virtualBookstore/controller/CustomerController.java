package com.virtualBookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtualBookstore.entities.Customer;
import com.virtualBookstore.service.CustomerService;

@RestController  // Add RestController annotation to make it a REST controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Get the list of customers
	@GetMapping("/Customer")
	public List<Customer> getCustomer() {
		return this.customerService.getCustomer();
	}

	// Get a customer by ID
	@GetMapping("/Customer/{C_ID}")
	public Customer getCustomer(@PathVariable String C_ID) {
		return this.customerService.getCustomer(C_ID);
	}

	// Add a new customer
	@PostMapping("/Customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return this.customerService.addCustomer(customer);
	}

	// Update an existing customer by ID
	@PutMapping("/Customer/{C_ID}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable String C_ID, @RequestBody Customer customer) {
		try {
			// Ensure that the correct Customer ID is set
			customer.setId(C_ID);
			Customer updatedCustomer = this.customerService.updateCustomer(customer);
			return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete a customer by ID
	@DeleteMapping("/Customer/{C_ID}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String C_ID) {
		try {
			this.customerService.deleteCustomer(C_ID);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
