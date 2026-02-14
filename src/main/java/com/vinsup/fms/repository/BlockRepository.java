package com.vinsup.fms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinsup.fms.model.Block;

public interface BlockRepository extends JpaRepository<Block, Long>{
	Optional<Block> findByName(String name); // for Floor creation
	
}
