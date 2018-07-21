package com.learn.hlm;

import com.learn.hlm.bo.AopBo;
import com.learn.hlm.service.AopService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/aop")
public class AopController {

    @Autowired
    private AopService aopService;

    @RequestMapping("/test")
    public ResponseEntity test(){

        testGet(1);
        testGet(2);
        testGet(1);
        testGet(2);

        testFind("bo","");
        testFind(null,"男");
        testFind("bo","");
        testFind(null,"男");
        return null ;
    }


    public   void testGet(Integer i){

        if(i == null){
            i = new Integer(1);
        }
        AopBo bo = aopService.getAopBoById( i );
        alert(bo.toString());
    }


    public  void testFind(String name, String sex){

        List<AopBo> list =  aopService.findAopBo(name , sex);
        if(list == null || list.size() < 1) return ;
        System.out.println("----------以下为数组内空-----------");
        for(AopBo bo : list){
            alert(bo.toString()) ;
        }
        System.out.println("----------end-----------");
    }

    public  void alert( String str ){
        System.out.println(str);
    }
}
