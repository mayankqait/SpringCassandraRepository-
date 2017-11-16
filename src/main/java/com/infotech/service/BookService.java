package com.infotech.service;


import java.util.List;

import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.infotech.entity.Book;


@Service
public interface BookService {
    
	public Book save(Book book);
	public Book findOne(int id);
	public List<Book> findAll();
	public  List<Book> findByPublisher(String Publisher);
}
