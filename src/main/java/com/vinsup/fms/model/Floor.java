/*package com.vinsup.fms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="floors")
public class Floor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String floorNumber;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="block_id", nullable=false)
	private Block block;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="created_by", nullable=false)
	private User createdBy;
	
	@Column(name="created_at, nullable=false")
	private LocalDateTime createdAt;
	
	

	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	@PrePersist
	public void prePersist() {
		createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		createdAt = LocalDateTime.now();
	}
}
*/
/*
package com.vinsup.fms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="floors")
public class Floor {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String floorNumber;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="block_id", nullable=false)
    private Block block;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="created_by", nullable=false)
    private User createdBy;
    
    @Column(name="created_at", nullable=false)
    private LocalDateTime createdAt;
    
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
    
    
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Room> rooms;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}*/
