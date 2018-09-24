package com.hlm.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test implements TestInterface {

    Logger log = LoggerFactory.getLogger(Test.class);

    @Override
    public void do1(String str) {
        System.out.println("进入到do1 方法，入参数为："+str);
    }

    @Override
    public void do2(String str) {
        System.out.println("进入到do2 方法，入参数为："+str);
    }

    @MyCache(value="Test" , key="{#id}")
    @Override
    public String do3(Long id) {
        log.info("从数据库取得结果");
        return "我是do3的结果";
    }

    @MyCache(value="Test" , key="{#name,#age}")
    @Override
    public String do4(String name, Integer age) {
        return "我是do4的结果";
    }

    @EviMyCache(value="Test" , key="{#id}")
    @Override
    public void do5(Long id){
        log.info("正在运行do5方法");
    }

    @MyCache(value="Test" , key="{#id,special}")
    @Override
    public String do6(Long id){
        return "我是do6的结果";
    }
}
