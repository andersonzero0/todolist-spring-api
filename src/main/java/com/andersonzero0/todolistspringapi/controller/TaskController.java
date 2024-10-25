package com.andersonzero0.todolistspringapi.controller;

import com.andersonzero0.todolistspringapi.domain.task.TaskEntity;
import com.andersonzero0.todolistspringapi.domain.task.TaskInputDTO;
import com.andersonzero0.todolistspringapi.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/task", produces = {"application/json"})
@Tag(name = "Task", description = "Task operations")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Create a task", method = "POST")
    @PostMapping(consumes = "application/json")
    public TaskEntity createTask(@RequestBody @Valid TaskInputDTO taskInputDTO) {
        return taskService.createTask(new TaskEntity(taskInputDTO));
    }

    @Operation(summary = "Find all tasks", method = "GET")
    @GetMapping(consumes = "application/json")
    public List<TaskEntity> findAllTasks() {
        return taskService.findAllTasks();
    }

    @Operation(summary = "Find a task by id", method = "GET")
    @GetMapping("/{id}")
    public TaskEntity findTaskById(@PathVariable Integer id) {
        TaskEntity task = taskService.findTaskById(id);

        if (task == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }

        return task;
    }

    @Operation(summary = "Update a task", method = "PUT")
    @PutMapping("/{id}")
    public TaskEntity updateTask(@PathVariable Integer id, @RequestBody @Valid TaskInputDTO taskInputDTO) {
        return taskService.updateTask(id, new TaskEntity(taskInputDTO));
    }

    @Operation(summary = "Update a task status", method = "PATCH")
    @PatchMapping("/{id}")
    public TaskEntity updateTaskStatus(
            @PathVariable Integer id,
            @RequestParam(value = "done", defaultValue = "false") Boolean done) {
        return taskService.updateTaskStatus(id, done);
    }

    @Operation(summary = "Delete a task", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted");
    }
}
