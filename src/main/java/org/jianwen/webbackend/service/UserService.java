package org.jianwen.webbackend.service;

import lombok.extern.slf4j.Slf4j;
import org.jianwen.webbackend.mapper.UserMapper;
import org.jianwen.webbackend.model.User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
//    }
    public User selectUserByCardId(String cardId) {
        var user = userMapper.getUserByCardId(cardId);
        if (user == null) {
            log.warn("USER NOT EXISTS");
        }
        return user;
    }
}
