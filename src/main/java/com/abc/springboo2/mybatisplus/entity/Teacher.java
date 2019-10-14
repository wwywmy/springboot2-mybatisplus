package com.abc.springboo2.mybatisplus.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 老师
 * </p>
 *
 * @author wanglei
 * @since 2019-10-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 工号
     */
    private String no;

    /**
     * 姓名
     */
    private String name;


}
