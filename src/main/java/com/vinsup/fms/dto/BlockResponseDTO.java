package com.vinsup.fms.dto;

public class BlockResponseDTO {

    private String message;

    public BlockResponseDTO(String message) {
        this.message = message;
    }

    // Getter
    public String getMessage() { return message; 
    }
}
