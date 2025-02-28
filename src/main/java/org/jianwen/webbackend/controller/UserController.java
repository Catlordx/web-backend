package org.jianwen.webbackend.controller;

import org.jianwen.webbackend.DTO.LoginRequest;
import org.jianwen.webbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
