package com.vinsup.fms.dto;

//import javax.management.relation.Role;
import com.vinsup.fms.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;
    
//    private Role role;
    private String role;
    // Getters & Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; } 
    public void setEmail(String email) { this.email = email; }

    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
//    public void setRole(Role role ) {
//    	this.role =  role;
//    }
//    public Role getRole() {
//    	return role;
//    } 
    public void setRole(String role ) {
    	this.role =  role;
    }
    public String getRole() {
    	return role;
    }
}
