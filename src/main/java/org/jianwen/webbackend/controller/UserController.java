package org.jianwen.webbackend.controller;

import org.jianwen.webbackend.model.User;
import org.jianwen.webbackend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{cardId}")
    public User getUserByCardId(@PathVariable String cardId) {
        return userService.selectUserByCardId(cardId);
    }
}
