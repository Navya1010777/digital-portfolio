package com.portfolio.dto;

import com.portfolio.entity.Role;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String fullName;
    private Role role;
    private String password; // Used only for update, not returned in responses
    
    public UserDTO() {
    }

    public UserDTO(Long id, String username, String email, String fullName, Role role, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.password = password;
    }

    

}
