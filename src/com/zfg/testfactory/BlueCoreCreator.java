package com.zfg.testfactory;

/**
 * @ClassName BlueCoreCreator
 * @Description 具体产品
 * @Author zfg
 * @Date 2022/4/19 上午 10:47
 */
public class BlueCoreCreator extends CreatorPenCore{
    @Override
    public PenCore getPenCore() {
        return new BluePenCore();
    }
}
