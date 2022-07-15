package com.zfg.testStudy;

/**
 * @ClassName TestEasyFactory
 * @Description TODO
 * @Author zfg
 * @Date 2022/7/15 下午 04:02
 */
public class TestEasyFactory {

    public static void main(String[] args) {

        //创建工厂
        CarEasyFactory carEasyFactory = new CarEasyFactory();
        //创建A汽车
        Car carA = carEasyFactory.getCarA();
        //创建汽车B
        Car carB = carEasyFactory.getCarB();
        carA.drive();
        carB.drive();

    }

}
