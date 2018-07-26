package com.learn.templatepattern;

public class CSGo extends Game {
    @Override
    void init() {
        System.out.println("CSGO 初始化");
    }

    @Override
    void start() {
        System.out.println("CSGO 游戏开始");
    }

    @Override
    void end() {
        System.out.println("CSGO 游戏结束");
    }
}
