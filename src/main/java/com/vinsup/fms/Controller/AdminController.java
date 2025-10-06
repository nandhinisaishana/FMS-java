package com.vinsup.fms.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinsup.fms.dto.ApiResponse;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @GetMapping("/dashboard")
    public ApiResponse dashboard(HttpSession session){
        String role = (String) session.getAttribute("USER_ROLE");
        if(role==null) return new ApiResponse("Not authenticated");
        if(!role.equals("ROLE_ADMIN")) return new ApiResponse("Access denied: ADMIN role required");
        return new ApiResponse("Welcome to admin dashboard");
    }
}
