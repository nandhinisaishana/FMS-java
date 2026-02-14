package com.vinsup.fms.dto;

import jakarta.validation.constraints.NotNull;

public class TaskDTO {

    @NotNull(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Assigned user ID is required")
    private Long assignedToId;

    @NotNull(message = "Creator ID is required")
    private Long createdById;

    @NotNull(message = "Department ID is required")
    private Long departmentId;

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Long getAssignedToId() { return assignedToId; }
    public void setAssignedToId(Long assignedToId) { this.assignedToId = assignedToId; }
    public Long getCreatedById() { return createdById; }
    public void setCreatedById(Long createdById) { this.createdById = createdById; }
    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }
}
