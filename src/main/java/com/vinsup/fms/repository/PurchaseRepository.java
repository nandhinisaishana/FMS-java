/*package com.vinsup.fms.repository;

import com.vinsup.fms.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
*/

package com.vinsup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vinsup.fms.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
