package com.hlm.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class TestMain {
    Logger log = LoggerFactory.getLogger(TestMain.class);
    public  static void main(String[] args){

        //通过代理生成对象
        TestInterface test = MyDynamicProxy.getProxyInstants(Test.class);
        System.out.println(test.do3(1L));
        System.out.println(test.do4("樱木花道",18));
        System.out.println(test.do6(1L));
        System.out.println("<------------我是可爱的分割线,下面测试缓存------------>");
        System.out.println(test.do3(1L));
        System.out.println(test.do4("樱木花道",18));
        System.out.println(test.do6(1L));
        System.out.println("<------------我是可爱的分割线，下面测试缓存失效------------>");
        test.do5(1L);
        System.out.println(test.do3(1L));
    }
}
