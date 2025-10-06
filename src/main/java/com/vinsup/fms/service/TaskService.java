/*package com.vinsup.fms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vinsup.fms.dto.TaskDTO;
import com.vinsup.fms.dto.TaskStatusUpdateDTO;
import com.vinsup.fms.model.Department;
import com.vinsup.fms.model.Task;
import com.vinsup.fms.model.TaskStatus;
import com.vinsup.fms.model.User;
import com.vinsup.fms.repository.DepartmentRepository;
import com.vinsup.fms.repository.TaskRepository;
import com.vinsup.fms.repository.UserRepository;
import java.util.List;



@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    public Task createTask(TaskDTO dto) {
        User assignedTo = userRepo.findById(dto.getAssignedToId()).orElseThrow(() -> new RuntimeException("Assigned user not found"));
        User createdBy = userRepo.findById(dto.getCreatedById()).orElseThrow(() -> new RuntimeException("Creator not found"));
        Department department = departmentRepo.findById(dto.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found"));

        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setAssignedTo(assignedTo);
        task.setCreatedBy(createdBy);
        task.setDepartment(department);
        task.setStatus(TaskStatus.PENDING);
        return taskRepo.save(task);
    }

    public Task updateTaskStatus(Long taskId, TaskStatusUpdateDTO dto) {
        Task task = taskRepo.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(dto.getStatus());
        return taskRepo.save(task);

    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

}*/



