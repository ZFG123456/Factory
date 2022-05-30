package com.zfg.testInterface;

/**
 * @ClassName StrCar1
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/23 上午 11:07
 */
public class StrCar1 extends StrCar{
    @Override
    public String getStr(String str) {
        return str;
    }

    @Override
    public String getStr1(String str1) {
        return str1;
    }

    @Override
    public int getInterger() {
        return super.getInterger();
    }
}
