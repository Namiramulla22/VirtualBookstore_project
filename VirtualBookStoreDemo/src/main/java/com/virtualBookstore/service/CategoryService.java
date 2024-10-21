package com.virtualBookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.virtualBookstore.entities.Category;
@Service
public interface CategoryService {

    List<Category> getCategories();

    Category getCategory(String categoryId);

    Category addCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(String categoryId);
}
