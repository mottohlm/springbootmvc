package com.hlm.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.concurrent.ConcurrentHashMap;

public class MyCacheImpl implements FlowInterface {

    ConcurrentHashMap<String , Object> cache = new ConcurrentHashMap<String , Object>();

    Logger log = LoggerFactory.getLogger(MyCacheImpl.class);

    @Override
    public Object doPre(Object target, Method method, Object[] args)throws Exception {

        Object obj = null ;
        Method[] targetMethods = target.getClass().getMethods();
        Method targetMethod = null ;
        for(Method m : targetMethods){
            if(m.getName().equals(method.getName())){
                targetMethod = m ;
                break ;
            }
        }
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] params = u.getParameterNames(targetMethod);
            //获取注解
            MyCache an = targetMethod.getAnnotation(MyCache.class);
            //log.info("MyCache :"+an);
            EviMyCache ean = targetMethod.getAnnotation(EviMyCache.class);
            //log.info("EviMyCache :"+ean);
            if(an != null){
                String key =an.key();
                String[] afterKeys = transfeKeys(key,params,args);
                String val = an.value();
                obj = cache(target,method ,args,afterKeys ,val);
            }else if(ean != null){
                String key =ean.key();
                String[] afterKeys = transfeKeys(key,params,args);
                String val = ean.value();
                obj = eviCache(target,method ,args,afterKeys ,val);
            }

            return obj ;
    }

    @Override
    public Object doafter(Object target, Method method, Object[] args) {
        return null ;
    }

    @Override
    public Object process(Object target, Method method, Object[] args) throws Exception {

        Object obj = this.doPre(target, method ,args);
        return obj;
    }

    /**
     * 缓存
     * @param target
     * @param method
     * @param args
     * @return
     * @throws Exception
     */
    private Object cache(Object target, Method method, Object[] args ,String[] keys ,String val)throws Exception{

        StringBuffer key = buildKeys(method,args,keys,val);
        log.info("key is :"+key);
        //先从缓存里取
        Object obj = cache.get(key.toString());
        //取到了直接返回
        if(obj != null){
            log.info("缓存命中，返回从缓存中取得的结果");
            return obj ;
        }
        //取不到则调目标的方法去取
        try{
            obj = method.invoke(target ,args) ;
        }catch(Exception e){
            throw e ;
        }
        //目标方法返回的结果为空，那么不玩了，直接返回
        if(obj == null){
            return null ;
        }
        //目标方法有返回结果，先将其缓存，再返回
        log.info("缓存未命中，将结果保存到缓存中");
        cache.put(key.toString() ,obj );
        return obj ;
    }

    /**
     * 缓存失效
     * @param target
     * @param method
     * @param args
     * @throws Exception
     */
    private Object eviCache(Object target, Method method, Object[] args,String[] keys ,String val)throws Exception{
        StringBuffer key =buildKeys(method,args,keys,val);
        log.info("key is :"+key);
        //缓存失效
        cache.remove(key.toString());
        log.info("缓存失效");
        Object obj = null ;
        try{
            obj = method.invoke(target ,args) ;
        }catch(Exception e){
            throw e ;
        }

        return obj ;

    }

    private StringBuffer buildKeys( Method method, Object[] args,String[] keys ,String val){
        StringBuffer key =new StringBuffer(val);
        if(keys == null){
            //先组装key:methodName+arg1+arg2+...argn(默认所有入参作为key)
            key.append(method.getName());
            for(Object arg: args){
                key.append(arg);
            }
        }else{
            for(Object arg: keys){
                key.append(arg);
            }
        }
        return key ;
    }

    /**
     *
     * @param key
     * @param params
     * @param args
     * @return
     */
    private String[] transfeKeys(String key ,String[] params , Object[] args){
        String[] keys = null ;
        String[] afterKeys = null;
        //没有设置key,则用默认的
        if(key!=null && key != ""){
                key = key.replace("{", "");
                key = key.replace("}", "");
                keys = key.split(",");
                afterKeys = new String[keys.length] ;
                for(int i=0 ; i<keys.length ; i++){
                    if(!keys[i].startsWith("#")){
                        afterKeys[i] = keys[i];
                        continue;
                    }
                    for(int j = 0; j < params.length ; j++){
                        String k = keys[i].substring(1);
                        if(params[j].equals(k)){
                            afterKeys[i] =  args[j].toString();
                            break ;
                        }
                    }
                }
        }
        return afterKeys ;
    }
}
