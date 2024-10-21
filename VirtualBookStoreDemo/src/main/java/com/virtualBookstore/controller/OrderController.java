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

import com.virtualBookstore.entities.Order;
import com.virtualBookstore.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Get the list of orders
    @GetMapping("/Order")
    public List<Order> getOrder() {
        return this.orderService.getOrder();
    }

    // Get an order by ID
    @GetMapping("/Order/{Order_id}")
    public Order getOrder(@PathVariable String orderId) {
        return this.orderService.getOrder(orderId);
    }

    @PostMapping("/Order")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        if (order.getCustomer() == null) {
            return ResponseEntity.badRequest().body(null); // or throw exception
        }
        
        Order savedOrder = orderService.addOrder(order);
        return ResponseEntity.ok(savedOrder);
    }


    // Update an existing order by ID
    @PutMapping("/Order{Order_id}")
    public ResponseEntity<Order> updateOrder(@PathVariable String Order_id, @RequestBody Order order) {
        try {
            // Ensure that the correct order ID is set
            order.setId(Order_id);
            Order updatedOrder = this.orderService.updateOrder(order);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete an order by ID
    @DeleteMapping("/Order/{Order_id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable String Order_id) {
        try {
            this.orderService.deleteOrder(Order_id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
