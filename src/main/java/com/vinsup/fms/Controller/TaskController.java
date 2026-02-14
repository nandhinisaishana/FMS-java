package com.vinsup.fms.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.vinsup.fms.service.TaskService;
import com.vinsup.fms.dto.*;
import com.vinsup.fms.model.Task;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
    @Autowired
    private TaskService taskService;

    // Create Task
    @PostMapping
    public ResponseEntity<ApiResponse> createTask(@Validated @RequestBody TaskDTO dto) {
        taskService.createTask(dto);
        return ResponseEntity.ok(new ApiResponse("Task created successfully"));
    }

    // Update Task Status
    @PutMapping("/{id}/status")
    public ResponseEntity<ApiResponse> updateTaskStatus(@PathVariable Long id,
                                                        @Validated @RequestBody TaskStatusUpdateDTO dto) {
        Task updatedTask = taskService.updateTaskStatus(id, dto);
        return ResponseEntity.ok(new ApiResponse("Task status updated", updatedTask));
    }

    // Get all tasks
    @GetMapping
    public ResponseEntity<ApiResponse> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(new ApiResponse("Tasks retrieved successfully", tasks));
    }

    // Get task by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(new ApiResponse("Task retrieved successfully", task));
    }
}
