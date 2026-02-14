package com.vinsup.fms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinsup.fms.model.Floor;

public interface FloorRepository extends JpaRepository<Floor, Long> {
	Optional<Floor> findByFloorNumber(String floorNumber);
	
	
}

