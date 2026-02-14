package com.vinsup.fms.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vinsup.fms.dto.ApiResponse;
import com.vinsup.fms.dto.ChangePasswordRequest;
import com.vinsup.fms.dto.ForgotRequest;
import com.vinsup.fms.dto.LoginRequest;
import com.vinsup.fms.dto.RegisterRequest;
import com.vinsup.fms.dto.VerifyOtpRequest;
import com.vinsup.fms.model.Role;
import com.vinsup.fms.model.User;
import com.vinsup.fms.repository.RoleRepository;
import com.vinsup.fms.repository.UserRepository;
import com.vinsup.fms.security.JwtUtil;

import jakarta.servlet.http.HttpSession;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;
    private final OtpRedisService otpRedisService;
    private final JwtUtil jwtUtils;
    public AuthService(UserRepository userRepository, RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder, MailService mailService,
                       OtpRedisService otpRedisService,JwtUtil jwtutils) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailService = mailService;
        this.otpRedisService = otpRedisService;
        this.jwtUtils = jwtutils;
    }
    @Autowired
    private RoleRepository RoleRepository;

    public Long getRoleIdByName(String roleName) {
        Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
        return role.getId(); // This is the role_id in DB
    }

    public ApiResponse register(RegisterRequest req) {
        if(!req.getPassword().equals(req.getConfirmPassword()))
            return new ApiResponse<>("Passwords do not match");

        if(userRepository.existsByEmail(req.getEmail()))
            return new ApiResponse<>("Email already exists");

        //Role role = roleRepository.findByName("ROLE_USER")
          //      .orElseGet(()->roleRepository.save(new Role(){ { setName("ROLE_USER"); } }));
        
//        Role role = roleRepository.findByName("ROLE_USER")
//                .orElseGet(() -> {
//                    Role r = new Role();
//                    r.setName("ROLE_USER");
//                    return roleRepository.save(r);
//                });

        
        User u = new User();
        
        u.setFullName(req.getFullName());
        
        u.setEmail(req.getEmail().toLowerCase());
        
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        
        System.out.println("req Data : "+req);
        
        u.setRole(getRoleIdByName(req.getRole().toString()));
        
        System.out.println("User Data : "+u.getRole());
        
        userRepository.save(u);

        return new ApiResponse<>("User Registered  ");
        
       
    
    }
    
	
    
    

    /*public ApiResponse login(LoginRequest req, HttpSession session) {
//        var maybe = userRepository.findByEmail(req.name().toLowerCase());
//        if(maybe.isEmpty()) return new ApiResponse("Email not found");
//        User u = maybe.get();
//        if(!passwordEncoder.matches(req.getPassword(),u.getPassword()))
//            return new ApiResponse("Wrong password");
        req.setUser("user");
        
        Optional<User> identifierFromDb;
        
        String identifier = req.getUser();
        if(this.isEmail(identifier)) {
//        	u.setEmail(identifier);
        	identifierFromDb = userRepository.findByEmail(identifier);
        }
        else
        {
//        	u.setFullName(identifier);
        	identifierFromDb = userRepository.findByfullName(identifier);
        	
        }
     //session.setAttribute("USER_ID",u.getId());
      //session.setAttribute("USER_EMAIL",u.getEmail());
      //session.setAttribute("USER",identifier);
     //session.setAttribute("USER_ROLE",u.getRole().getName());

        return new ApiResponse("Login successful");
    }

    public Boolean isEmail(String input) {
    	
    	return input != null && input.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
*/
    
    public ApiResponse login(LoginRequest req, HttpSession session) {
        String identifier = req.getUser(); // email or full name
        Optional<User> maybeUser;

        // Determine if the input is email or full name
        if (isEmail(identifier)) {
            maybeUser = userRepository.findByEmail(identifier.toLowerCase());
        } else {
            maybeUser = userRepository.findByfullName(identifier);
        }

        if (maybeUser.isEmpty()) {
            return new ApiResponse<>("User not found"); 
        }

        User user = maybeUser.get();
 

        // Check password
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            return new ApiResponse<>("Wrong password");
        }
        		
        String token = jwtUtils.generateToken(user.getEmail());

        // Store user info in session
    session.setAttribute("USER_ID", user.getId());
    session.setAttribute("USER_EMAIL", user.getEmail());
    session.setAttribute("USER_NAME", user.getFullName());
//        session.setAttribute("ROLE_USER", user.getRole().getName());

        return new ApiResponse<>("Login successful", Map.of("token", token));
    }

    // Helper method
    private boolean isEmail(String input) {
        return input != null && input.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }


    
    
    public ApiResponse logout(HttpSession session) {
        session.invalidate();
        return new ApiResponse("Logged out successfully");
    }

    
    /*
    public ApiResponse sendOtp(ForgotRequest req) {
        var maybe = userRepository.findByEmail(req.getEmail().toLowerCase());
        if(maybe.isEmpty()) return new ApiResponse("Email not found");

        String otp = otpRedisService.generateAndSaveOtp(req.getEmail());
        mailService.sendOtpEmail(req.getEmail(),otp,5);

        return new ApiResponse<>("OTP sent to email");
    }

    public ApiResponse verifyOtpAndReset(VerifyOtpRequest req) {
        if(!req.getNewPassword().equals(req.getConfirmPassword()))
            return new ApiResponse("Passwords do not match");

        boolean valid = otpRedisService.validateOtp(req.getEmail(),req.getOtp());
        if(!valid) return new ApiResponse("Invalid or expired OTP");

        var maybe = userRepository.findByEmail(req.getEmail().toLowerCase());
        if(maybe.isEmpty()) return new ApiResponse("Email not found");

        User u = maybe.get();
        u.setPassword(passwordEncoder.encode(req.getNewPassword()));
        userRepository.save(u);

        return new ApiResponse("Password reset successful");
    }*/
    

    // Step 1: Send OTP
    public ApiResponse sendOtp(ForgotRequest req) {
        Optional<User> maybe = userRepository.findByEmail(req.getEmail().toLowerCase());
        if (maybe.isEmpty()) return new ApiResponse("Email not found");

        String otp = otpRedisService.generateAndSaveOtp(req.getEmail());
        mailService.sendOtpEmail(req.getEmail(), otp, 5);

        return new ApiResponse<>("OTP sent to email");
    }

    
    // Step 2: Verify OTP
    public ApiResponse verifyOtp(VerifyOtpRequest req) {
        boolean valid = otpRedisService.validateOtp(req.getEmail(), req.getOtp());
        if (!valid) return new ApiResponse("Invalid or expired OTP");
        return new ApiResponse("OTP verified successfully");
    }

    
    // Step 3: Change password after OTP verified
    public ApiResponse changePassword(ChangePasswordRequest req) {
        if (!req.getNewPassword().equals(req.getConfirmPassword()))
            return new ApiResponse("Passwords do not match ");

        Optional<User> maybe = userRepository.findByEmail(req.getEmail().toLowerCase());
        if (maybe.isEmpty()) return new ApiResponse("Email not found");

        User u = maybe.get();
        u.setPassword(passwordEncoder.encode(req.getNewPassword()));
        userRepository.save(u);

        return new ApiResponse("Password changed successfully");
    }
}
