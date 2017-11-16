package com.infotech.entity;

import java.util.HashSet;
import java.util.Set;


import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.cassandra.repository.MapId;

@Table
public class Book {
    
	@PrimaryKey
    private int id;
    
    @Column
    private String title;
    
    @Column    
    private String publisher;
    
    @Column
    private Set<String> tags = new HashSet<>();
    // standard getters and setters
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Set<String> getTags() {
		return tags;
	}
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	public Book(int id, String title, String publisher, Set<String> tags) {
		super();
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.tags = tags;
	}
	
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publisher=" + publisher + ", tags=" + tags + "]";
	}
	
	
	
	
	
    
}
