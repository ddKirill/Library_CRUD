package com.example.mvc.repository;

import com.example.mvc.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByTitle(String title);
}
