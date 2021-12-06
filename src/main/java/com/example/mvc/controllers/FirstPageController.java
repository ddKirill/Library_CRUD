package com.example.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
@Controller
public class FirstPageController {

    @GetMapping("/")
    public String greetings(Map<String, Object> model) {
        return "firstpage";
    }
}
