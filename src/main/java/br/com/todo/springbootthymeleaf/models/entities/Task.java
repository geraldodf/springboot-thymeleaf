package br.com.todo.springbootthymeleaf.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private boolean status;

    public Task(String name, String description, boolean status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = false;
    }

}
