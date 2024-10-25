package com.andersonzero0.todolistspringapi.controller;

import com.andersonzero0.todolistspringapi.domain.task.TaskEntity;
import com.andersonzero0.todolistspringapi.domain.task.TaskInputDTO;
import com.andersonzero0.todolistspringapi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskEntity createTask(@RequestBody @Valid TaskInputDTO taskInputDTO) {
        return taskService.createTask(new TaskEntity(taskInputDTO));
    }

    @GetMapping
    public List<TaskEntity> findAllTasks() {
        return taskService.findAllTasks();
    }

    @GetMapping("/{id}")
    public TaskEntity findTaskById(@PathVariable Integer id) {
        TaskEntity task = taskService.findTaskById(id);

        if (task == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }

        return task;
    }

    @PutMapping("/{id}")
    public TaskEntity updateTask(@PathVariable Integer id, @RequestBody @Valid TaskInputDTO taskInputDTO) {
        return taskService.updateTask(id, new TaskEntity(taskInputDTO));
    }

    @PatchMapping("/{id}")
    public TaskEntity updateTaskStatus(
            @PathVariable Integer id,
            @RequestParam(value = "done", defaultValue = "false") Boolean done) {
        return taskService.updateTaskStatus(id, done);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted");
    }
}
