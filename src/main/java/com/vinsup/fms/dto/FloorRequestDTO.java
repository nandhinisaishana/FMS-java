package com.vinsup.fms.dto;

import jakarta.validation.constraints.NotBlank;

public class FloorRequestDTO {

    @NotBlank(message = "Floor number is required")
    private String floorNumber;

    private String description; 

    @NotBlank(message = "Block name is required")
    private String blockName;

    // Getters & Setters
    public String getFloorNumber() { return floorNumber; }
    public void setFloorNumber(String floorNumber) { this.floorNumber = floorNumber; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getBlockName() { return blockName; }
    public void setBlockName(String blockName) { this.blockName = blockName; }
}
