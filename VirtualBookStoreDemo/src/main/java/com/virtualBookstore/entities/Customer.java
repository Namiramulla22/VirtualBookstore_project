package com.virtualBookstore.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
    @Id
    @Column(name="C_ID")
    private String id;

    @Column(name="CustomerName", length = 100)
    private String Cname;

    @Column( name="Email",length = 100)
    private String email;

    @Column(name="Address",length = 255)
    private String address;

    @Column( name="PhoneNumber",length = 15)
    private String phoneNumber;
    
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;  // A customer can place many orders

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Customer(String id, String cname, String email, String address, String phoneNumber) {
		super();
		this.id = id;
		Cname = cname;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Customer(List<Order> orders) {
		super();
		this.orders = orders;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", Cname=" + Cname + ", email=" + email + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}
    
    

}