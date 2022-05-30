package com.zfg.testfactory;

/**
 * @ClassName PenCore
 * @Description 利用工厂模式实现用户不同颜色的圆珠笔笔芯
 * @Author zfg
 * @Date 2022/4/19 上午 10:36
 */
public abstract class PenCore {
    String color;
    public abstract void writeWord(String s);
}
