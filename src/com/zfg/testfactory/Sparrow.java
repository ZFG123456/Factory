package com.zfg.testfactory;

/**
 * @ClassName Sparrow
 * @Description 被装饰者
 * @Author zfg
 * @Date 2022/4/18 下午 04:18
 */
public class Sparrow extends Bird{

    public final int DISTANCE = 100;

    @Override
    public int fly() {
        return DISTANCE;
    }
}
