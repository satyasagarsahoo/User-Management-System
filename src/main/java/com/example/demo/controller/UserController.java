package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/")
    public String home() {
        return "index"; // renders index.html from templates
    }
    @Autowired
    private UserService service;
    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user){
        return service.saveUser(user);
    }
    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
    // Get user by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }
    // Delete user by ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}
