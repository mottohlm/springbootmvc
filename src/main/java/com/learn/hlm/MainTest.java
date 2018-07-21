package com.learn.hlm;

import com.learn.hlm.bo.AopBo;
import com.learn.hlm.service.AopService;
import com.learn.hlm.service.impl.AopServiceImpl;

import java.util.List;

public class MainTest {


    private static AopService aopService ;

    public static void main(String[] args){
        aopService = new AopServiceImpl();
        testGet(1);
        testGet(2);
        testGet(3);
        testGet(4);

        testFind("bo","");
        testFind(null,"男");
    }

    public  static void testGet(Integer i){

        if(i == null){
            i = new Integer(1);
        }
        AopBo bo = aopService.getAopBoById( i );
        alert(bo.toString());
    }


    public static void testFind(String name, String sex){

        List<AopBo> list =  aopService.findAopBo(name , sex);
        if(list == null || list.size() < 1) return ;
        System.out.println("----------以下为数组内空-----------");
        for(AopBo bo : list){
            alert(bo.toString()) ;
        }
        System.out.println("----------end-----------");
    }

    public static void alert( String str ){
        System.out.println(str);
    }
}
