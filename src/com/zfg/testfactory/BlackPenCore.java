package com.zfg.testfactory;

/**
 * @ClassName BlackPenCore
 * @Description 具体产品
 * @Author zfg
 * @Date 2022/4/19 上午 10:43
 */
public class BlackPenCore extends PenCore{
    public BlackPenCore() {
        color = "黑色";
    }

    @Override
    public void writeWord(String s) {
        System.out.println("写出"+color+"的字:"+s);
    }
}
