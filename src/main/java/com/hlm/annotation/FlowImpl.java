package com.hlm.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class FlowImpl implements  FlowInterface {
    Logger log = LoggerFactory.getLogger(MyDynamicProxy.class);
    @Override
    public Object doPre(Object target, Method method, Object[] args) {
        log.info("调用方法"+method.getName()+"前");
        return null;
    }

    @Override
    public Object doafter(Object target, Method method, Object[] args) {
        log.info("调用方法"+method.getName()+"后");
        return null;
    }

    @Override
    public Object process(Object target, Method method, Object[] args)throws Exception {
        this.doPre(target,method ,args);
        Object obj = null ;
        try{
             obj = method.invoke(target ,args) ;
        }catch(Exception e){
            throw e ;
        }
        this.doafter(target,method ,args);
        return obj;
    }
}
