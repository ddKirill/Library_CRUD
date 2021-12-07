package com.example.mvc.repository;

import com.example.mvc.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book>  findByTitle(String title);



}
