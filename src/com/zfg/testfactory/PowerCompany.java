package com.zfg.testfactory;

/**
 * @ClassName PowerCompany
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/18 下午 04:55
 */
public class PowerCompany implements AlternateCurrent{

    public final String JLD="1010101010101010";

    @Override
    public String giveAlternateCurrent() {
        return JLD;
    }
}
