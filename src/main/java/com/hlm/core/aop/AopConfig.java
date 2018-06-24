package com.hlm.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

//用于声明这是一个spring 管理配置的bean 
@Configuration
//声明这是一个切面类
@Aspect
public class AopConfig {
	//声明了一个表达式，描述要织入的目标的特性，如下样子就是想说com.hlm.controller.包下的类都会被织入该切面
	//@Around("@within(org.springframework.stereotype.Controller)")
	public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable{
		try {
		System.out.println("我是方法调用前执行的！");
		//调用原来方法		
		Object obj = pjp.proceed();				
		System.out.println("我是方法调用后执行的！");
		return obj ;
		
		} catch (Throwable e) {
          //不处理异常，将其抛给调用者
			throw e ;
		}
	}
}
