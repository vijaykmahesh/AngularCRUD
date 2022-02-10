package com.bezkoder.spring.jpa.postgresql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.jpa.postgresql.model.Book;
import com.bezkoder.spring.jpa.postgresql.repository.BookRepository;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book findByBookId(int bookId) {
		Book book = bookRepository.findByBookId(bookId);
		return book;
	}
	
	

}
