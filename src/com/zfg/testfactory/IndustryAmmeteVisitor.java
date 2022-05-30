package com.zfg.testfactory;

/**
 * @ClassName IndustryAmmeteVisitor
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/18 下午 01:15
 */
public class IndustryAmmeteVisitor implements Visitor{
    @Override
    public double visit(AmmeterElement element) {

        double charge = 0;
        double unitOne = 1.52,unitTwo = 2.78;
        int basic = 15000;
        double n = element.showElectricAmount();
        if(n<=basic){
            charge = n*unitOne;
        }else {
            charge = basic*unitOne+(n-basic)*unitTwo;
        }

        return charge;
    }
}
