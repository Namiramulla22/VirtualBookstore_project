package com.virtualBookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualBookstore.Dao.OrderDao;
import com.virtualBookstore.entities.Order;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;  // Injecting OrderDao

    @Override
    public List<Order> getOrder() {
        // Fetch all orders using findAll method from the DAO
        return orderDao.findAll();
    }

    @Override
    public Order getOrder(String Order_id) {
        // Using findById to fetch order by ID
        Optional<Order> optionalOrder = orderDao.findById(Order_id);
        // Return the order if found, or throw an exception if not found
        return optionalOrder.orElseThrow(() -> new RuntimeException("Order not found with ID: " + Order_id));
    }

    @Override
    public Order addOrder(Order order) {
        // Save new order using DAO
        orderDao.save(order);
        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        // Update the order using DAO
        orderDao.save(order);
        return order;
    }

    @Override
    public void deleteOrder(String Order_id) {
        // Using findById to check if the order exists
        Optional<Order> optionalOrder = orderDao.findById(Order_id);
        Order order = optionalOrder.orElseThrow(() -> new RuntimeException("Order not found with ID: " + Order_id));
        // Delete the order if found
        orderDao.delete(order);
    }
}
