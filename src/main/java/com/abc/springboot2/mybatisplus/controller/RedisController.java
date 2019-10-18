package com.abc.springboot2.mybatisplus.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springboot2.mybatisplus.client.RedisClient;
import com.github.javafaker.Faker;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/redis")
@Api(value = "Redis模块")
@Slf4j
public class RedisController {

//	@Autowired
//	private StringRedisTemplate redisTemplate;
//
//	@ApiOperation(value = "redis set", notes = "Redis插入字符串")
//	@RequestMapping("/set")
//	public Object set() {
//
//		String name = new Faker(Locale.CHINA).name().fullName();
//
//		log.info("name={}", name);
//
//		redisTemplate.opsForValue().set("name", name);
//
//		name = redisTemplate.opsForValue().get("name");
//
//		log.info("name={}", name);
//
//		return name;
//	}

	@Autowired
	private RedisClient redisClient;

	@ApiOperation(value = "redis set", notes = "Redis插入字符串")
	@RequestMapping("/set")
	public Object set() {
		String name = new Faker(Locale.CHINA).name().fullName();
		log.info("name={}", name);

		redisClient.set("name", name);
		name = redisClient.getStr("name").toString();
		log.info("name={}", name);

		return name;
	}
}
