package com.example.crud02.controller;

import com.example.crud02.dto.TaskRequest;
import com.example.crud02.dto.UpdateTaskRequest;
import com.example.crud02.entity.Task;
import com.example.crud02.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping(value = "tasks")
    public List<Task> getTask() {
        return taskService.getTasks();
    }

    @PostMapping(value = "task")
    public ResponseEntity<Object> postTask(@RequestBody TaskRequest request){
        return taskService.postTask(request);
    }

    @PutMapping(value = "task")
    public ResponseEntity<Object> putTask(@RequestBody UpdateTaskRequest request){
        return taskService.updateTask(request);
    }
}
