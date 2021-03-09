package com.marx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.marx.mapper.DictMapper;
import com.marx.model.Dict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试：垂直分库
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcCommonTableTests {

	@Autowired
	private DictMapper dictMapper;

	// 公共表添加数据，多个数据源同时添加  生成的dict_id也相同
	@Test
	public void addDict() {
		Dict dict = new Dict();
		dict.setStatus("正常");
		dict.setValue("公共字典value");
		dictMapper.insert(dict);
	}

	// 查找公共表数据
	@Test
	public void findDict() {
		QueryWrapper<Dict> wrapper = new QueryWrapper<>();
		wrapper.eq("dict_id", 576192999764000769L);
		Dict dict = dictMapper.selectOne(wrapper);
		System.out.println(dict);
	}

	// 公共表添加数据，多个数据源同时删除
	@Test
	public void deleteDict() {
		QueryWrapper<Dict> wrapper = new QueryWrapper<>();
		wrapper.eq("dict_id", 576192999764000769L);
		System.out.println("删除结果：" + dictMapper.delete(wrapper));
	}
}