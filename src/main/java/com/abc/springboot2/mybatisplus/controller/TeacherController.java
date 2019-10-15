package com.abc.springboot2.mybatisplus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.springboot2.mybatisplus.service.ITeacherService;

/**
 * <p>
 * 老师 前端控制器
 * </p>
 *
 * @author wanglei
 * @since 2019-10-14
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private ITeacherService teacherSerivce;
	
	@RequestMapping("/list")
	@ResponseBody
	public Object list() {
		return teacherSerivce.list();
	}
	
	@RequestMapping("/selectByNo/{no}")
	@ResponseBody
	public Object selectByNo(@PathVariable("no")String no) {
		return teacherSerivce.selectByNo(no);
	}
}
