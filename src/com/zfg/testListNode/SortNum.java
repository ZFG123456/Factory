package com.zfg.testListNode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName SortNum
 * @Description 输入n个整数，找出其中最小的k个整数并按升序输出
 * <p>
 * 本题有多组输入样例
 * <p>
 * 数据范围：1 \le n \le 1000 \1≤n≤1000  ，输入的整数满足 1 \le val \le 10000 \1≤val≤10000
 * <p>
 * 输入描述：
 * 第一行输入两个整数n和k
 * 第二行输入一个整数数组
 * 输出描述：
 * 从小到大输出最小的k个整数，用空格分开。
 * @Author zfg
 * @Date 2022/7/27 下午 04:58
 */
public class SortNum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int len = sc.nextInt();
            int num = sc.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
            }
            //对数组进行排序处理
            Arrays.sort(arr);
            for (int i = 0; i < num; i++) {
                System.out.print(arr[i] + " ");
            }
        }

    }
}
