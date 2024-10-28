package com.andersonzero0.todolistspringapi.service;

import com.andersonzero0.todolistspringapi.domain.task.TaskEntity;
import com.andersonzero0.todolistspringapi.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    public List<TaskEntity> findAllTasks() {
        return taskRepository.findAll();
    }

    public TaskEntity findTaskById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public TaskEntity updateTask(Integer id, TaskEntity task) {
        TaskEntity taskToUpdate = findTaskById(id);

        if(taskToUpdate != null) {
            taskToUpdate.setTitle(task.getTitle());
            taskToUpdate.setDescription(task.getDescription());
            taskToUpdate.setDone(task.getDone());
            return taskRepository.save(taskToUpdate);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
    }

    public TaskEntity updateTaskStatus(Integer id, Boolean done) {
        TaskEntity taskToUpdate = findTaskById(id);

        if(taskToUpdate != null) {
            taskToUpdate.setDone(done);
            return taskRepository.save(taskToUpdate);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
}
