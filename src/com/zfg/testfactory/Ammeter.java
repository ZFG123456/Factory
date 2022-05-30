package com.zfg.testfactory;

/**
 * @ClassName Ammeter
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/18 下午 01:17
 */
public class Ammeter extends AmmeterElement{

    //电表电量
    double electricAmount;

    @Override
    public void accept(Visitor y) {
        //让访问者访问当前元素
        double feiyong = y.visit(this);
        System.out.println("当前电表用户需要缴纳电费:"+feiyong+"元");
    }

    @Override
    public double showElectricAmount() {
        return electricAmount;
    }

    @Override
    public void setElectricAmount(double n) {
        electricAmount = n;
    }
}
