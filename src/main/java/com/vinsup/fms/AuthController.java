package com.vinsup.fms;



import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody Map<String, String> req) {
        return userService.signup(
                req.get("username"),
                req.get("password"),
                req.get("roleName")
        );
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> req) {
        String username = req.get("username");
        String password = req.get("password");
        String role = req.get("role");

        boolean ok = userService.login(username, password, role.toUpperCase());

        return ok ? role + " login successful" : "Invalid credentials";
    }
}
