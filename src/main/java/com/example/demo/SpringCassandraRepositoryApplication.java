package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories("com.infotech.repository")
@ComponentScan("com.infotech")
public class SpringCassandraRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCassandraRepositoryApplication.class, args);
	}
}
