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

import com.virtualBookstore.entities.OrderItem;
import com.virtualBookstore.service.OrderItemService;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    // Get the list of order items
    @GetMapping("/OrderItem")
    public List<OrderItem> getOrderItems() {
        return this.orderItemService.getOrderItem();  // Call the service's getOrderItem() method to return all order items
    }

    // Get an order item by ID
    @GetMapping("/OrderItem/{orderItemId}")
    public OrderItem getOrderItem(@PathVariable String orderItemId) {
        return this.orderItemService.getOrderItem(orderItemId);  // Call the service's getOrderItem(String) method to get an order item by ID
    }

    // Add a new order item
    @PostMapping("/OrderItem")
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
        return this.orderItemService.addOrderItem(orderItem);  // Call the service's addOrderItem() method to save a new order item
    }

    // Update an existing order item by ID
    @PutMapping("/OrderItem/{orderItemId}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable String orderItemId, @RequestBody OrderItem orderItem) {
        try {
            // Set the orderItemId on the order item entity to ensure it updates the correct item
            orderItem.setId(orderItemId);
            OrderItem updatedOrderItem = this.orderItemService.updateOrderItem(orderItem);  // Call the service's updateOrderItem() method
            return new ResponseEntity<>(updatedOrderItem, HttpStatus.OK);  // Return the updated order item and 200 OK status
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // Return 500 if there's an error
        }
    }

    // Delete an order item by ID
    @DeleteMapping("/OrderItem/{orderItemId}")
    public ResponseEntity<HttpStatus> deleteOrderItem(@PathVariable String orderItemId) {
        try {
            this.orderItemService.deleteOrderItem(orderItemId);  // Call the service's deleteOrderItem() method to delete an order item by ID
            return new ResponseEntity<>(HttpStatus.OK);  // Return 200 OK on successful deletion
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // Return 500 if there's an error
        }
    }
}
