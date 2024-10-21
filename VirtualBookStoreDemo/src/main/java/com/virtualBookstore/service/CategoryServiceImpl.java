package com.virtualBookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualBookstore.Dao.CategoryDao;
import com.virtualBookstore.entities.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Category getCategory(String categoryId) {
        Optional<Category> optionalCategory = categoryDao.findById(categoryId);
        return optionalCategory.orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
    }

    @Override
    public Category addCategory(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Optional<Category> optionalCategory = categoryDao.findById(category.getId());
        if (optionalCategory.isPresent()) {
            return categoryDao.save(category);
        } else {
            throw new RuntimeException("Category not found with ID: " + category.getId());
        }
    }

    @Override
    public void deleteCategory(String categoryId) {
        Optional<Category> optionalCategory = categoryDao.findById(categoryId);
        Category category = optionalCategory.orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
        categoryDao.delete(category);
    }
}
