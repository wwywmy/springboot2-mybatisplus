package com.abc.springboot2.mybatisplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springboot2.mybatisplus.entity.Student;
import com.abc.springboot2.mybatisplus.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student")
@Api(value = "学生模块")
@Slf4j
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@ApiOperation(value = "查询用户", notes = "返回所有用户列表")
	@RequestMapping("/list")
	public Object selectList() {
		
		
//		ERROR 错误信息
//		WARN 警告信息
//		INFO 一般信息
//		DEBUG 调试信息
//		TRACE 跟踪信息
		
		log.trace("log trace");
		log.debug("log debug");
		log.info("log info");
		log.warn("log warn");
		log.error("log error");
		
		return studentService.selectList();
	}
	
	@ApiOperation(value = "新增用户", notes = "新增用户")
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public int insert(Student student) {
		int count = studentService.insert(student);
		return count;
	}
}
