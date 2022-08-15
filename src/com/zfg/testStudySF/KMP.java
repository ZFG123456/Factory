package com.zfg.testStudySF;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName KMP
 * @Description KMP算法实现模式串匹配
 * @Author zfg
 * @Date 2022/8/13 下午 02:58
 */
public class KMP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int index = kmpSearch(str1, str2, getMatch(str2));
            System.out.println(index);
        }
//        System.out.println(Arrays.toString(getMatch("ABCDABD")));
    }

    //获取子串的部分匹配表
    public static int[] getMatch(String str) {
        int[] next = new int[str.length()];
        //如果子串长度为1,,则部分匹配值是0
        next[0] = 0;
        for (int i = 1, j = 0; i < str.length(); i++) {

            //kmp算法的核心
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j - 1];
            }

            //满足两个字符相等,部分匹配值+1
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    //kmp算法
    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {

            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }

        }
        return -1;
    }

}
