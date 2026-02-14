
package com.vinsup.fms.dto;

public class BlockRequestDTO {

    private String name;
    //private Long buildingId;
    private String buildingName;
    private String description; 
    // Constructors
    public BlockRequestDTO() {
    }

    public BlockRequestDTO(String name, String buildingName) {
        this.name = name;
        this.buildingName = buildingName;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
 
    
    public String getBuildingName() { return buildingName; }
    public void setBuildingName(String buildingName) { this.buildingName = buildingName; }
}