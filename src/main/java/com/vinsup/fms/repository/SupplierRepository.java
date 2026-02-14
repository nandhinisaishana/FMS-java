/*package com.vinsup.fms.repository;

import com.vinsup.fms.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    boolean existsBySupplierName(String supplierName);
}

*/
package com.vinsup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vinsup.fms.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
