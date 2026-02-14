package com.vinsup.fms.Controller;

import com.vinsup.fms.dto.InventoryRequestDTO;
import com.vinsup.fms.dto.InventoryResponseDTO;
import com.vinsup.fms.model.Inventory;
import com.vinsup.fms.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<InventoryResponseDTO> addInventory(@RequestBody InventoryRequestDTO dto) {
        Inventory inventory = inventoryService.addInventory(dto);
        return ResponseEntity.ok(new InventoryResponseDTO("Inventory item added successfully", inventory));
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories() {
        return ResponseEntity.ok(inventoryService.getAllInventories());
    }
    
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getInventoryById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id)
                .map(inv -> ResponseEntity.ok(new InventoryResponseDTO("Inventory retrieved successfully", inv)))
                .orElse(ResponseEntity.status(404).body(new InventoryResponseDTO("Inventory not found")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InventoryResponseDTO> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.ok(new InventoryResponseDTO("Inventory deleted successfully"));
    }
}
