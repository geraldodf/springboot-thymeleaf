package br.com.todo.springbootthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    @GetMapping
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "hello";
    }
}
