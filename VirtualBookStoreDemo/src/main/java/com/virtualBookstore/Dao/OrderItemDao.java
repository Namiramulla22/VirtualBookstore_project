package com.virtualBookstore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualBookstore.entities.OrderItem;


public interface OrderItemDao  extends JpaRepository<OrderItem,String> {

}
