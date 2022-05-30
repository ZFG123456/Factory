package com.zfg.testfactory;

/**
 * @ClassName Avg1
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/18 上午 11:30
 */
public class Avg1 implements Avg{
    @Override
    public double avgInterface(double[] num) {

        double sum = 0;
        double score = 0;

        for(int i=0;i<num.length;i++){
            sum += num[i];
        }
        score = sum/ num.length;

        return score;
    }
}
