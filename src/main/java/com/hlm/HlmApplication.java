package com.hlm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动类，放在此位置能让Spring Boot 扫描整个项目
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableCaching
public class HlmApplication {

	public static void main(String[] args) {
		SpringApplication.run(HlmApplication.class,args);

	}

}
