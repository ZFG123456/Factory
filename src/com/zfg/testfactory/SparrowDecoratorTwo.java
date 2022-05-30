package com.zfg.testfactory;

/**
 * @ClassName SparrowDecoratorTwo
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/18 下午 04:32
 */
public class SparrowDecoratorTwo extends Decorator{

    public final int DISTANCE = 20;

    public SparrowDecoratorTwo(Bird bird) {
        super(bird);
    }

    @Override
    public int fly() {
        int distance = 0;
        distance = bird.fly() + eleFly();
        return distance;
    }

    @Override
    public int eleFly() {
        return DISTANCE;
    }
}
