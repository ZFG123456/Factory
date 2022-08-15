package com.zfg.testStudySF;

import java.util.Scanner;

/**
 * @ClassName DynicGuiHua
 * @Description 动态规划解决背包问题
 * @Author zfg
 * @Date 2022/8/13 下午 01:12
 */
public class DynicGuiHua {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入背包的容量:");
        while (sc.hasNext()) {
            int m = sc.nextInt();
            System.out.println("请输入物品的数量:");
            int n = sc.nextInt();
            System.out.println("请输入物品的重量:");
            int[] w = new int[n];
            for (int i = 0; i < w.length; i++) {
                w[i] = sc.nextInt();
            }
            System.out.println("请输入物品的价值:");
            int[] val = new int[n];
            for (int i = 0; i < val.length; i++) {
                val[i] = sc.nextInt();
            }

            //动态规划求不超过背包最大容量的最大价值
            //创建二维数组v[i][j]标识前i个物品中能够装入容量为j的背包的最大价值
            int[][] v = new int[n + 1][m + 1];
            //记录放入的物品
            int[][] path = new int[n + 1][m + 1];
            //初始化第一行第一列
            for (int i = 0; i < v.length; i++) {
                v[i][0] = 0;
            }
            for (int i = 0; i < v[0].length; i++) {
                v[0][i] = 0;
            }
            //动态规划寻找最优
            for (int i = 1; i < v.length; i++) {
                for (int j = 1; j < v[0].length; j++) {
                    if (w[i - 1] > j) {
                        v[i][j] = v[i - 1][j];
                    } else {
//                        v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                        if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                            v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                            path[i][j] = 1;
                        } else {
                            v[i][j] = v[i - 1][j];
                        }
                    }
                }
            }

            //输出v
            printV(v);
            //输出path
            printPath(path, w);
        }
    }

    //输出v
    public static void printV(int[][] v) {
        for (int[] data : v) {
            for (int value : data) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    //输出path
    public static void printPath(int[][] path, int[] w) {
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("第" + i + "个物品放入背包!");
                j -= w[i - 1];
            }
            i--;
        }
    }

}
