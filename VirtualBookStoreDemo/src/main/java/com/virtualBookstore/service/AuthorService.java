package com.virtualBookstore.service;

import java.util.List;
import com.virtualBookstore.entities.Author;

public interface AuthorService {
    public List<Author> getAuthor();
    public Author getAuthor(String AuthorID);
    public Author addAuthor(Author author);
    public Author updateAuthor(Author author);
    public void deleteAuthor(String AuthorID);  // Corrected method signature
}
