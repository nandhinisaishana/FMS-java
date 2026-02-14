package com.vinsup.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vinsup.fms.dto.DepartmentDTO;
import com.vinsup.fms.model.Department;
import com.vinsup.fms.repository.DepartmentRepository;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepo;

    public Department createDepartment(DepartmentDTO dto)
    {
        Department dept = new Department();
        dept.setName(dto.getName());
        return departmentRepo.save(dept);
    }

    public List<Department> getAllDepartments() 
    {
        return departmentRepo.findAll();
    }
}



