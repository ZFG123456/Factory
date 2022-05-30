package com.zfg.testfactory;

/**
 * @ClassName SparrowDecorator
 * @Description 具体装饰者
 * @Author zfg
 * @Date 2022/4/18 下午 04:24
 */
public class SparrowDecorator extends Decorator{

    public final int DISTANCE = 50;

    public SparrowDecorator(Bird bird) {
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
