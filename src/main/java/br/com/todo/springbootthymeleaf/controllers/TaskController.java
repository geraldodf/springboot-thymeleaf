package br.com.todo.springbootthymeleaf.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.todo.springbootthymeleaf.dtos.TaskDto;
import br.com.todo.springbootthymeleaf.models.entities.Task;
import br.com.todo.springbootthymeleaf.models.repositories.TaskRepository;

@Controller
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    private TaskRepository repo;

    @GetMapping
    public String getAll(Model model) {
        ArrayList<Task> tasks = (ArrayList<Task>) repo.findAll();
        model.addAttribute("tasks", tasks);
        return "home";
    }

    @GetMapping("/new")
    public String newTask(Model model) {
        Task task = new Task(); 
        model.addAttribute("task", task); 
        return "form";
    }

    @GetMapping("/update")
    public String updateTask() {
        return "form";
    }

    @PostMapping("/salvar")
    public String create(Task task) {
        repo.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/editar/{id}")
    public String preEdit(@PathVariable Long id, ModelMap model) {
        model.addAttribute("task", repo.findById(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repo.deleteById(id);
        return "redirect:/tasks";
    }
}
