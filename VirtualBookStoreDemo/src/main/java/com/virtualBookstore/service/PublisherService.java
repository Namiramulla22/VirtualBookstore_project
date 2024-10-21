package com.virtualBookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.virtualBookstore.entities.Publisher;
@Service
public interface PublisherService {

    List<Publisher> getPublishers();

    Publisher getPublisher(String publisherId);

    Publisher addPublisher(Publisher publisher);

    Publisher updatePublisher(Publisher publisher);

    void deletePublisher(String publisherId);
}
