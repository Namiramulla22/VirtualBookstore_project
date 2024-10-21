package com.virtualBookstore.service;

import com.virtualBookstore.entities.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    List<Book> getBooks();
    Book getBook(String bookID);
    Book updateBook(Book book);
    void deleteBook(String bookID);
}
