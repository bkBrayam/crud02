package com.example.crud02.service;

import com.example.crud02.entity.Task;
import com.example.crud02.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
}
