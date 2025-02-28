package org.jianwen.webbackend.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class User {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private String role;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
