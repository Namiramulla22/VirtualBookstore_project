package com.virtualBookstore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualBookstore.entities.Order;

public interface OrderDao  extends JpaRepository<Order,String> {

}
