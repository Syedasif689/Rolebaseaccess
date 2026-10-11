package com.codtech.rbac.controller;

import com.codtech.rbac.entity.User;
import com.codtech.rbac.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // USER, MANAGER, and ADMIN can access their profile endpoint
    @GetMapping("/user/profile")
    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    public String userProfile(Authentication authentication) {
        return "Welcome " + authentication.getName()
                + ". You have access to the user profile.";
    }

    // MANAGER and ADMIN can access the manager dashboard
    @GetMapping("/manager/dashboard")
    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    public String managerDashboard(Authentication authentication) {
        return "Welcome " + authentication.getName()
                + ". You have access to the manager dashboard.";
    }

    // Only ADMIN can access the admin dashboard
    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminDashboard(Authentication authentication) {
        return "Welcome " + authentication.getName()
                + ". You have access to the admin dashboard.";
    }

    // Only ADMIN can view all registered users
    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Only ADMIN can view a user by ID
    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}