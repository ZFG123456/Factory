package com.zfg.testfactory;

import com.zfg.testfactory.AlternateCurrent;
import com.zfg.testfactory.DitectCurrent;
import com.zfg.testfactory.ElectricAdapter;
import com.zfg.testfactory.PowerCompany;

/**
 * @ClassName com.zfg.testfactory.test3
 * @Description 适配器测试
 * @Author zfg
 * @Date 2022/4/18 下午 04:53
 */
public class test3 {

    public static void main(String[] args) {
        //交流电
        AlternateCurrent aEectric = new PowerCompany();
        System.out.println("洗衣机使用交流电:"+aEectric.giveAlternateCurrent());
        //对交流电进行适配得到直流电
        DitectCurrent dElectric = new ElectricAdapter(aEectric);
        System.out.println("录音机使用直流电:"+dElectric.giveDirectCurrent());
    }

}
