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

import com.virtualBookstore.entities.Book;
import com.virtualBookstore.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // Get the list of Books
    @GetMapping("/Book")
    public List<Book> getBooks() {
        return this.bookService.getBooks();
    }

    // Get a Book by ID
    @GetMapping("/Book/{BookID}")
    public Book getBooks(@PathVariable("BookID") String bookID) { // Use "BookID" in both annotation and parameter
        return this.bookService.getBook(bookID);
    }

 // Add a new Book
    @PostMapping("/Book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = this.bookService.addBook(book); // Call the service to save the book
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook); // Return the saved book with a 201 status
    }

    // Update an existing Book by ID
    @PutMapping("/Book/{BookID}")
    public ResponseEntity<Book> updateBook(@PathVariable("BookID") String bookID, @RequestBody Book book) {
        try {
            // Ensure that the correct BookID is set
            book.setId(bookID);
            Book updatedBook = this.bookService.updateBook(book);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a Book by ID
    @DeleteMapping("/Book/{BookID}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("BookID") String bookID) {
        try {
            this.bookService.deleteBook(bookID);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
