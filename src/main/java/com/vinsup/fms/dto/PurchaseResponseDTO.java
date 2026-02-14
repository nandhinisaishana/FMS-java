package com.vinsup.fms.dto;

public class PurchaseResponseDTO {
    private String message;
    private Object data;

    public PurchaseResponseDTO(String message) { this.message = message; }
    public PurchaseResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() { return message; }
    public Object getData() { return data; }
}
