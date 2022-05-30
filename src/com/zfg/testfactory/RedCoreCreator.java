package com.zfg.testfactory;

/**
 * @ClassName RedCoreCreator
 * @Description 具体构造者
 * @Author zfg
 * @Date 2022/4/19 上午 10:45
 */
public class RedCoreCreator extends CreatorPenCore{
    @Override
    public PenCore getPenCore() {
        return new RedPenCore();
    }
}
