package com.hlm.annotation;

import java.lang.reflect.Method;

public class TestMain {

    public  static void main(String[] args){

        //通过代理生成对象
        TestInterface test = MyDynamicProxy.getProxyInstants(Test.class ,new MyCacheImpl());
        test.do3(1L);
        test.do4("樱木花道",18);
        test.do6(1L);
        System.out.println("<------------我是可爱的分割线,下面测试缓存------------>");
        test.do3(1L);
        test.do4("樱木花道",18);
        test.do6(1L);
        System.out.println("<------------我是可爱的分割线，下面测试缓存失效------------>");
        test.do5(1L);
        test.do3(1L);
    }
}
