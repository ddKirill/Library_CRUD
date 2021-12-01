package com.example.mvc.controllers;

import com.example.mvc.model.Book;
import com.example.mvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LibraryController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/firstpage")
    public String greetings() {
        return "firstpage";
    }

    @GetMapping
    public String library(Map<String, Object> model){
        Iterable<Book> books = bookRepository.findAll();
        model.put("books", books );
        return "library";
    }

    @PostMapping
    public String addNewBook(@RequestParam String title, @RequestParam String author,
                             @RequestParam String genre, Map<String, Object> model){
        Book book = new Book(title, author, genre);
        bookRepository.save(book);
        Iterable<Book> books = bookRepository.findAll();
        model.put("books", books );
        return "library";
    }
}
