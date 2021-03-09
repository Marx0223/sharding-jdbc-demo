package com.marx.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 多个数据源的公共表
 */
@Data
@TableName("t_dict")
public class Dict {
    private Long dictId;
    private String status;
    private String value;
}