package com.hlm.annotation;

import java.lang.reflect.Method;

public interface FlowInterface {

    public Object doPre(Object target, Method method, Object[] args) throws Exception;

    public Object doafter(Object target, Method method, Object[] args) throws Exception;

    public Object process(Object target, Method method, Object[] args)throws Exception;
}
