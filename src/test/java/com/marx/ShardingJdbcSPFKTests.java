package com.marx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.marx.mapper.CourseMapper;
import com.marx.model.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试：水平分库
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcSPFKTests {

	@Autowired
	private CourseMapper courseMapper;

	// 添加课程
	@Test
	public void addCourse() {
		Course course = new Course();
		for (int i = 1; i < 11; i++) {
			//cid由我们设置的策略，雪花算法进行生成
			course.setCname("Java第" + i + "课");
			course.setUserId(System.currentTimeMillis());
			course.setStatus("Normal" + i);
			courseMapper.insert(course);
		}
	}

	// 查询课程
	@Test
	public void findCourse() {
		QueryWrapper<Course> wrapper = new QueryWrapper<>();
		wrapper.eq("cid", 575020801984561152L);
		wrapper.eq("user_id",1615025242561L);
		Course course = courseMapper.selectOne(wrapper);
		System.out.println(course);
	}

}