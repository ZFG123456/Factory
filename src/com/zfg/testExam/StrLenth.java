package com.zfg.testExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName StrLenth
 * @Description 非严格递增序列
 * @Author zfg
 * @Date 2022/7/31 下午 01:03
 */
public class StrLenth {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine();
            //提取字符串中数字数组
            int[] numbers = StrToNum(str);
            //对字符串非严格递增序列进行长度输出
            int m = maxLenth(numbers);
            System.out.println(m);

        }

    }

    //字符串非严格递增序列长度
    public static int maxLenth(int[] numbers) {
        if (numbers == null) {
            return 0;
        }
        if (numbers.length == 0 || numbers.length == 1) {
            return numbers.length;
        }

        int[] a = new int[numbers.length];
        int maxLenth = 0;
        for (int i = 0; i < numbers.length; i++) {
            //无重复数字的插入
            int temp = find(a, maxLenth, numbers[i]);
            //有重复数字的插入
            int temp1 = findX(a, temp, numbers[i]);
//            if (temp=temp1==-1){
//                return temp;
//            }else {
//                temp1;
//            }
            //三目运算符
            temp = temp1 == -1 ? temp : temp1;
            a[temp] = numbers[i];
            if (temp == maxLenth) {
                maxLenth++;
            }
        }

        return maxLenth;
    }

    //二分查找法找到插入位置
    public static int find(int[] numbers, int lenth, int a) {
        if (lenth == 0) {
            return 0;
        }
        int low = 0;
        int high = lenth;
        if (a <= numbers[low]) {
            return 0;
        }
        if (a > numbers[lenth - 1]) {
            return lenth;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a > numbers[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    //二分查找法(返回-1时)
    public static int findX(int[] numbers, int lenth, int a) {
        if (lenth >= numbers.length || lenth < 0) {
            return -1;
        }
        if (numbers[lenth] != a) {
            return -1;
        }
        int high = lenth + 1;
        while (high < numbers.length && numbers[high] == numbers[lenth]) {
            high++;
        }
        return high;
    }

    //字符串提取数字到数组中
    public static int[] StrToNum(String str) {
        int[] nums = new int[str.length()];
        int[] numbers = new int[str.length()];
        String reg = "[^0-9]";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        String res = m.replaceAll("").trim();

        for (int i = 0; i < res.length(); i++) {
            nums[i] = res.charAt(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                numbers[i] = nums[i];
            }
        }

        return numbers;
    }


}
