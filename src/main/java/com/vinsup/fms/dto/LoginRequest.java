package com.vinsup.fms.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
//    @NotBlank
    private String name; 
    @NotBlank
   private String user; // email or name 
   
    @NotBlank
    private String password;

    // Getters and Setters
    public String name() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    
    public String getUser() {
    	return user;
    }
    public void setUser(String userIdentifier) {
    	this.user = userIdentifier;
    }
}
