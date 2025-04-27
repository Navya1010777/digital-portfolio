package com.portfolio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.dto.UserDTO;
import com.portfolio.entity.Role;
import com.portfolio.entity.User;
import com.portfolio.exception.ResourceNotFoundException;
import com.portfolio.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UserDTO getUserProfile(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        return mapToDTO(user);
    }
    
    public UserDTO updateUserProfile(UserDTO userDTO, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        
        // Update password if provided
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        
        User updatedUser = userRepository.save(user);
        return mapToDTO(updatedUser);
    }
    
    public List<UserDTO> getAllTeachers() {
        List<User> teachers = userRepository.findByRole(Role.TEACHER);
        return teachers.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    
    public List<UserDTO> getAllStudents() {
        List<User> students = userRepository.findByRole(Role.STUDENT);
        return students.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return mapToDTO(user);
    }
    
    public UserDTO getStudentByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with username: " + username));
        
        if (user.getRole() != Role.STUDENT) {
            throw new ResourceNotFoundException("User with username: " + username + " is not a student");
        }
        
        return mapToDTO(user);
    }
    
    public List<UserDTO> searchStudentsByNameOrUsername(String query) {
        List<User> students = userRepository.findByRoleAndFullNameContainingIgnoreCaseOrUsernameContainingIgnoreCase(
                Role.STUDENT, query, query);
        
        return students.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    
    public Role getUserRole(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
                
        return user.getRole();
    }
    
    private UserDTO mapToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setRole(user.getRole());
        return dto;
    }
}