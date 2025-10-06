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
@Table(name="rooms")
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String roomNumber;
	
	@Column
	private String type;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="floor_id", nullable=false)
	private Floor floor;
	
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
}*/
/*
package com.vinsup.fms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="rooms")
public class Room {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String roomNumber;

    @Column
    private String type;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="floor_id", nullable=false)
    private Floor floor;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="created_by", nullable=false)
    private User createdBy;

    @Column(name="created_at", nullable=false)
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
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
}
*/