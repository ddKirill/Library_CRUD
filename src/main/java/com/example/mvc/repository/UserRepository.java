package com.example.mvc.repository;

import com.example.mvc.model.UserA;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserA, Integer> {
}
