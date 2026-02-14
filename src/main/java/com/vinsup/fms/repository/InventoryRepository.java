package com.vinsup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vinsup.fms.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
