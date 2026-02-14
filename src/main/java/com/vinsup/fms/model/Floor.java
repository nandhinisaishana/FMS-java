
package com.vinsup.fms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "floors")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String floorNumber;
    
    @Column(name="description")
    private String description;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "block_id", nullable = false)
   // private Block block;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "block_id", nullable = false)
    private Block block;


    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFloorNumber() { return floorNumber; }
    public void setFloorNumber(String floorNumber) { this.floorNumber = floorNumber; }
 
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Block getBlock() { return block; }
    public void setBlock(Block block) { this.block = block; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
