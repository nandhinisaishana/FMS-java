package com.vinsup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vinsup.fms.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
}