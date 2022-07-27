package com.zfg.testListNode;

import java.util.Scanner;

/**
 * @ClassName StrIndex
 * @Description 找出字符串中第一个只出现一次的字符
 * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 * 输入：
 * asdfasdfo
 * <p>
 * 输出：
 * o
 * @Author zfg
 * @Date 2022/7/27 下午 05:14
 */
public class StrIndex {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine();
            boolean flag = false;
            for (int i = 0; i < str.length(); i++) {
                if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                    System.out.println(str.charAt(i));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println(-1);
            }

        }

    }

}
