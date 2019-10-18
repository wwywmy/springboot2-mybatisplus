package com.abc.springboot2.mybatisplus.client;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisClient {
	@Autowired
	private StringRedisTemplate redisTemplate;

	public boolean set(String key, String val) {
		try {
			redisTemplate.opsForValue().set(key, val);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Object getStr(String key) {
		return key == null ? null : redisTemplate.opsForValue().get(key);
	}

	// TODO lIST、MAP结构的set和get

	/**
	 * 功能描述：设置某个key过期时间
	 *
	 * @param key
	 * @param time
	 * @return
	 */
	public boolean expire(String key, long time) {
		try {
			if (time > 0) {
				redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 功能描述：根据key 获取过期时间
	 *
	 * @param key
	 * @return
	 */
	public long getExpire(String key) {
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}

	/**
	 * 递增
	 *
	 * @param key 键
	 * @return
	 */
	public long incr(String key, long delta) {
		return redisTemplate.opsForValue().increment(key, delta);
	}

	/**
	 * 递减
	 *
	 * @param key   键
	 * @param delta 要减少几
	 * @return
	 */
	public long decr(String key, long delta) {
		return redisTemplate.opsForValue().increment(key, -delta);
	}

}
