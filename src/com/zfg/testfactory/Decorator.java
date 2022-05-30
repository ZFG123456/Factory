package com.zfg.testfactory;

/**
 * @ClassName Decorator
 * @Description 装饰者
 * @Author zfg
 * @Date 2022/4/18 下午 04:21
 */
public abstract class Decorator extends Bird{

    Bird bird;

    public Decorator() {

    }

    public Decorator(Bird bird) {
        this.bird = bird;
    }

    //用于装饰fly方法，行为具体由具体装饰者实现
    public abstract int eleFly();

}
