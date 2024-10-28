package com.andersonzero0.todolistspringapi.repository;

import com.andersonzero0.todolistspringapi.domain.task.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}
