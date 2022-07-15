package com.zfg.testStudy;

/**
 * @ClassName CarEasyFactory
 * @Description 简单汽车工厂类
 * @Author zfg
 * @Date 2022/7/15 下午 04:00
 */
public class CarEasyFactory {

    public Car getCarA(){
        return new CarA();
    }

    public Car getCarB(){
        return new CarB();
    }


}
