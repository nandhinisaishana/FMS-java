/*package com.vinsup.fms.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "checklists")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private boolean completed;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager; // Assuming you already have a User entity

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public User getManager() { return manager; }
    public void setManager(User manager) { this.manager = manager; }
}*/
