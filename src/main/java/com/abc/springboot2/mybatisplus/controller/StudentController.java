package com.abc.springboot2.mybatisplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springboot2.mybatisplus.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/student")
@Api(value = "学生模块")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@ApiOperation(value = "查询用户", notes = "返回所有用户列表")
	@RequestMapping("/list")
	public Object selectList() {
		return studentService.selectList();
	}
}
