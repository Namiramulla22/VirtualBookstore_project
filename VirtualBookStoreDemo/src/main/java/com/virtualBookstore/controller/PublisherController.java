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

import com.virtualBookstore.entities.Publisher;
import com.virtualBookstore.service.PublisherService;

@RestController
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    // Get the list of Publishers
    @GetMapping("/Publisher")
    public List<Publisher> getPublishers() {
        return publisherService.getPublishers();
    }

    // Get a Publisher by ID
    @GetMapping("/Publisher/{PublisherID}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable("PublisherID") String publisherId) {
        try {
            Publisher publisher = publisherService.getPublisher(publisherId);
            return new ResponseEntity<>(publisher, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a new Publisher
    @PostMapping("/Publisher")
    public ResponseEntity<Publisher> addPublisher(@RequestBody Publisher publisher) {
        try {
            Publisher addedPublisher = publisherService.addPublisher(publisher);
            return new ResponseEntity<>(addedPublisher, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an existing Publisher by ID
    @PutMapping("/Publisher/{PublisherID}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable("PublisherID") String publisherId, @RequestBody Publisher publisher) {
        try {
            publisher.setId(publisherId);  // Ensure correct PublisherID is set
            Publisher updatedPublisher = publisherService.updatePublisher(publisher);
            return new ResponseEntity<>(updatedPublisher, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a Publisher by ID
    @DeleteMapping("/Publisher/{PublisherID}")
    public ResponseEntity<HttpStatus> deletePublisher(@PathVariable("PublisherID") String publisherId) {
        try {
            publisherService.deletePublisher(publisherId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
