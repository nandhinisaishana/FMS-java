package com.vinsup.fms.dto;

import java.time.LocalDateTime;

public class InventoryResponseDTO {
    private String message;
    private Object data;

    public InventoryResponseDTO(String message) { this.message = message; }
    public InventoryResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() { return message; }
    public Object getData() { return data; }
}
