/*package com.vinsup.fms.service;

import com.vinsup.fms.ResourceNotFoundException;
import com.vinsup.fms.dto.SupplierRequestDTO;
import com.vinsup.fms.model.Supplier;
import com.vinsup.fms.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier createSupplier(SupplierRequestDTO dto) {
        Supplier s = new Supplier();
        s.setSupplierName(dto.getSupplierName());
        s.setContactPerson(dto.getContactPerson());
        s.setEmail(dto.getEmail());
        s.setPhone(dto.getPhone());
        s.setAddress(dto.getAddress());
        s.setServiceCommitment(dto.getServiceCommitment());
        return supplierRepository.save(s);
    }

    public Supplier updateSupplier(Long id, SupplierRequestDTO dto) {
        Supplier s = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id " + id));
        s.setSupplierName(dto.getSupplierName());
        s.setContactPerson(dto.getContactPerson());
        s.setEmail(dto.getEmail());
        s.setPhone(dto.getPhone());
        s.setAddress(dto.getAddress());
        s.setServiceCommitment(dto.getServiceCommitment());
        return supplierRepository.save(s);
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id " + id));
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public void deleteSupplier(Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new ResourceNotFoundException("Supplier not found with id " + id);
        }
        supplierRepository.deleteById(id);
    }
}
*/


package com.vinsup.fms.service;

import com.vinsup.fms.dto.SupplierRequestDTO;
import com.vinsup.fms.model.Supplier;
import com.vinsup.fms.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier addSupplier(SupplierRequestDTO dto) {
        Supplier supplier = new Supplier();
        supplier.setName(dto.getName());
        supplier.setEmail(dto.getEmail());
        supplier.setPhone(dto.getPhone());
        supplier.setAddress(dto.getAddress());
        supplier.setServiceCommitment(dto.getServiceCommitment());
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}

