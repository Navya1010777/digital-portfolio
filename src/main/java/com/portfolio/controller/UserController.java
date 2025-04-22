package com.portfolio.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.dto.UserDTO;
import com.portfolio.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile(Principal principal) {
        return ResponseEntity.ok(userService.getUserProfile(principal.getName()));
    }
    
    @PutMapping("/profile")
    public ResponseEntity<UserDTO> updateUserProfile(@RequestBody UserDTO userDTO, Principal principal) {
        return ResponseEntity.ok(userService.updateUserProfile(userDTO, principal.getName()));
    }
    
    @GetMapping("/teachers")
    public ResponseEntity<List<UserDTO>> getAllTeachers() {
        return ResponseEntity.ok(userService.getAllTeachers());
    }
    
    @GetMapping("/students")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<List<UserDTO>> getAllStudents() {
        return ResponseEntity.ok(userService.getAllStudents());
    }
}
