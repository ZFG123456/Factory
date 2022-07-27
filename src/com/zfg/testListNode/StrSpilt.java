package com.zfg.testListNode;

import java.util.Scanner;

/**
 * @ClassName StrSpilt
 * @Description 字符串分割:输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * @Author zfg
 * @Date 2022/7/27 下午 03:12
 */
public class StrSpilt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            StringBuffer sb = new StringBuffer(str);
            int len = str.length();
            int addZero = 8 - len % 8;
            while (addZero > 0 && addZero < 8) {
                sb.append("0");
                addZero--;
            }

            String string = sb.toString();
            while (string.length() > 0) {
                System.out.println(string.substring(0, 8));
                string = string.substring(8);
            }

        }

    }

}
