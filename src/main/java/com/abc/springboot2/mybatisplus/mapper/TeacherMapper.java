package com.abc.springboot2.mybatisplus.mapper;

import com.abc.springboot2.mybatisplus.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 老师 Mapper 接口
 * </p>
 *
 * @author wanglei
 * @since 2019-10-14
 */
public interface TeacherMapper extends BaseMapper<Teacher> {

	Teacher selectByNo(String no);
}
