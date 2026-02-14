package com.vinsup.fms.dto;

public class SupplierResponseDTO {
    private String message;
    private Object data;

    public SupplierResponseDTO(String message) { this.message = message; }
    public SupplierResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
    public String getMessage() { return message; }
    public Object getData() { return data; }
}
