package com.zfg.testListNode;

import java.util.Scanner;

/**
 * @ClassName StrMatch
 * @Description 字符串模式匹配
 * @Author zfg
 * @Date 2022/8/10 下午 06:41
 */
public class StrMatch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine();
            char[] s1 = str.toCharArray();
            String str1 = sc.nextLine();
            char[] s2 = str1.toCharArray();
            System.out.println(getMatchStr(s1, s2));
            System.out.println(getMatchStr(str, str1));

        }

    }

    //暴力法求解
    public static int getMatchStr(String s1, String s2) {

        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                while (i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                    //字符串挨个匹配
                    i++;
                    //模式字符串挨个匹配
                    j++;
                    //记录当前匹配的模式字符串的字符的个数
                    res++;
                    //当第一次匹配到模式子串的时候就停止循环并返回字符串下标匹配的开始位置
                    if (res == s2.length()) {
                        return i - s2.length();
                    }
                }
                if (i < s1.length() && j < s2.length() && s1.charAt(i) != s2.charAt(j)) {
                    //当首次遇到不匹配的字符时i回溯到字符串当前的下一个位置
                    i = i - j + 1;
//                    i=0;
//                    i++;
                    //j回溯到模式串开始的位置
                    j = -1;
                }
                res = 0;
            }
            //返回结果
            //没匹配到的结果输出
            if (res == 0 && i == s1.length()) {
                return -1;
            }
            res = i - s2.length();
            if (res < 0) {
                return -1;
            }
        }

        return res;

    }

    //暴力解法优化
    public static int getMatchStr(char[] s1, char[] s2) {

        int i = 0;
        int j = 0;

        while (i < s1.length && j < s2.length) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == s2.length) {
            return i - j;
        } else {
            return -1;
        }
    }

}
