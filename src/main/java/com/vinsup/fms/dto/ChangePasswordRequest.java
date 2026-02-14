
package com.vinsup.fms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ChangePasswordRequest {
    @Email @NotBlank private String email;
    @NotBlank private String newPassword;
    @NotBlank private String confirmPassword;

    public String getEmail() { 
    	return email; 
    }
    public void setEmail(String email) {
    	this.email = email; 
    }
    public String getNewPassword() { 
    	return newPassword; 
    	}
    public void setNewPassword(String newPassword) 
    { 
    	this.newPassword = newPassword; 
    }
    public String getConfirmPassword() { 
    	return confirmPassword; 
    	}
    public void setConfirmPassword(String confirmPassword) { 
    	this.confirmPassword = confirmPassword;
    }
    
}
