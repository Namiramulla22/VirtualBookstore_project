package com.virtualBookstore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualBookstore.entities.Payment;

public interface PaymentDao  extends JpaRepository<Payment,String> {

}
