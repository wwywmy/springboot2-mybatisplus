package com.abc.springboot2.mybatisplus.mapper;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.abc.springboot2.mybatisplus.entity.Teacher;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.javafaker.Faker;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TeacherTest {

	@Resource
	private TeacherMapper teacherMapper;

	@Test
	public void selectByIdTest() {
		Teacher teacher = teacherMapper.selectById(10L);
		log.info(teacher.toString());
	}
	
	@Test
	public void selectList() {
		QueryWrapper<Teacher> queryWrapper = new QueryWrapper<Teacher>();
		List<Teacher> teacherList = teacherMapper.selectList(queryWrapper);
		teacherList.forEach(e -> {
			log.info(e.toString());
		});
	}

	@Test
	public void insert() {
		Teacher teacher = new Teacher();
		teacher.setId(IdUtil.createSnowflake(1L, 1L).nextId());
		teacher.setNo(RandomUtil.randomString(4));
		teacher.setName(new Faker(Locale.CHINA).name().fullName());
		
		int count = teacherMapper.insert(teacher);
		log.info("count={}",count);
		log.info("teacher={}",teacher);
	}
	
}
