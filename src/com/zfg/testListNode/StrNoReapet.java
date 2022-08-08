package com.zfg.testListNode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName StrNoReapet
 * @Description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * @Author zfg
 * @Date 2022/8/6 上午 11:03
 */
public class StrNoReapet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine();
            int res = getNoReapet(str);
            System.out.println(res);

        }

    }

    //滑动窗口法
    public static int getNoReapet(String str) {

        //哈希集合记录每个字符是不是出现过
        Set<Character> set = new HashSet<>();
        int n = str.length();
        //右指针初始值为-1，相当于还没开始移动
        int rk = -1;
        //最大长度记录
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                //左指针向右移动一格，移除一个字符
                set.remove(str.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(str.charAt(rk + 1))) {
                //不断移动右指针
                set.add(str.charAt(rk + 1));
                ++rk;
            }
            //第i到第rk是个不重复的字符串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;

    }

}
