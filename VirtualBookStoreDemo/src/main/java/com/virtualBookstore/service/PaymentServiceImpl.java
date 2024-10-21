package com.virtualBookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualBookstore.Dao.PaymentDao;
import com.virtualBookstore.entities.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;  // Injecting PaymentDao

    @Override
    public List<Payment> getPayment() {
        // Fetch all payments using findAll method from the DAO
        return paymentDao.findAll();
    }

    @Override
    public Payment getPayment(String Payment_id) {
        // Using findById to fetch payment by ID
        Optional<Payment> optionalPayment = paymentDao.findById(Payment_id);
        // Return the payment if found, or throw an exception if not found
        return optionalPayment.orElseThrow(() -> new RuntimeException("Payment not found with ID: " + Payment_id));
    }

    @Override
	public Payment addPayment(Payment payment) {
    	paymentDao.save(payment);  // Saving new author
		return payment;
	}


    @Override
    public Payment updatePayment(Payment payment) {
        // Update the payment using DAO
        paymentDao.save(payment);
        return payment;
    }

    @Override
    public void deletePayment(String Payment_id) {
        // Using findById to check if the payment exists
        Optional<Payment> optionalPayment = paymentDao.findById(Payment_id);
        Payment payment = optionalPayment.orElseThrow(() -> new RuntimeException("Payment not found with ID: " + Payment_id));
        // Delete the payment if found
        paymentDao.delete(payment);
    }
}
