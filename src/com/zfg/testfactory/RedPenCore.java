package com.zfg.testfactory;

/**
 * @ClassName RedPenCore
 * @Description 具体产品
 * @Author zfg
 * @Date 2022/4/19 上午 10:39
 */
public class RedPenCore extends PenCore{

    public RedPenCore() {
        color = "红色";
    }

    @Override
    public void writeWord(String s) {
        System.out.println("写出"+color+"的字:"+s);
    }
}
