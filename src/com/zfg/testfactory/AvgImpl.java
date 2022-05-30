package com.zfg.testfactory;

/**
 * @ClassName AvgImpl
 * @Description 相当于策略模式的上下文
 * @Author zfg
 * @Date 2022/4/18 上午 11:24
 */
public class AvgImpl {

    Avg a;

    //get方法用来获得接口的方法
    public double getA(double[] num) {
        if(a!=null){
            return a.avgInterface(num);
        }else {
            return -1;
        }
    }

    //set方法用来设置接口的实例
    public void setA(Avg a) {
        this.a = a;
    }
}
