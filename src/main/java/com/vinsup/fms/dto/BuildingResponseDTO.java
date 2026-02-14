package com.vinsup.fms.dto;

import java.time.LocalDateTime;

public class BuildingResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String createdBy;
    private LocalDateTime createdAt;

    public BuildingResponseDTO(Long id, String name, String description, String createdBy, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    // Getters only (no setters since it's read-only)
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCreatedBy() { return createdBy; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
