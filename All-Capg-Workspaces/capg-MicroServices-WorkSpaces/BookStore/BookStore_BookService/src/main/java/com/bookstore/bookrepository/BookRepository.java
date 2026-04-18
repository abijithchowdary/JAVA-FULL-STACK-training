package com.bookstore.bookrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookentity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
}
