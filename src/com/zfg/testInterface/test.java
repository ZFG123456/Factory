package com.zfg.testInterface;

/**
 * @ClassName test
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/23 上午 10:32
 */
public class test {

    public static void main(String[] args) {

        Car c = new StrCar1();
        System.out.println(c.getStr(Car.str));
        System.out.println(((StrCar1) c).getInterger());

//        Car car = new StrCar() {
//            @Override
//            public int getInterger() {
//                return super.getInterger();
//            }
//
//            @Override
//            public String getStr(String str) {
//                return super.getStr(str);
//            }
//
//            @Override
//            public String getStr1(String str1) {
//                return super.getStr1(str1);
//            }
//        };

//        String x = car.getStr(Car.str);
//        System.out.println(x);

    }

}
