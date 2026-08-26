package com.skillgraph.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillgraph.model.User;
import com.skillgraph.service.UserService;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create Profile
    @PostMapping
    public ResponseEntity<User> createProfile(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    // Get All Profiles
    @GetMapping
    public ResponseEntity<List<User>> getProfiles() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get Profile By ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getProfile(@PathVariable Long id) {

        User user = userService.getUserById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    // Update Profile
    @PutMapping("/{id}")
    public ResponseEntity<User> updateProfile(
            @PathVariable Long id,
            @RequestBody User updatedUser) {

        User user = userService.updateUser(id, updatedUser);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }
}