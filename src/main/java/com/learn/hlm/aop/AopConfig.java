package com.learn.hlm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

//用于声明这是一个spring 管理配置的bean 
@Configuration
//声明这是一个切面类
@Aspect
public class AopConfig {

	ConcurrentHashMap<String ,Object> cache = new ConcurrentHashMap<String ,Object>();

	Logger log = LoggerFactory.getLogger(AopConfig.class);

	//声明了一个表达式，描述要织入的目标的特性，如下样子就是想说com.learn.hlm.provider.包下的类都会被织入该切面
	@Around("execution(*  com.learn.hlm.provider.*.get*(..)) or execution(*  com.learn.hlm.provider.*.find*(..))")
	public Object storeCache(final ProceedingJoinPoint pjp) throws Throwable{
		try {
			log.info("查询缓存中是否有结果！");
			Object[] os = pjp.getArgs();
			StringBuffer key = new StringBuffer(pjp.getSignature().getName()) ;
			if(os != null && os.length >0){
				for(Object o : os){
					if(o == null ) continue ;
					key.append(o.toString());
				}
			}
			Object obj = cache.get(key.toString()) ;
			if(obj != null){
				log.info("缓存命中结果！");
				return obj ;
			}
		//调用原来方法		
		 obj = pjp.proceed();
			if(obj == null){
				return obj ;
			}
		 log.info("对查询结果进行缓存！");
			cache.put(key.toString() , obj) ;
		return obj ;
		
		} catch (Throwable e) {
          //不处理异常，将其抛给调用者
			throw e ;
		}
	}
}
