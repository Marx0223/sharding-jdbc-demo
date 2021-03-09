package com.marx.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用于垂直分库
 */
@Data
@TableName("t_user")
public class User {
    private Long userId;
    private String username;
    private String status;
}