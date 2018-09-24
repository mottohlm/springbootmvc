package com.hlm.annotation;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 我的动态代理类
 */
public class MyDynamicProxy implements InvocationHandler {

    Logger log = LoggerFactory.getLogger(MyDynamicProxy.class);

    private Object target ;//当前代理目标
    private Object proxy ;//当前代理
    private FlowInterface flowInterface ;//方法前后需要注入的东西在此类中定义
    //用于存储一些已生成过代理的对象，防止重得生成浪费性能（相当于自己的一个缓存）
    private static Map<Class<?>,MyDynamicProxy> myMap = new HashMap<Class<?>,MyDynamicProxy>();


    public MyDynamicProxy(){

    }

    /**
     * 获取入参的代理对象方法
     * @param clazz
     * @param flowInterface
     * @param <T>
     * @return
     */
    public synchronized  static<T> T getProxyInstants(Class<T> clazz , FlowInterface flowInterface){

        //优先在自己的缓存内寻找
        MyDynamicProxy newProxy = myMap.get(clazz) ;
        if(newProxy != null){
            return (T)newProxy.getProxy() ;
        }
        //找不到则新建一个
        newProxy = new MyDynamicProxy();
        try{
            //先为目标类生成目标对象(如果该类中有一些自动注入的属性会有什么情况呢)
            T target = clazz.newInstance();
            Annotation[] l = clazz.getDeclaredAnnotations();
            //生成代理对象
            T proxy = (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),newProxy);

            //设置
            newProxy.setTarget(target);
            newProxy.setProxy(proxy);
            newProxy.setFlowInterface(flowInterface);
            myMap.put(clazz , newProxy) ;

        } catch (IllegalAccessException e) {

            e.printStackTrace();
        } catch (InstantiationException e) {

            e.printStackTrace();
        }

        //返回生成的代理
        return (T)newProxy.getProxy() ;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //log.info("调用方法"+method.getName()+"前");
        /*flowInterface.doPre(method.getName(),args);
        Object result = method.invoke(target , args) ;
        //log.info("调用方法"+method.getName()+"后");
        flowInterface.doPre(method.getName(),args);*/
        Object result = flowInterface.process(target ,method,args) ;
        return result;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return proxy;
    }

    public void setProxy(Object proxy) {
        this.proxy = proxy;
    }

    public FlowInterface getFlowInterface() {
        return flowInterface;
    }

    public void setFlowInterface(FlowInterface flowInterface) {
        this.flowInterface = flowInterface;
    }
}
