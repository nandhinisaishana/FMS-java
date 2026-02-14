/* thjs one package com.vinsup.fms.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinsup.fms.dto.ApiResponse;
import com.vinsup.fms.dto.RegisterRequest;
import com.vinsup.fms.service.AuthService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
	@Autowired
	private  AuthService authService;
	
	
	@PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody RegisterRequest req){
        return ResponseEntity.ok(authService.register(req));
    }
	
	
	
	
	
	
	@GetMapping("/dashboard")
    public ApiResponse dashboard(HttpSession session){
        String role = (String) session.getAttribute("USER_ROLE");
        if(role==null) return new ApiResponse("Not authenticated");
        //if(!role.equals("ROLE_ADMIN")) return new ApiResponse("Access denied: ADMIN role required");
        //if(!role.equals("Admin")) return new ApiResponse("Access denied: ADMIN role required");
        if (!role.equalsIgnoreCase("Admin")) return new ApiResponse("Access denied: ADMIN role required");

        return new ApiResponse("Welcome to admin dashboard");

        
    }
    
}*/
package com.vinsup.fms.Controller;
import com.vinsup.fms.dto.ApiResponse;
import com.vinsup.fms.service.AdminService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService; 
    

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    
    @GetMapping("/dashboard")
    public ApiResponse getDashboard(Authentication authentication) {
        if (authentication == null) {
                    return new ApiResponse("Not authenticated", null);
        }

        String username = authentication.getName();
      

        return adminService.getDashboard();
    }
}

