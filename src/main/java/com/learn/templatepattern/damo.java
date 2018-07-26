package com.learn.templatepattern;

public class damo {


    public static void main(String[] args){
        Game dota2 = new Dota2();
        Game csgo =  new CSGo();
        dota2.play();
        csgo.play();
    }
}
