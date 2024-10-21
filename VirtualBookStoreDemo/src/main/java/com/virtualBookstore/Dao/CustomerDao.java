package com.virtualBookstore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualBookstore.entities.Customer;


public interface CustomerDao extends JpaRepository<Customer,String>  {

}
