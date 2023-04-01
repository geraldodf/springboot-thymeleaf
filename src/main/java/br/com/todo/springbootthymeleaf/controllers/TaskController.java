package br.com.todo.springbootthymeleaf.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.todo.springbootthymeleaf.dtos.TaskDto;
import br.com.todo.springbootthymeleaf.models.entities.Task;
import br.com.todo.springbootthymeleaf.models.repositories.TaskRepository;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository repo;

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        ArrayList<Task> tasks = (ArrayList<Task>) repo.findAll();
        model.addAttribute("tasks", tasks);
        return "home";
    }

    @PostMapping("/tasks")
    public String createTask(TaskDto dto) {
        Task task = new Task(dto.getName(), dto.getDescription());
        repo.save(task);
        return "redirect:/tasks";
    }
}
