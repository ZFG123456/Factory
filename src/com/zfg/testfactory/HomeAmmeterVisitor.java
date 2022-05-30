package com.zfg.testfactory;

/**
 * @ClassName HomeAmmeterVisitor
 * @Description 具体访问者
 * @Author zfg
 * @Date 2022/4/18 下午 01:09
 */
public class HomeAmmeterVisitor implements Visitor{
    @Override
    public double visit(AmmeterElement element) {
        double charge = 0;
        double unitOne = 0,unitTwo = 1.05;
        int basic = 6000;
        double n = element.showElectricAmount();
        if(n<=basic){
            charge = n*unitOne;
        }else {
            charge = basic*unitOne+(n-basic)*unitTwo;
        }

        return charge;
    }
}
