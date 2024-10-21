package com.virtualBookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualBookstore.Dao.PublisherDao;
import com.virtualBookstore.entities.Publisher;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherDao publisherDao;

    @Override
    public List<Publisher> getPublishers() {
        return publisherDao.findAll();
    }

    @Override
    public Publisher getPublisher(String publisherId) {
        Optional<Publisher> optionalPublisher = publisherDao.findById(publisherId);
        return optionalPublisher.orElseThrow(() -> new RuntimeException("Publisher not found with ID: " + publisherId));
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publisherDao.save(publisher);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        Optional<Publisher> optionalPublisher = publisherDao.findById(publisher.getId());
        if (optionalPublisher.isPresent()) {
            return publisherDao.save(publisher);
        } else {
            throw new RuntimeException("Publisher not found with ID: " + publisher.getId());
        }
    }

    @Override
    public void deletePublisher(String publisherId) {
        Optional<Publisher> optionalPublisher = publisherDao.findById(publisherId);
        Publisher publisher = optionalPublisher.orElseThrow(() -> new RuntimeException("Publisher not found with ID: " + publisherId));
        publisherDao.delete(publisher);
    }
}
