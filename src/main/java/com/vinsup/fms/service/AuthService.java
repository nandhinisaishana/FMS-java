package com.vinsup.fms.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vinsup.fms.dto.ApiResponse;
import com.vinsup.fms.dto.ForgotRequest;
import com.vinsup.fms.dto.LoginRequest;
import com.vinsup.fms.dto.RegisterRequest;
import com.vinsup.fms.dto.VerifyOtpRequest;
import com.vinsup.fms.model.Role;
import com.vinsup.fms.model.User;
import com.vinsup.fms.repository.RoleRepository;
import com.vinsup.fms.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;
    private final OtpRedisService otpRedisService;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder, MailService mailService,
                       OtpRedisService otpRedisService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailService = mailService;
        this.otpRedisService = otpRedisService;
    }

    public ApiResponse register(RegisterRequest req) {
        if(!req.getPassword().equals(req.getConfirmPassword()))
            return new ApiResponse("Passwords do not match");

        if(userRepository.existsByEmail(req.getEmail()))
            return new ApiResponse("Email already exists");

        //Role role = roleRepository.findByName("ROLE_USER")
          //      .orElseGet(()->roleRepository.save(new Role(){ { setName("ROLE_USER"); } }));
        
        Role role = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> {
                    Role r = new Role();
                    r.setName("ROLE_USER");
                    return roleRepository.save(r);
                });


        User u = new User();
        u.setFullName(req.getFullName());
        u.setEmail(req.getEmail().toLowerCase());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u.setRole(role);
        userRepository.save(u);

        return new ApiResponse("User registered successfully");
    }
    
	
    
    

    public ApiResponse login(LoginRequest req, HttpSession session) {
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
//        session.setAttribute("USER_ID",u.getId());
//        session.setAttribute("USER_EMAIL",u.getEmail());
//        session.setAttribute("USER",identifier);
//        session.setAttribute("USER_ROLE",u.getRole().getName());

        return new ApiResponse("Login successful");
    }

    public Boolean isEmail(String input) {
    	
    	return input != null && input.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }


    
    
    public ApiResponse logout(HttpSession session) {
        session.invalidate();
        return new ApiResponse("Logged out successfully");
    }

    public ApiResponse sendOtp(ForgotRequest req) {
        var maybe = userRepository.findByEmail(req.getEmail().toLowerCase());
        if(maybe.isEmpty()) return new ApiResponse("Email not found");

        String otp = otpRedisService.generateAndSaveOtp(req.getEmail());
        mailService.sendOtpEmail(req.getEmail(),otp,5);

        return new ApiResponse("OTP sent to email");
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
    }
}
