package com.todolist.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todolist.demo.exception.UserNotFoundException;
import com.todolist.demo.model.Task;
import com.todolist.demo.repo.TaskRepo;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class TaskService {
    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task addTask(Task task) {
       
        return taskRepo.save(task);
    }

    public List<Task> findAllTasks() {
        return taskRepo.findAll();
    }

    public Task updateTask(Task task) {
        return taskRepo.save(task);
    }

    public Task findTaskById(Long id) {
        return taskRepo.findTaskById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteTask(Long id){
        taskRepo.deleteTaskById(id);
    }
}