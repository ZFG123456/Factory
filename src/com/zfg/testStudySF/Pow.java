package com.zfg.testStudySF;

/**
 * @ClassName Pow
 * @Description 一个数的n次幂的计算
 * @Author zfg
 * @Date 2022/8/22 下午 06:39
 */
public class Pow {

    public static void main(String[] args) {

        System.out.println(myPow(2, -6));

    }

    public static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

}
