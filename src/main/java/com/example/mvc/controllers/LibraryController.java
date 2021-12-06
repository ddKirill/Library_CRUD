package com.example.mvc.controllers;

import com.example.mvc.model.Book;
import com.example.mvc.repository.BookRepository;
import com.example.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

@Controller
public class LibraryController {

    private final BookRepository bookRepository;

    @Autowired
    public LibraryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Autowired
    BookService bookService;




    @GetMapping("/library")
    public String library(Map<String, Object> model){
        Iterable<Book> books = bookRepository.findAll();
        model.put("books", books );
        return "library";
    }

    @PostMapping("/library")
    public String addNewBook(@RequestParam String title, @RequestParam String author,
                             @RequestParam String genre, Map<String, Object> model){
        Book book = new Book(title, author, genre);
        bookRepository.save(book);
        Iterable<Book> books = bookRepository.findAll();
        model.put("books", books );
        return "library";
    }

    @PostMapping("/search")
    public String search(@RequestParam String search, Map<String, Object> model){
        Iterable<Book> books;

        if (search != null && !search.isEmpty()) {
            books = bookRepository.findByTitle(search);
        } else {
            books = bookRepository.findAll();
        }
        model.put("books", books);

        return "library";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id){
        bookService.deleteById(id);
        return "redirect:/library";

    }
}
