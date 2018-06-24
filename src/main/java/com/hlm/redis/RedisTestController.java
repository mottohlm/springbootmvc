package com.hlm.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis")
public class RedisTestController {
	
	@Autowired
	private StringRedisTemplate redisClient;
	
	/**
	 * /redis/env
	 */
	@RequestMapping("/env")
	public @ResponseBody Object env(String params){
		
		redisClient.opsForValue().set("testenv", params);
		String str = redisClient.opsForValue().get("testenv");
		return str;
	}
	
	/**
	 * /redis/getById
	 */
	@RequestMapping("/getById")
	public @ResponseBody Object getById(Long id){
		String str = "我是实时获取的！";
		return str;
	}

}
