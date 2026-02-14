package com.vinsup.fms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="blocks")
public class Block {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(name="description")
    private String description;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="building_id", nullable=false)
    private Building building;
    
    @Column(name = "created_by", nullable = false)//
    private String createdBy;//


    @Column(name="created_at", nullable=false, updatable=false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
    
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public LocalDateTime getCreatedAt() { return createdAt; }
}

