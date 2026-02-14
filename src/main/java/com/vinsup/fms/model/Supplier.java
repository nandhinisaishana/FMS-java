/*package com.vinsup.fms.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String supplierName;

    private String contactPerson;
    private String email;
    private String phone;
    private String address;

    
     Optional textual service commitment (e.g. "6 months free maintenance")
     or structured fields could be added later.
     
    private String serviceCommitment;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    // If you want the relationship from Supplier -> Purchase
    // uncomment if Purchase entity exists and mappedBy="supplier"
    // @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    // private List<Purchase> purchases;

    // Getters & setters (omitted here for brevity — add them)
    // Or generate with your IDE
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getServiceCommitment() { return serviceCommitment; }
    public void setServiceCommitment(String serviceCommitment) { this.serviceCommitment = serviceCommitment; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
*/

package com.vinsup.fms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable = false)
    //private String name;

    @Column(name = "supplier_name")
    private String name;

    private String email;
    private String phone;
    private String address;
    private String serviceCommitment; // e.g. 6 months warranty

    private LocalDateTime createdAt = LocalDateTime.now();

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getServiceCommitment() { return serviceCommitment; }
    public void setServiceCommitment(String serviceCommitment) { this.serviceCommitment = serviceCommitment; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
