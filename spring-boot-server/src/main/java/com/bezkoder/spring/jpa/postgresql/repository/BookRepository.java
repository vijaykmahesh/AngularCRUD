package com.bezkoder.spring.jpa.postgresql.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.bezkoder.spring.jpa.postgresql.model.Book;

public interface BookRepository extends CrudRepository<Book,Serializable> {
	
	public Book findByBookId(int bookId);
}
