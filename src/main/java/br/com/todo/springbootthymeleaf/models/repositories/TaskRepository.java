package br.com.todo.springbootthymeleaf.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.todo.springbootthymeleaf.models.entities.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}