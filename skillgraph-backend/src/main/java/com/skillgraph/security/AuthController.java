package com.skillgraph.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillgraph.dto.LoginRequest;
import com.skillgraph.dto.LoginResponse;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        // Temporary Login
        if ("admin@gmail.com".equals(request.getEmail())
                && "admin123".equals(request.getPassword())) {

            String token = jwtUtil.generateToken(request.getEmail());

            return ResponseEntity.ok(new LoginResponse(token));
        }

        return ResponseEntity.status(401).build();
    }
}