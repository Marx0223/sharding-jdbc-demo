package com.marx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.marx.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}