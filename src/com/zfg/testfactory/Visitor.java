package com.zfg.testfactory;

/**
 * @Interface Visitor
 * @Description 访问者模式实现电表费用计算
 * @Author zfg
 * @Date 2022/4/18 下午 01:04
 */
public interface Visitor {

    public double visit(AmmeterElement element);

}
