package com.vinsup.fms.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinsup.fms.dto.ApiResponse;
import com.vinsup.fms.dto.ForgotRequest;
import com.vinsup.fms.dto.LoginRequest;
import com.vinsup.fms.dto.RegisterRequest;
import com.vinsup.fms.dto.VerifyOtpRequest;
import com.vinsup.fms.service.AuthService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){this.authService=authService;}

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody RegisterRequest req){
        return ResponseEntity.ok(authService.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody LoginRequest req, HttpSession session){
        return ResponseEntity.ok(authService.login(req,session));
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse> logout(HttpSession session){
        return ResponseEntity.ok(authService.logout(session));
    }

    @PostMapping("/forgot")
    public ResponseEntity<ApiResponse> forgot(@Valid @RequestBody ForgotRequest req){
        return ResponseEntity.ok(authService.sendOtp(req));
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<ApiResponse> verifyOtp(@Valid @RequestBody VerifyOtpRequest req){
        return ResponseEntity.ok(authService.verifyOtpAndReset(req));
    }
}
