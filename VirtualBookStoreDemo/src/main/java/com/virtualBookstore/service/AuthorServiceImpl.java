package com.virtualBookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualBookstore.Dao.AuthorDao;
import com.virtualBookstore.entities.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired    
	private AuthorDao authorDao;
	
	@Override
	public List<Author> getAuthor() {
		return authorDao.findAll();  // Correct usage
	}
	
	@Override
	public Author getAuthor(String AuthorID) {
		// Using findById to fetch author by ID
		Optional<Author> optionalAuthor = authorDao.findById(AuthorID);
		// Return the author if found, or throw an exception or handle it as needed
		return optionalAuthor.orElseThrow(() -> new RuntimeException("Author not found with ID: " + AuthorID));
	}
	
	@Override
	public Author addAuthor(Author author) {
		authorDao.save(author);  // Saving new author
		return author;
	}

	@Override
	public Author updateAuthor(Author author) {
		authorDao.save(author);  // Updating existing author
		return author;
	}

	@Override
	public void deleteAuthor(String AuthorID) {
		// Using findById to check if author exists
		Optional<Author> optionalAuthor = authorDao.findById(AuthorID);
		Author author = optionalAuthor.orElseThrow(() -> new RuntimeException("Author not found with ID: " + AuthorID));
		authorDao.delete(author);  // Deleting the author
	}
}
