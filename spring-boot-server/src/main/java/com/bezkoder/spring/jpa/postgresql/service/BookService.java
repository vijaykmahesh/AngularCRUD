package com.bezkoder.spring.jpa.postgresql.service;

import org.springframework.stereotype.Component;

import com.bezkoder.spring.jpa.postgresql.model.Book;

@Component
public interface BookService {

	public Book findByBookId(int bookId);
}
