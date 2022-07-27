package com.zfg.testListNode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName StrNum
 * @Description 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
 * @Author zfg
 * @Date 2022/7/27 下午 04:30
 */
public class StrNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine();
            Set<String> string = new HashSet<>();
            String[] strs = str.split("");

            for (int i = 0; i < strs.length; i++) {
                string.add(strs[i]);
            }

            System.out.println(string.size());

        }
    }

}
