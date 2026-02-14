package com.vinsup.fms.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinsup.fms.model.Building;

public interface BuildingRepository extends JpaRepository<Building, Long>{
	Optional<Building> findByName(String name);

}