package com.virtualBookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.virtualBookstore.entities.Book;

public interface BookRepository extends JpaRepository<Book, String> {
    // You can define custom query methods here if needed
}
