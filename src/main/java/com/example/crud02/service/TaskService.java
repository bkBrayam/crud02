package com.example.crud02.service;

import com.example.crud02.dto.TaskRequest;
import com.example.crud02.entity.Task;
import com.example.crud02.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public ResponseEntity<Object> postTask(TaskRequest request) {
        Task task = Task.builder()
                .task(request.getTask())
                .description(request.getDescription())
                .status(request.getStatus())
                .initialDate(new Date())
                .build();

        taskRepository.save(task);
        return ResponseEntity.ok(task);
    }
}
