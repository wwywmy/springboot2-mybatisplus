package com.abc.springboot2.mybatisplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.abc.springboot2.mybatisplus.entity.Student;
import com.abc.springboot2.mybatisplus.mapper.StudentMapper;
import com.abc.springboot2.mybatisplus.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentMapper studentMapper;

	@Override
	public List<Student> selectList() {
		List<Student> studentList = studentMapper.selectList(new QueryWrapper<Student>());
		return studentList;
	}

}
