package com.zfg.testfactory;

/**
 * @ClassName AmmeterElement
 * @Description 抽象元素---互相访问
 * @Author zfg
 * @Date 2022/4/18 下午 01:06
 */
public abstract class AmmeterElement {

    public abstract void accept(Visitor y);
    public abstract double showElectricAmount();
    public abstract void setElectricAmount(double n);

}
