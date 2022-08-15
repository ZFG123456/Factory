package com.zfg.testStudySF;

import java.util.Arrays;

/**
 * @ClassName KGraph
 * @Description 图(克鲁斯卡尔算法)
 * @Author zfg
 * @Date 2022/8/14 下午 04:45
 */
public class KGraph {

    //边的个数
    private int edgeNum;
    //定点数组
    private char[] vertaxs;
    //邻接矩阵
    private int[][] matrix;
    //标识两边不连通
    private static final int INF = Integer.MAX_VALUE;

    //初始化图
    public KGraph(char[] vertaxs, int[][] matrix) {
        int vLen = vertaxs.length;
        this.vertaxs = vertaxs;
        this.matrix = matrix;
        //初始化边数
        for (int i = 0; i < vLen; i++) {
            for (int j = i + 1; j < vLen; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    //显示图
    public void showGraph() {
        for (int[] data : matrix) {
            System.out.println(Arrays.toString(data));
        }
    }

    //对边进行排序处理(冒泡排序)
    public void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    //返回对应结点的下标
    public int getPosition(char c) {
        for (int i = 0; i < vertaxs.length; i++) {
            if (c == vertaxs[i]) {
                return i;
            }
        }
        return -1;
    }

    //获取图中的边
    public EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertaxs.length; i++) {
            for (int j = i + 1; j < vertaxs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertaxs[i], vertaxs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    //获取下标为i的结点的终点ends是逐步加入的
    public int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    //克鲁斯卡尔算法
    public void kruskal() {
        //标识最后结果数组的索引
        int index = 0;
        //用于保存已生成的最小生成树的每一个顶点在最小生成树中的终点
        int[] ends = new int[edgeNum];
        //创建结果数组
        EData[] res = new EData[edgeNum];
        //获取图中所有边的集合
        EData[] edges = getEdges();
        //所有边集合的输出
        System.out.println(Arrays.toString(edges));
        //按照边的权值大小进行排序
        sortEdges(edges);
        //遍历edges数组,将边添加到最小生成树中并判断是否构成回路
        for (int i = 0; i < edgeNum; i++) {
            //获取第一条边的第一个顶点(起点)
            int p1 = getPosition(edges[i].start);
            //获取第一条边的第二个顶点
            int p2 = getPosition(edges[i].end);
            //获取p1顶点的终点
            int m = getEnd(ends, p1);
            //获取p2顶点的终点
            int n = getEnd(ends, p2);
            //是否构成回路
            if (m != n) {
                ends[m] = n;
                res[index++] = edges[i];
            }
        }
        //输出结果数组
        System.out.println(Arrays.toString(res));
        for (EData data : res) {
            if (data != null) {
                System.out.println(data);
            }
        }

    }

}
