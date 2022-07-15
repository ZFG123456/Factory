package com.zfg.testStudy;

/**
 * @ClassName CarA
 * @Description 汽车A的制作
 * @Author zfg
 * @Date 2022/7/15 下午 03:58
 */
public class CarA implements Car{

    @Override
    public void drive() {
        System.out.println("carA正在行驶!");
    }

}
