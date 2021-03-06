package com.marx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.marx.model.Course;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper extends BaseMapper<Course> {

}