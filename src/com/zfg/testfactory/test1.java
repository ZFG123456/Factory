package com.zfg.testfactory;

/**
 * @ClassName test1
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/18 下午 01:21
 */
public class test1 {

    public static void main(String[] args) {

        //按家用电费计算的记表员
        Visitor vt = new HomeAmmeterVisitor();
        //电表
        Ammeter at = new Ammeter();
        at.setElectricAmount(5678);
        at.accept(vt);
        //按工业电费计算的记表员
        vt = new IndustryAmmeteVisitor();
        at.setElectricAmount(5678);
        at.accept(vt);

    }

}
