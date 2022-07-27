package com.zfg.testListNode;

import java.util.Scanner;

/**
 * @ClassName StrRev
 * @Description 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * @Author zfg
 * @Date 2022/7/27 下午 04:06
 */
public class StrRev {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine().toLowerCase();
            StringBuffer sb = new StringBuffer();
            for (int i = str.length(); i > 0; i--) {
                sb.append(str.charAt(i - 1));
            }
            String string = sb.toString();
            System.out.println(string);
        }

        //利用本身的翻转方法
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        System.out.println(StrRev.strRevv(str));

    }

    /***
     * @Description: //利用本身的翻转方法
     * @MethodName: strRevv
     * @Param: [str]
     * @return: java.lang.String
     * @Author: zfg
     * @Date: 2022/7/27 下午 04:26
     */
    public static String strRevv(String str) {
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        return sb.toString();
    }


}
