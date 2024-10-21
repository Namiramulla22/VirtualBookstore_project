package com.virtualBookstore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualBookstore.entities.Publisher;


public interface PublisherDao extends JpaRepository<Publisher,String> {

}
