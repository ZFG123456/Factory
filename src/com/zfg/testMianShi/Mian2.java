package com.zfg.testMianShi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Mian2
 * @Description 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * <p>
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * @Author zfg
 * @Date 2022/8/26 下午 02:53
 */
public class Mian2 {

    public static void main(String[] args) {

        String str1 = "bank";
        String str2 = "kanb";
        System.out.println(areAlmostEqual(str1, str2));

    }

    public static boolean areAlmostEqual(String s1, String s2) {

        int i = 0;
        int count = 0;
        HashMap<Character, Character> dict = new HashMap<>();
        while (i < s1.length()) {
            if (count > 2) {
                return false;
            }
            if (s1.charAt(i) != s2.charAt(i)) {
                if (dict.containsKey(s2.charAt(i)) && s1.charAt(i) == dict.get(s2.charAt(i))) {
                    dict.remove(s2.charAt(i));
                } else {
                    dict.put(s1.charAt(i), s2.charAt(i));
                }
                count++;
            }
            i++;
        }

        if (dict.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
