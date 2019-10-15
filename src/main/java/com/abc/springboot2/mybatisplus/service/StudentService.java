package com.abc.springboot2.mybatisplus.service;

import java.util.List;

import com.abc.springboot2.mybatisplus.entity.Student;

public interface StudentService {
	List<Student> selectList();
}
