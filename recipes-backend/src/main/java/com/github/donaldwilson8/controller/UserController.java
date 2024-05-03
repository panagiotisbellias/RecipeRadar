package com.github.donaldwilson8.controller;

import com.github.donaldwilson8.model.User;
import com.github.donaldwilson8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User newUser = userService.createUser(user);
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserProfile(@PathVariable String id, @RequestBody User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User updatedUser = userService.updateUser(user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
