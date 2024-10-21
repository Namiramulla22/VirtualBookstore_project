package com.virtualBookstore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualBookstore.entities.Author;

public interface AuthorDao extends JpaRepository<Author,String> {

}
