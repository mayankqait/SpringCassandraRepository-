package com.infotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.entity.Book;
import com.infotech.repository.BookRepository;
import com.infotech.service.BookService;
import com.infotech.service.BookServiceImpl;


@RestController
@RequestMapping(value="/book")
public class BookController {
	
	/*@Autowired
	private BookRepository bookRepository;*/
	
	@Autowired
	private BookService bookServiceImpl;
	
	@PostMapping(path="/add")
	public ResponseEntity addTeam(@RequestBody Book t) {
		 bookServiceImpl.save(t);
		return new ResponseEntity(t, HttpStatus.OK);
	}
	
	@GetMapping(path="/")
	public List<Book> getAllBook() {
		return (List<Book>)bookServiceImpl.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Book getTeamInfo(@PathVariable("id") int id) {
		return bookServiceImpl.findOne(id);
	}
	
	@GetMapping(path="/publisher/{Publisher}")
	public List<Book> getTeamInfo(@PathVariable("Publisher") String Publisher) {
		return (List<Book>)bookServiceImpl.findByPublisher(Publisher);
	}
	
}
