package com.zfg.testStudySF;

import java.util.Arrays;

/**
 * @ClassName MinTree
 * @Description 创建最小生成树->村庄图（普利姆算法用到）
 * @Author zfg
 * @Date 2022/8/14 下午 03:13
 */
public class MinTree {

    public void creatGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i;
        int j;
        //初始化图
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图
    public void showGraph(MGraph graph) {
        for (int[] value : graph.weight) {
            System.out.println(Arrays.toString(value));
        }
    }

    //prim算法，得到最小生成树
    //v表示任意一个结点为起始点
    public void prim(MGraph graph, int v) {
        //表示结点访问的数组
        int[] visited = new int[graph.verxs];
        //将当前结点标识为已访问
        visited[v] = 1;
        //h1和h2记录两个节点的下标
        int h1 = -1;
        int h2 = -1;
        //设置一个较大的数，小于这个数就会被替换
        int minWeight = 10000;
        //共有n-1条边,确定每一次生成子图和哪一个结点距离最近
        //输出多个结点的最小生成图
        for (int i = 1; i < graph.verxs; i++) {
            //j标识已经访问的结点
            for (int j = 0; j < graph.verxs; j++) {
                //i标识未访问的结点
                for (int k = 0; k < graph.verxs; k++) {
                    if (visited[j] == 1 && visited[k] == 0 && graph.weight[j][k] < minWeight) {
                        minWeight = graph.weight[j][k];
                        h1 = j;
                        h2 = k;
                    }
                }
            }
            //输出一个最小生成子图的边和权值
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + ">,权值-->" + graph.weight[h1][h2]);
            //将未访问的结点设置为已经访问
            visited[h2] = 1;
            //将minWeight重置为初始值
            minWeight = 10000;
        }
    }

}
