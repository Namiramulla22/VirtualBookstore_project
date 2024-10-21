package com.virtualBookstore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualBookstore.entities.Book;


public interface BookDao extends JpaRepository<Book,String> {

}
