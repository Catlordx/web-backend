package org.jianwen.webbackend.controller;

import org.jianwen.webbackend.DTO.AuthResponse;
import org.jianwen.webbackend.DTO.LoginRequest;
import org.jianwen.webbackend.config.exception.AuthException;
import org.jianwen.webbackend.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping("/authenticate/login")
    public AuthResponse authenticate(@RequestBody LoginRequest loginRequest) {
        var username = loginRequest.getUsername();
        var password = loginRequest.getPassword();

        // 假设验证通过
        if ("admin".equals(username) && "123456".equals(password)) {
            // 生成JWT Token
//            return JwtUtil.generateToken(username, "admin");
            var token = JwtUtil.generateToken(username, "admin");
            var resp = new AuthResponse();
            resp.setToken(token);
            resp.setMessage("success");
            return resp;
        } else {
            throw new AuthException("登录失败，请检查用户名和密码是否正确");
        }
    }
}
