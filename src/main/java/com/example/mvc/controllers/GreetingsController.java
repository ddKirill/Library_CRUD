package com.example.mvc.controllers;

import com.example.mvc.model.UserA;
import com.example.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingsController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/firstpage")
    public String firstpage(@RequestParam(name="name", required=false,
            defaultValue="World") String name, Map<String, Object> model)
    {
        model.put("name", name);
          return "firstpage";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<UserA> users = userRepository.findAll();
        model.put("users", userRepository );
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam String message, Map<String, Object> model){
        UserA user = new UserA(name, message);
        userRepository.save(user);
        Iterable<UserA> users = userRepository.findAll();
        model.put("users", userRepository );
        return "main";
    }
}
