package com.zfg.testStudySF;

/**
 * @ClassName Kruska
 * @Description 克鲁斯卡尔算法解决公交车站问题
 * @Author zfg
 * @Date 2022/8/14 下午 04:44
 */
public class Kruskal {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

        char[] vertaxs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] martexs = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        KGraph graph = new KGraph(vertaxs, martexs);
        graph.showGraph();
//        EData[] edges = graph.getEdges();
//        graph.sortEdges(edges);
//        System.out.println(Arrays.toString(edges));
        graph.kruskal();


    }

}
