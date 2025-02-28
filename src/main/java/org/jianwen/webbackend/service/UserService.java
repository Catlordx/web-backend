package org.jianwen.webbackend.service;

import org.jianwen.webbackend.DTO.LoginRequest;
import org.jianwen.webbackend.mapper.UserMapper;
import org.jianwen.webbackend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        User userOptional = userMapper.selectUserByUsername(loginRequest.getUsername());
        if (userOptional == null) {
            return ResponseEntity.badRequest().body("不存在该用户名!");
        }
//        if (!PasswordEncoderUtil.matches(loginRequest.getPassword(), userOptional.getPassword())) {
//            return ResponseEntity.ok().body("密码错误！");
//        }
        Map<String, String> resp = new HashMap<>();
        resp.put("token", "123");
        return ResponseEntity.ok(resp);
    }
}
