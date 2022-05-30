package com.zfg.testfactory;

/**
 * @ClassName BluePenCore
 * @Description 具体产品
 * @Author zfg
 * @Date 2022/4/19 上午 10:42
 */
public class BluePenCore extends PenCore{
    public BluePenCore() {
        color = "蓝色";
    }

    @Override
    public void writeWord(String s) {
        System.out.println("写出"+color+"的字:"+s);
    }
}
