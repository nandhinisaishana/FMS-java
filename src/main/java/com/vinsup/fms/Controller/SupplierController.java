/*package com.vinsup.fms.Controller;

import com.vinsup.fms.dto.SupplierRequestDTO;
import com.vinsup.fms.dto.SupplierResponseDTO;
import com.vinsup.fms.model.Supplier;
import com.vinsup.fms.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierResponseDTO> createSupplier(@RequestBody SupplierRequestDTO dto) {
        Supplier created = supplierService.createSupplier(dto);
        return ResponseEntity.ok(new SupplierResponseDTO("Supplier created", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponseDTO> updateSupplier(@PathVariable Long id, @RequestBody SupplierRequestDTO dto) {
        Supplier updated = supplierService.updateSupplier(id, dto);
        return ResponseEntity.ok(new SupplierResponseDTO("Supplier updated", updated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponseDTO> getSupplier(@PathVariable Long id) {
        Supplier s = supplierService.getSupplierById(id);
        return ResponseEntity.ok(new SupplierResponseDTO("Supplier retrieved", s));
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SupplierResponseDTO> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok(new SupplierResponseDTO("Supplier deleted"));
    }
}
*/

package com.vinsup.fms.Controller;

import com.vinsup.fms.dto.SupplierRequestDTO;
import com.vinsup.fms.dto.SupplierResponseDTO;
import com.vinsup.fms.model.Supplier;
import com.vinsup.fms.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
	
	@Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierResponseDTO> addSupplier(@RequestBody SupplierRequestDTO dto) {
        Supplier supplier = supplierService.addSupplier(dto);
        return ResponseEntity.ok(new SupplierResponseDTO("Supplier added successfully", supplier));
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id)
                .map(s -> ResponseEntity.ok(new SupplierResponseDTO("Supplier found", s)))
                .orElse(ResponseEntity.status(404).body(new SupplierResponseDTO("Supplier not found")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SupplierResponseDTO> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok(new SupplierResponseDTO("Supplier deleted successfully"));
    }
}
