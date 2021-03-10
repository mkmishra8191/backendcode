package com.todolist.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todolist.demo.model.Task;

import java.util.Optional;

public interface TaskRepo extends JpaRepository<Task, Long> {
    void deleteTaskById(Long id);

    Optional<Task> findTaskById(Long id);
}
