package org.jianwen.webbackend.mapper;

import org.apache.ibatis.annotations.*;
import org.jianwen.webbackend.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    // 插入用户
    @Insert("INSERT INTO users (card_id, name, user_type, email, phone) VALUES (#{cardId}, #{name}, #{userType}, #{email}, #{phone})")
    int insertUser(User user);

    // 根据校园卡号查询用户
    @Select("SELECT * FROM users WHERE card_id = #{cardId}")
    User getUserByCardId(String cardId);

    // 查询所有用户
    @Select("SELECT * FROM users")
    List<User> getAllUsers();

    // 更新用户信息
    @Update("UPDATE users SET name = #{name}, user_type = #{userType}, email = #{email}, phone = #{phone} WHERE card_id = #{cardId}")
    int updateUser(User user);

    // 根据校园卡号删除用户
    @Delete("DELETE FROM users WHERE card_id = #{cardId}")
    int deleteUser(String cardId);
}
