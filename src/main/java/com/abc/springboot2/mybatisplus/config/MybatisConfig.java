package com.abc.springboot2.mybatisplus.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.abc.springboot2.mybatisplus.mapper")
public class MybatisConfig {

}
