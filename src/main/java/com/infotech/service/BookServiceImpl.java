package com.infotech.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.infotech.entity.Book;
import com.infotech.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book findOne(int id) {
       return bookRepository.findOne(id);
	}
    
	@Override
	public List<Book> findAll() {
       return (List<Book>) bookRepository.findAll();
	}
	
	public  List<Book> findByPublisher(String Publisher){
		return bookRepository.findByPublisher(Publisher);
	}

}
