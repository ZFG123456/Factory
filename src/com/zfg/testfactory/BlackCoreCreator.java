package com.zfg.testfactory;

/**
 * @ClassName BlackCoreCreator
 * @Description 具体产品
 * @Author zfg
 * @Date 2022/4/19 上午 10:48
 */
public class BlackCoreCreator extends CreatorPenCore{
    @Override
    public PenCore getPenCore() {
        return new BlackPenCore();
    }
}
