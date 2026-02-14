/*package com.vinsup.fms.Controller;

import com.vinsup.fms.dto.PurchaseRequestDTO;
import com.vinsup.fms.dto.PurchaseResponseDTO;
import com.vinsup.fms.model.Purchase;
import com.vinsup.fms.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<PurchaseResponseDTO> createPurchase(@RequestBody PurchaseRequestDTO dto) {
        Purchase purchase = purchaseService.createPurchase(dto);
        return ResponseEntity.ok(new PurchaseResponseDTO("Purchase created successfully", purchase));
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PurchaseResponseDTO> deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.ok(new PurchaseResponseDTO("Purchase deleted successfully"));
    }
}
*/
package com.vinsup.fms.Controller;

import com.vinsup.fms.dto.PurchaseRequestDTO;
import com.vinsup.fms.dto.PurchaseResponseDTO;
import com.vinsup.fms.model.Purchase;
import com.vinsup.fms.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<PurchaseResponseDTO> addPurchase(@RequestBody PurchaseRequestDTO dto) {
        Purchase purchase = purchaseService.addPurchase(dto);
        return ResponseEntity.ok(new PurchaseResponseDTO("Purchase added successfully", purchase));
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchaseById(@PathVariable Long id) {
        return purchaseService.getPurchaseById(id)
                .map(p -> ResponseEntity.ok(new PurchaseResponseDTO("Purchase found", p)))
                .orElse(ResponseEntity.status(404).body(new PurchaseResponseDTO("Purchase Not found")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PurchaseResponseDTO> deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.ok(new PurchaseResponseDTO("Purchase deleted successfully"));
    }
}
