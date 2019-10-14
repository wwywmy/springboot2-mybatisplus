package com.abc.springboo2.mybatisplus.service;

import com.abc.springboo2.mybatisplus.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 老师 服务类
 * </p>
 *
 * @author wanglei
 * @since 2019-10-14
 */
public interface ITeacherService extends IService<Teacher> {

	Teacher selectByNo(String no);
}
