package com.virtualBookstore.service;

import java.util.List;

import com.virtualBookstore.entities.Customer;

public interface CustomerService {
	public List<Customer> getCustomer();
    public Customer getCustomer(String C_ID);
    public Customer addCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public void deleteCustomer(String C_ID);
}	
