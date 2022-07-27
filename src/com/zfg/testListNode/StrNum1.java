package com.zfg.testListNode;

import java.util.Scanner;


/**
 * @ClassName StrNum1
 * @Description 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 * <p>
 * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 * @Author zfg
 * @Date 2022/7/27 下午 05:41
 */
public class StrNum1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine();
            int english = 0;
            int empty = 0;
            int number = 0;
            int other = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (Character.isLetter(c)) {
                    english++;
                } else if (Character.isDigit(c)) {
                    number++;
                } else if (Character.isSpaceChar(c)) {
                    empty++;
                } else {
                    other++;
                }
            }

            System.out.println(english);
            System.out.println(empty);
            System.out.println(number);
            System.out.println(other);

        }
    }
}
