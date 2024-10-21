package com.virtualBookstore.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Publisher {
    @Id
    @Column(name="PublisherID")
    private String id;

    @Column(name="Publishername",length = 100)
    private String name;

    @Column(name="P_Address",length = 255)
    private String address;

    @Column(name="PhoneNumber",length = 15)
    private String phoneNumber;
    
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;  // A publisher can publish many books
    
    

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Publisher(String id, String name, String address, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	

	public Publisher(List<Book> books) {
		super();
		this.books = books;
	}

	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
    

}
