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

import com.virtualBookstore.entities.Category;
import com.virtualBookstore.service.CategoryService;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Get the list of Categories
    @GetMapping("/Category")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    // Get a Category by ID
    @GetMapping("/Category/{CategoryID}")
    public ResponseEntity<Category> getCategory(@PathVariable("CategoryID") String categoryId) {
        try {
            Category category = categoryService.getCategory(categoryId);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a new Category
    @PostMapping("/Category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        try {
            Category addedCategory = categoryService.addCategory(category);
            return new ResponseEntity<>(addedCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an existing Category by ID
    @PutMapping("/Category/{CategoryID}")
    public ResponseEntity<Category> updateCategory(@PathVariable("CategoryID") String categoryId, @RequestBody Category category) {
        try {
            category.setId(categoryId);  // Ensure correct CategoryID is set
            Category updatedCategory = categoryService.updateCategory(category);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a Category by ID
    @DeleteMapping("/Category/{CategoryID}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("CategoryID") String categoryId) {
        try {
            categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
