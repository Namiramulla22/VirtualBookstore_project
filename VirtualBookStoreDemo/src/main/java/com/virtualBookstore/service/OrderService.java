package com.virtualBookstore.service;

import java.util.List;

import com.virtualBookstore.entities.Order;

public interface OrderService {
    public List<Order> getOrder();  // Returns a list of all orders
    public Order getOrder(String Order_id);  // Fetches an order by its ID
    public Order addOrder(Order order);  // Adds a new order
    public Order updateOrder(Order order);  // Updates an existing order
    public void deleteOrder(String Order_id);  // Deletes an order by its ID
}
