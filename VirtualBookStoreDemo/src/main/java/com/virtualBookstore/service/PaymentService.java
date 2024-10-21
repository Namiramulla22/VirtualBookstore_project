package com.virtualBookstore.service;

import java.util.List;

import com.virtualBookstore.entities.Payment;

public interface PaymentService {
	public List<Payment> getPayment();
    public Payment getPayment(String Payment_id);
    public Payment addPayment(Payment payment);
    public Payment updatePayment(Payment payment);
    public void deletePayment(String Payment_id);
}
