package com.example.crud02.service;

import com.example.crud02.dto.TaskRequest;
import com.example.crud02.dto.UpdateTaskRequest;
import com.example.crud02.entity.Task;
import com.example.crud02.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public ResponseEntity<Object> updateTask(UpdateTaskRequest request) {

        Optional<Task> taskFound = taskRepository.findById(request.getId());

        if(taskFound.isPresent()){
            Task taskToUpdate = Task.builder()
                    .id(request.getId())
                    .task(request.getTask())
                    .description(request.getDescription())
                    .status(request.getStatus())
                    .initialDate(request.getInitialDate())
                    .completionDay(request.getCompletionDay())
                    .build();

            taskRepository.save(taskToUpdate);

            return ResponseEntity.ok(taskToUpdate);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "producto no ha sido encontrado");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
