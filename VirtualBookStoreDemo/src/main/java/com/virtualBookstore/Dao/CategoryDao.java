package com.virtualBookstore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualBookstore.entities.Category;


public interface CategoryDao extends JpaRepository<Category,String>{

}
