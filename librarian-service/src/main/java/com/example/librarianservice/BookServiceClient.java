package com.example.librarianservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("book-service")
public interface BookServiceClient {

    @RequestMapping("/books")
    List<Book> getAll();
}
