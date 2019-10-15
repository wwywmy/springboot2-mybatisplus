package com.abc.springboot2.mybatisplus.service.impl;

import org.springframework.stereotype.Service;

import com.abc.springboot2.mybatisplus.entity.Teacher;
import com.abc.springboot2.mybatisplus.mapper.TeacherMapper;
import com.abc.springboot2.mybatisplus.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 老师 服务实现类
 * </p>
 *
 * @author wanglei
 * @since 2019-10-14
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {
	public Teacher selectByNo(String no) {
		return baseMapper.selectByNo(no);
	}
}
