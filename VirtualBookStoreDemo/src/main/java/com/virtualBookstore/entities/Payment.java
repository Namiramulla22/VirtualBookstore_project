package com.virtualBookstore.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
    @Id
    @Column(name="Payment_id")
    private String id;

    @Column(name="amount")
    private Double amount;

    @Column(name="PaymentDate")
    private LocalDate paymentDate;

    @Column(name="PaymentMethod", length = 50)
    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", paymentDate=" + paymentDate + ", paymentMethod="
				+ paymentMethod + ", order=" + order + "]";
	}

	public Payment(String id, Double amount, LocalDate paymentDate, String paymentMethod, Order order) {
		super();
		this.id = id;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.order = order;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}