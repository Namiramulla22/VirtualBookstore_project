package com.virtualBookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualBookstore.entities.Book;
import com.virtualBookstore.Repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository; // Inject the Book repository

    // Method to save a new book
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book); // Save the book to the database
    }

    // Method to get all books
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll(); // Fetch all books
    }

    // Method to get a book by ID
    @Override
    public Book getBook(String bookID) {
        return bookRepository.findById(bookID).orElse(null); // Fetch book by ID
    }

    // Method to update an existing book
    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book); // Update the book
    }

    // Method to delete a book by ID
    @Override
    public void deleteBook(String bookID) {
        bookRepository.deleteById(bookID); // Delete book by ID
    }
}
