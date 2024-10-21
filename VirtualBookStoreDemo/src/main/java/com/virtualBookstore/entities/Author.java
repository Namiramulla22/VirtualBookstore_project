package com.virtualBookstore.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Author {
    @Id
    @Column(name="ID")
    private String id;

    @Column( name="Author name ",length = 100)
    private String Aname;

    @Column(length = 500)
    private String biography;
    
    @OneToMany(mappedBy = "author")
    private List<Book> books;  // An author can write many books

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAname() {
		return Aname;
	}

	public void setAname(String aname) {
		Aname = aname;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Author(String id, String aname, String biography) {
		super();
		this.id = id;
		Aname = aname;
		this.biography = biography;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", Aname=" + Aname + ", biography=" + biography + "]";
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Author(List<Book> books) {
		super();
		this.books = books;
	}

   
}