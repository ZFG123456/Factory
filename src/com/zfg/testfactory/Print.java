package com.zfg.testfactory;

/**
 * @ClassName Print
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/18 上午 11:37
 */
public class Print {

    public static void main(String[] args) {
        AvgImpl a1 = new AvgImpl();
        a1.setA(new Avg1());
        System.out.println("张三");
        double[] num = {9,12,9,25,8,87,9,99,6,99,7,88};
        double pr1 = a1.getA(num);
        System.out.println(pr1);

        a1.setA(new Avg2());
        System.out.println("李四");
        double pr2 = a1.getA(num);
        System.out.println(pr2);

    }


}
