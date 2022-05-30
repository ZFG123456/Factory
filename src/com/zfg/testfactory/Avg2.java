package com.zfg.testfactory;

import java.util.Arrays;

/**
 * @ClassName Avg2
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/18 上午 11:33
 */
public class Avg2 implements Avg{
    @Override
    public double avgInterface(double[] num) {

        double sum = 0;
        double score = 0;
        if(num.length<=2){
            return 0;
        }else{
            Arrays.sort(num);
            for(int i=1;i<num.length-1;i++){
                sum += num[i];
            }
            score = sum/ num.length;
            return score;
        }

    }
}
