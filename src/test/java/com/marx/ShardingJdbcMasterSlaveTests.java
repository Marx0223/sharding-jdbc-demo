package com.marx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.marx.mapper.DictMapper;
import com.marx.mapper.UserMapper;
import com.marx.model.Dict;
import com.marx.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试：主从复制，读写分离
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcMasterSlaveTests {

	@Autowired
	private UserMapper userMapper;

	// 添加User
	@Test
	public void addUser() {
		User user = new User();
		for (int i = 1; i < 11; i++) {
			// user_id由我们设置的策略，雪花算法进行生成
			user.setUsername("Java第" + i + "课");
			user.setStatus("Normal" + i);
			userMapper.insert(user);
		}
	}

	// 查询User
	@Test
	public void findUser() {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("user_id",576433122162245632L);
		User user = userMapper.selectOne(wrapper);
		System.out.println(user);
	}
}