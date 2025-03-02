package org.jianwen.webbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String cardId;   // 校园卡号
    private String name;     // 姓名
    private String userType; // 用户类型（student / staff）
    private String email;    // 邮箱
    private String phone;    // 手机号码
}

