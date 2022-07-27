package com.zfg.testListNode;

import java.util.Scanner;

/**
 * @ClassName StrSub
 * @Description 输入一个字符串和一个整数 k ，截取字符串的前k个字符并输出
 * <p>
 * 数据范围：字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ， 1 \le k \le n \1≤k≤n
 * @Author zfg
 * @Date 2022/7/27 下午 04:49
 */
public class StrSub {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            int num = sc.nextInt();
            String resStr = str.substring(0, num);
            System.out.println(resStr);
        }

    }

}
