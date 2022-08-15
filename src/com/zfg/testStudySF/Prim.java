package com.zfg.testStudySF;

/**
 * @ClassName Prim
 * @Description 普里姆算法解决修路问题（最小生成树和极小连通图）
 * @Author zfg
 * @Date 2022/8/14 下午 03:03
 */
public class Prim {

    public static void main(String[] args) {

        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //10000表示两个点不连通
        int[][] weight = {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.creatGraph(graph, verxs, data, weight);
        minTree.showGraph(graph);
        minTree.prim(graph, 0);

    }

}
