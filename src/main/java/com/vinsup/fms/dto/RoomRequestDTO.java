package com.vinsup.fms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RoomRequestDTO {

    @NotBlank(message = "Room number is required")
    private String roomNumber;

    private String description;

    @NotBlank(message = "Floor number is required")
    private String floorNumber;

    // Getters & Setters
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public String getFloorNumber() { return floorNumber; }
    public void setFloorNumber(String floorNumber) { this.floorNumber = floorNumber; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}

/*package com.vinsup.fms.dto;

public class RoomRequestDTO {

    private String roomNumber;
    private String type;
    private Long floorId;

    public RoomRequestDTO() {}

    public RoomRequestDTO(String roomNumber, String type, Long floorId) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.floorId = floorId;
    }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Long getFloorId() { return floorId; }
    public void setFloorId(Long floorId) { this.floorId = floorId; }
}
*/