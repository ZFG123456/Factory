package com.zfg.testfactory;

/**
 * @Interface Avg
 * @Description 利用策略模式计算成绩的平均值
 * @Author zfg
 * @Date 2022/4/18 上午 11:21
 */
public interface Avg {

    //计算平均成绩的策略模式接口
    public double avgInterface(double[] num);

}
