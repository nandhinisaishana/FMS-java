package com.vinsup.fms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.vinsup.fms.model.Department;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Optional<Department> findByName(String name);

}

