package com.infotech.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.infotech.entity.*;

@Repository
public interface BookRepository  extends CrudRepository<Book,Integer>{
     
	@Query(value="SELECT * FROM book  where publisher = :Publisher")
	 public  List<Book> findByPublisher(@Param("Publisher") String Publisher);
}
