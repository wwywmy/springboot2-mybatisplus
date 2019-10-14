package com.abc.springboo2.mybatisplus;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.abc.springboo2.mybatisplus.entity.Student;
import com.abc.springboo2.mybatisplus.mapper.StudentMapper;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudentTest {

	@Resource
	private StudentMapper studentMapper;

	@Test
	public void selectByIdTest() {
		Student student = studentMapper.selectById(10L);
		log.info(student.toString());
	}

}
