package com.example.mvc.controllers;

import com.example.mvc.model.Role;
import com.example.mvc.model.User;
import com.example.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
       User userFromDB = userRepository.findByUsername(user.getUsername());

       if (userFromDB != null){
           model.put("message", "User exists!");
           return "registration";
       }
       user.setActive(true);
       user.setRoles(Collections.singleton(Role.USER));
       userRepository.save(user);
        return "redirect:/login";


    }
}

