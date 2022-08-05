package com.zfg.testExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description 分苹果
 * @Author zfg
 * @Date 2022/7/31 下午 02:55
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            List<String> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                list.add(sc.nextInt());
                list1.add(getA1(list.get(i)));
            }

        }


    }

    //转化数字为二进制
    public static String getA1(int n) {

        //转化为二进制
        String res = Integer.toBinaryString(n);
        return res;

    }

    //按照A的方案二进制加法不计算进位
    public static int getA(List<Integer> list) {

        return 0;

    }

}
