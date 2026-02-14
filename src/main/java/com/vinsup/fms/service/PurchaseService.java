package com.vinsup.fms.service;
/*
import com.vinsup.fms.ResourceNotFoundException;
import com.vinsup.fms.dto.PurchaseRequestDTO;
import com.vinsup.fms.model.Inventory;
import com.vinsup.fms.model.Purchase;
import com.vinsup.fms.model.Supplier;
import com.vinsup.fms.repository.InventoryRepository;
import com.vinsup.fms.repository.PurchaseRepository;
import com.vinsup.fms.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public Purchase createPurchase(PurchaseRequestDTO dto) {
        Supplier supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id " + dto.getSupplierId()));

        Inventory inventory = inventoryRepository.findById(dto.getInventoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id " + dto.getInventoryId()));

        Purchase purchase = new Purchase();
        purchase.setSupplier(supplier);
        purchase.setInventory(inventory);
        purchase.setQuantity(dto.getQuantity());
        purchase.setUnitPrice(dto.getUnitPrice());
        purchase.setTotalAmount(dto.getQuantity() * dto.getUnitPrice());
        purchase.setPurchaseDate(dto.getPurchaseDate());
        purchase.setWarrantyPeriod(dto.getWarrantyPeriod());
        purchase.setRemarks(dto.getRemarks());

        // Update inventory stock
        inventory.setQuantity(inventory.getQuantity() + dto.getQuantity());
        inventoryRepository.save(inventory);

        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public void deletePurchase(Long id) {
        purchaseRepository.deleteById(id);
    }
}
*/
      

import com.vinsup.fms.dto.PurchaseRequestDTO;
import com.vinsup.fms.model.*;
import com.vinsup.fms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public Purchase addPurchase(PurchaseRequestDTO dto) {
        Optional<Supplier> supplierOpt = supplierRepository.findById(dto.getSupplierId());
        Optional<Inventory> inventoryOpt = inventoryRepository.findById(dto.getInventoryId());

        if (supplierOpt.isEmpty()) {
            throw new RuntimeException("Supplier not found");
        }
        if (inventoryOpt.isEmpty()) {
            throw new RuntimeException("Inventory item not found");
        }

        Inventory inventory = inventoryOpt.get();
        inventory.setQuantity(inventory.getQuantity() + dto.getQuantity());
        inventoryRepository.save(inventory);

        Purchase purchase = new Purchase();
        purchase.setSupplier(supplierOpt.get());
        purchase.setInventory(inventory);
        purchase.setQuantity(dto.getQuantity());
        purchase.setTotalAmount(dto.getTotalAmount());
        purchase.setNotes(dto.getNotes());

        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Optional<Purchase> getPurchaseById(Long id) {
        return purchaseRepository.findById(id);
    }

    public void deletePurchase(Long id) {
        purchaseRepository.deleteById(id);
    }
}
