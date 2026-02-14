package com.vinsup.fms.service;

import com.vinsup.fms.dto.InventoryRequestDTO;
import com.vinsup.fms.model.Inventory;
import com.vinsup.fms.model.Room;
import com.vinsup.fms.repository.InventoryRepository;
import com.vinsup.fms.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

	/*
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Inventory addInventory(InventoryRequestDTO dto) {
        Optional<Room> roomOpt = roomRepository.findById(dto.getRoomId());
        if (roomOpt.isEmpty()) {
            throw new RuntimeException("Room not found");
        }

        Inventory inventory = new Inventory();
        inventory.setItemName(dto.getItemName());
        inventory.setQuantity(dto.getQuantity());
        inventory.setCategory(dto.getCategory());
        inventory.setDescription(dto.getDescription());
        inventory.setRoom(roomOpt.get());
        inventory.setCreatedBy("Admin");
      
        
        return inventoryRepository.save(inventory);
    }*/
	
	@Autowired
	private EmailService emailService;
	
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private RoomRepository roomRepository;

    /*
	public Inventory addInventory(InventoryRequestDTO dto) {
	    Optional<Room> roomOpt = roomRepository.findById(dto.getRoomId());
	    if (roomOpt.isEmpty()) {
	        throw new RuntimeException("Room not found");
	    }

	    Inventory inventory = new Inventory();
	    inventory.setItemName(dto.getItemName());
	    inventory.setQuantity(dto.getQuantity());
	    inventory.setCategory(dto.getCategory());
	    inventory.setDescription(dto.getDescription());
	    inventory.setRoom(roomOpt.get());
	    inventory.setCreatedBy("Admin");

	    // Save inventory
	    Inventory savedInventory = inventoryRepository.save(inventory);

	    // Low stock email alert
	    if (savedInventory.getQuantity() < 5) {
	        String subject = "⚠️ Low Stock Alert: " + savedInventory.getItemName();
	        String message = "Item: " + savedInventory.getItemName() + "\n"
	                + "Category: " + savedInventory.getCategory() + "\n"
	                + "Current Quantity: " + savedInventory.getQuantity() + "\n\n"
	                + "Please reorder soon to avoid stockout.";

	        // Replace with your email or admin mail list
	        emailService.sendMail("nandhinivinsup01@gmail.com", subject, message);
	    }

	    return savedInventory;
	}
	*/
    
   
//
    public Inventory addInventory(InventoryRequestDTO dto) {
        Optional<Room> roomOpt = roomRepository.findById(dto.getRoomId());
        if (roomOpt.isEmpty()) {
            throw new RuntimeException("Room not found");
        }

        Inventory inventory = new Inventory();
        inventory.setItemName(dto.getItemName());
        inventory.setQuantity(dto.getQuantity());
        inventory.setCategory(dto.getCategory());
        inventory.setDescription(dto.getDescription());
        inventory.setRoom(roomOpt.get());
        inventory.setCreatedBy("Admin");

        Inventory saved = inventoryRepository.save(inventory);

        //Check and trigger low stock alert
        int LOW_STOCK_THRESHOLD = 10; // You can store this in DB or config later
        if (saved.getQuantity() < LOW_STOCK_THRESHOLD) {
            emailService.sendLowStockAlert(saved);
        }

        return saved;
    }
//

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }
    

    public Optional<Inventory> getInventoryById(Long id) {
        return inventoryRepository.findById(id);
    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}
