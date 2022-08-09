package com.zfg.testMianShi;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description 题目描述
 * 从前有一个叫做”H湖”的地方,”H湖”的居民生活在不同的小岛上,当他们想去其他的小岛时都要通过划小船或者小岛之间的桥来实现.现在政府想实现”H湖”的全畅通!(不一定有直接的桥相连，只要互相间接通过桥可达即可).”H湖”已经造出了一些桥出来连接某两个岛.问最少还需要建设几座桥?
 * <p>
 * 解答要求
 * 时间限制：2000ms, 内存限制：100MB
 * 输入
 * 每个输入文件包含一组数据,每组数据首先是两个整数N(1 <= N <= 1000)和M(1 <= M <= 100000),代表小岛的个数以及已经建设好的桥数目,接下来M行对应M座桥,每行给定一对正整数,分别是该座桥连通的两个岛的编号.为简单起见,岛从1到N编号.
 * 注意:两个岛之间可以有多座桥相通,也就是说
 * 3 3
 * 1 2
 * 1 2
 * 2 1
 * 这种输入也是合法的
 * <p>
 * 输出
 * 每组输入数据输出一行,代表最少还需要建设的桥的数目.
 * <p>
 * 样例
 * 输入样例 1 复制
 * <p>
 * 5 2
 * 1 2
 * 3 5
 * 输出样例 1
 * <p>
 * 2
 * @Author zfg
 * @Date 2022/8/8 下午 06:54
 */
public class Main {

    static int[] father = new int[1000];
    static int res = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            //一开始需要n-1条线连接
            res = n - 1;
            for (int i = 1; i <= n; i++) {
                father[i] = i;
            }
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                join(x, y);
            }
            System.out.println(res);
        }
    }

    public static int find(int x) {
        int r = x;
        while (father[r] != r) {
            r = father[r];
        }
        return r;
    }

    //并查集(如果两座岛都连接了,相当于减少一条线)
    public static void join(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
            res--;
        }
    }

}
