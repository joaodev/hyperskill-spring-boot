package br.com.joaodev.hyperskillspringboot.tasks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    private final List<Task> taskList = List.of(
            new Task(1, "Task 1", "Description 1", false),
            new Task(2, "Task 2", "Description 2", true),
            new Task(3, "Task 3", "Description 3", false)
    );

    @GetMapping("/tasks")
    public List<Task> tasks() {
        return taskList;
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id) {
        return new ResponseEntity<>(taskList.get(id - 1), HttpStatus.ACCEPTED).getBody();
    }
}
