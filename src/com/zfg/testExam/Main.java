package com.zfg.testExam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description 矩阵最大位置M相连的数量
 * @Author zfg
 * @Date 2022/7/31 下午 02:29
 */
public class Main {

    static int row;
    static int col;
    static String[][] str;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String[] str1 = sc.nextLine().split(",");
            //得到行和列
            row = Integer.valueOf(str1[0]);
            col = Integer.valueOf(str1[1]);

            //初始化二维数组
            str = new String[row][col];

            //将矩阵元素转化为二维数组
            for (int i = 0; i < row; i++) {
                String[] rowStr = sc.nextLine().split(",");
                for (int j = 0; j < col; j++) {
                    str[i][j] = rowStr[j];
                }
            }

            //返回结果
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (str[i][j].equals("M")) {
                        getResult(i, j);
                    }
                }
            }
            //升序，取最后的一个(Max)
            Collections.sort(list);
            System.out.println(list.get(list.size() - 1));

        }
    }

    //具体的计算方法
    public static void getResult(int x, int y) {
        int n = 1;
        int a = 0;
        int b = 0;
        //水平向右
        if (y < col) {
            a = x;
            b = y;
            while (b < col - 1 && str[a][++b].equals("M")) {
                n++;
            }
            list.add(n);
            n = 1;
        }
        //垂直向下
        if (x < row) {
            a = x;
            b = y;
            while (a < row - 1 && str[++a][b].equals("M")) {
                n++;
            }
            list.add(n);
            n = 1;
        }
        //对角线
        if (x < row && y < col) {
            a = x;
            b = y;
            while ((a < row - 1 && b < col - 1) && str[++a][++b].equals("M")) {
                n++;
            }
            list.add(n);
            n = 1;
        }
        //反对角线
        if (x >= 0 && y < col) {
            a = x;
            b = y;
            while ((a > 0 && b < col - 1) && str[--a][++b].equals("M")) {
                n++;
            }
            list.add(n);
        }


    }

}
