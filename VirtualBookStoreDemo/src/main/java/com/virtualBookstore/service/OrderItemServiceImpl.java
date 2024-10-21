package com.virtualBookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualBookstore.entities.OrderItem;
import com.virtualBookstore.Dao.OrderItemDao;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired    
	private OrderItemDao orderItemDao;
	
	@Override
	public List<OrderItem> getOrderItem() {
		// Fetching all order items
		return orderItemDao.findAll();  
	}
	
	@Override
	public OrderItem getOrderItem(String OrderItem_id) {
		// Using findById to fetch order item by ID
		Optional<OrderItem> optionalOrderItem = orderItemDao.findById(OrderItem_id);
		// Return the order item if found, or throw an exception if not found
		return optionalOrderItem.orElseThrow(() -> new RuntimeException("OrderItem not found with ID: " + OrderItem_id));
	}
	
	@Override
	public OrderItem addOrderItem(OrderItem orderItem) {
		// Saving new order item
		orderItemDao.save(orderItem);  
		return orderItem;
	}

	@Override
	public OrderItem updateOrderItem(OrderItem orderItem) {
		// Updating existing order item
		orderItemDao.save(orderItem);  
		return orderItem;
	}

	@Override
	public void deleteOrderItem(String OrderItem_id) {
		// Using findById to check if order item exists
		Optional<OrderItem> optionalOrderItem = orderItemDao.findById(OrderItem_id);
		OrderItem orderItem = optionalOrderItem.orElseThrow(() -> new RuntimeException("OrderItem not found with ID: " + OrderItem_id));
		// Deleting the order item
		orderItemDao.delete(orderItem);  
	}
}
