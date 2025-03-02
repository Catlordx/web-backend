package org.jianwen.webbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private Integer logId;    // 日志ID
    private String cardId;    // 操作人校园卡号
    private String action;    // 操作类型
    private Integer copyId;   // 相关副本ID
    private Date timestamp;   // 操作时间
}