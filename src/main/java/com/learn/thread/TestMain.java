package com.learn.thread;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestMain {

    public static void main(String[] args ){
        //domain
        try {
            doForEach();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void doForEach() throws  InterruptedException{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = sdf.format(new Date(System.currentTimeMillis()));
        System.out.println("start time is :"+startDate);
        String[] gifts = {"apple","orange","cat","dog","tomato","monkey","birds","fish","milk","pen"};
        Map<String,String> resultMap = new HashMap<String,String>();
        resultMap.put("1","happy");
        resultMap.put("2","so so");
        resultMap.put("3","wanting others");
        resultMap.put("4","too nice");
        Random r = new Random();
        Map<String , String> family = new HashMap<>();
        //将10个礼物依次发出去，并收集感受
        for(String gift : gifts){

            int code = r.nextInt(100)+1;
            code = code%5;
            String result = resultMap.get(code+"") ;
            family.put(gift,result) ;
            //一个循环设置花2秒
            Thread.sleep(2000);

        }
        String endDate = sdf.format(new Date(System.currentTimeMillis()));
        System.out.println("end time is :"+endDate);
        System.out.println(handleResult(family));
    }

    private  static String handleResult(Map<String ,String> resultMap){

        Iterator it = resultMap.entrySet().iterator();
        StringBuffer sb = new StringBuffer();
        while(it.hasNext()){
             Map.Entry<String,String> entry =  (Map.Entry<String,String>) it.next();
             String key = entry.getKey();
             String val = entry.getValue();
            sb.append("the family who get the :"+key +" is think "+val +" ;");
        }

        return sb.toString().substring(0,sb.length()-1) ;
    }

}
