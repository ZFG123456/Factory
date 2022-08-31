package com.zfg.testStudySF;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FianllyStr
 * @Description 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * @Author zfg
 * @Date 2022/8/31 上午 09:46
 */
public class FianllyStr {

    public static void main(String[] args) {
        String s = "fly me to the moon  ";
        System.out.println(lengthOfLastWord(s));

    }

    public static int lengthOfLastWord(String s) {

        List<Character> list = new ArrayList<>();

        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }

        for (int i = index; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else {
                list.add(s.charAt(i));
            }
        }

        return list.size();

    }

    public static int lengthOfLastWord1(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}
