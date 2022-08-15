package com.zfg.testStudySF;

/**
 * @ClassName MGraph
 * @Description 图的数据结构（普利姆算法用到）
 * @Author zfg
 * @Date 2022/8/14 下午 03:06
 */
public class MGraph {

    //表示图结点的个数
    int verxs;
    //表示图结点集合
    char[] data;
    //表示边的邻接矩阵
    int[][] weight;

    //初始化图
    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
