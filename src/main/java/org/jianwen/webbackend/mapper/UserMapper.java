package org.jianwen.webbackend.mapper;

import org.apache.ibatis.annotations.*;
import org.jianwen.webbackend.model.User;

import java.util.List;

public interface UserMapper {
    @Insert("INSERT INTO Users (UserID, Username, Password, FullName, Email, Phone, Role) " +
            "VALUES (#{userID}, #{username}, #{password}, #{fullName}, #{email}, #{phone}, #{role})")
    int insertUser(User user);

    // 根据 UserID 查询用户
    @Select("SELECT * FROM Users WHERE UserID = #{userID}")
    User selectUserById(@Param("userID") String userID);

    // 根据 Username 查询用户
    @Select("SELECT * FROM Users WHERE Username = #{username}")
    User selectUserByUsername(@Param("username") String username);

    // 查询所有用户
    @Select("SELECT * FROM Users")
    List<User> selectAllUsers();

    // 更新用户信息
    @Update("UPDATE Users SET Username = #{username}, Password = #{password}, FullName = #{fullName}, " +
            "Email = #{email}, Phone = #{phone}, Role = #{role} WHERE UserID = #{userID}")
    int updateUser(User user);

    // 根据 UserID 删除用户
    @Delete("DELETE FROM Users WHERE UserID = #{userID}")
    int deleteUserById(@Param("userID") String userID);

    // 根据 Email 查询用户
    @Select("SELECT * FROM Users WHERE Email = #{email}")
    User selectUserByEmail(@Param("email") String email);

    // 根据 Role 查询用户
    @Select("SELECT * FROM Users WHERE Role = #{role}")
    List<User> selectUsersByRole(@Param("role") String role);
}
