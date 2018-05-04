package com.example.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/books")
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	private List<Book> getAllBooks() {
		return Arrays.asList(
				new Book(1L, "Baeldung goes to the market", "Tim Schimandle"),
				new Book(2L, "Baeldung goes to the park", "Slavisa")
		);
	}

	@GetMapping("")
	public List<Book> findAll() {
		return getAllBooks();
	}

	@GetMapping("/{id}")
	public Book findById(@PathVariable Long id) {
		return getAllBooks().stream()
				.filter(book -> book.getId().equals(id))
				.findFirst()
				.get();
	}
}
