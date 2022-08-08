package com.zfg.testListNode;

import java.util.Scanner;

/**
 * @ClassName StrHuiWen
 * @Description 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 回文是指正着和倒着一样的字符串
 * @Author zfg
 * @Date 2022/8/7 下午 04:50
 */
public class StrHuiWen {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String str = sc.nextLine();
            System.out.println(longestPalindrome(str));

        }

    }

    public static String longestPalindrome(String s) {

        //字符串为空的情况
        if (s == null || s.length() == 0) {
            return "";
        }
        //保存起始位置
        int[] range = new int[2];
        //转化为字符数组便于操作
        char[] str = s.toCharArray();
        //把回文看成中间的部分全是同一字符，左右部分相对称
        for (int i = 0; i < s.length(); i++) {
            //找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        //查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        //定位中间部分的最后一个字符
        int ans = high;
        //从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        //记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;

    }

    public static int findLongest1(char[] str, int low, int[] range) {

        //定位中间部分
        int high = low;
        //当回文串是偶数时中间的部分为相同的字符，定位到最后一个相同的字符下标
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        //定位中间部分的最后一个字符
        int ans = high;
        //由中间字符向两边延伸判断对不对称
        while (low > 0 && high < str.length - 1 && str[high + 1] == str[low - 1]) {
            low--;
            high++;
        }
        //记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;

    }

}
