package com.abc.springboo2.mybatisplus.service.impl;

import com.abc.springboo2.mybatisplus.entity.Teacher;
import com.abc.springboo2.mybatisplus.mapper.TeacherMapper;
import com.abc.springboo2.mybatisplus.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
