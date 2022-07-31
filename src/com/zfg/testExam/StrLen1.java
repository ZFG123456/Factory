package com.zfg.testExam;

import java.util.Scanner;

/**
 * @ClassName StrLen1
 * @Description 非严格递增序列
 * @Author zfg
 * @Date 2022/7/31 下午 02:22
 */
public class StrLen1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine();
            int maxLenth = 0;
            int length = 0;
            char maxChar = '0';
            //返回结果
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                //寻找最长的递增子序列(利用length作中间变量，计算每次找到的递增字符串的长度)
                if (c >= maxChar && c <= '9') {
                    length++;
                    maxChar = c;
                    maxLenth = Math.max(length, maxLenth);
                } else if (c >= '0' && c <= '9') {
                    length = 1;
                    maxChar = c;
                } else {
                    length = 0;
                    maxChar = '0';
                }
            }

            System.out.println(maxLenth);
        }


    }

}
