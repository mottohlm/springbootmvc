package com.learn.templatepattern;

public class Dota2 extends Game {

    @Override
    void init() {
        System.out.println("Dota2 初始化");
    }

    @Override
    void start() {
        System.out.println("Dota2 游戏开始");
    }

    @Override
    void end() {
        System.out.println("Dota2 游戏结束");
    }
}
