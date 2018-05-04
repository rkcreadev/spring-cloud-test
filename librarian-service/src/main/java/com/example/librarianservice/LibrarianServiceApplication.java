package com.example.librarianservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@RestController
public class LibrarianServiceApplication {

	@Autowired
	private BookServiceClient bookServiceClient;

	public static void main(String[] args) {
		SpringApplication.run(LibrarianServiceApplication.class, args);
	}

	@GetMapping("/show")
	public List<Book> showAllBoks() {
        return bookServiceClient.getAll();
    }
}
