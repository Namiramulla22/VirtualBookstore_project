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

import com.virtualBookstore.entities.Author;
import com.virtualBookstore.service.AuthorService;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // Get the list of authors
    @GetMapping("/Author")
    public List<Author> getAuthor() {
        return this.authorService.getAuthor();
    }

    // Get an author by ID
    @GetMapping("/Author/{id}")
    public Author getAuthor(@PathVariable String id) {
        return this.authorService.getAuthor(id);
    }

    // Add a new author
    @PostMapping("/Author")
    public Author addAuthor(@RequestBody Author author) {
        return this.authorService.addAuthor(author);
    }

    // Update an existing author by ID
    @PutMapping("/Author/{id}") // Update an author based on AuthorID
    public ResponseEntity<Author> updateAuthor(@PathVariable String id, @RequestBody Author author) {
        try {
            // Ensure that the correct AuthorID is set
            author.setId(id);
            Author updatedAuthor = this.authorService.updateAuthor(author);
            return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete an author by ID
    @DeleteMapping("/Author/{id}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable String id) {
        try {
            this.authorService.deleteAuthor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
