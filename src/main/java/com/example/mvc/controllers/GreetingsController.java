package com.example.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingsController {

    @RequestMapping("/firstpage")
    public String firstpage(@RequestParam(name="name", required=false,
            defaultValue="World") String name, Map<String, Object> model)
    {
        model.put("name", name);
          return "firstpage";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        model.put("some", "Hello people");
        return "main";
    }
}
