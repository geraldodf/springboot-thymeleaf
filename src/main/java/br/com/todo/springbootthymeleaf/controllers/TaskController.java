package br.com.todo.springbootthymeleaf.controllers;

import br.com.todo.springbootthymeleaf.models.entities.Task;
import br.com.todo.springbootthymeleaf.models.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TaskController {

    @Autowired
    private TaskRepository repo;

    @GetMapping("/home")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        Task task = new Task("Estudar", "Resolver bug do Thymeleaf");
        repo.save(task);
        return "home";
    }
}
