package com.vinsup.fms.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vinsup.fms.dto.DepartmentDTO;
import com.vinsup.fms.model.Department;
import com.vinsup.fms.service.DepartmentService;
import java.util.List;
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	/*
	 * {
  "name": "Maintenance Management",
  "description": "Handles all Maintenance"
}

	 */
    @Autowired
    private DepartmentService departmentService;
    
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO dto) {
        Department department = departmentService.createDepartment(dto);
        return ResponseEntity.ok(department);

    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() 
    {
        return ResponseEntity.ok(departmentService.getAllDepartments());

    }

}