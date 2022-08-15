package com.zfg.testStudySF;

/**
 * @ClassName Dijkstra
 * @Description 迪杰斯特拉算法
 * @Author zfg
 * @Date 2022/8/15 下午 12:18
 */
public class Dijkstra {

    //标识不连通
    final static int N = 65535;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] martix = new int[vertexs.length][vertexs.length];
        martix[0] = new int[]{N, 5, 7, N, N, N, 2};
        martix[1] = new int[]{5, N, N, 9, N, N, 3};
        martix[2] = new int[]{7, N, N, N, 8, N, N};
        martix[3] = new int[]{N, 9, N, N, N, 4, N};
        martix[4] = new int[]{N, N, 8, N, N, 5, 4};
        martix[5] = new int[]{N, N, N, 4, 5, N, 6};
        martix[6] = new int[]{2, 3, N, N, 4, 6, N};
        DGraph graph = new DGraph(vertexs, martix);
        graph.showGraph();
        graph.djs(6);
        graph.showDjs(6);
    }

}
