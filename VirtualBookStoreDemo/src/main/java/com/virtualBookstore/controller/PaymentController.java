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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualBookstore.entities.Payment;
import com.virtualBookstore.service.PaymentService;

@RestController
@RequestMapping("/Payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Get the list of payments
    @GetMapping
    public List<Payment> getPayments() {
        return this.paymentService.getPayment();  // Call the service's getPayment() method to return all payments
    }

    // Get a payment by ID
    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable String id) {
        return this.paymentService.getPayment(id);  // Call the service's getPayment(String) method to get a payment by ID
    }

    // Add a new payment
    @PostMapping
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        Payment createdPayment = this.paymentService.addPayment(payment);  // Call the service's addPayment() method
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);  // Return 201 Created
    }

    // Update an existing payment by ID
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable String id, @RequestBody Payment payment) {
        try {
            // Set the payment ID on the payment entity to ensure it updates the correct payment
            payment.setId(id);
            Payment updatedPayment = this.paymentService.updatePayment(payment);  // Call the service's updatePayment() method
            return new ResponseEntity<>(updatedPayment, HttpStatus.OK);  // Return the updated payment and 200 OK status
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // Return 500 if there's an error
        }
    }

    // Delete a payment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePayment(@PathVariable String id) {
        try {
            this.paymentService.deletePayment(id);  // Call the service's deletePayment() method to delete a payment by ID
            return new ResponseEntity<>(HttpStatus.OK);  // Return 200 OK on successful deletion
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // Return 500 if there's an error
        }
    }
}
