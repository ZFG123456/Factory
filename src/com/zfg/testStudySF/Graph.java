package com.zfg.testStudySF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Graph
 * @Description 图的邻接矩阵
 * 1.保存图的结点
 * 2.构建邻接矩阵
 * 3.输出邻接矩阵
 * @Author zfg
 * @Date 2022/8/10 下午 12:33
 */
public class Graph {

    //存放图结点的list
    private ArrayList<String> node;
    //结点个数
    private int nodeNum;
    //边的数量
    private int edgeNum;
    //存放邻接矩阵的数组(即边的关系)
    private int[][] edges;
    //标记访问过的结点数组
    private boolean[] isVisited;

    public static void main(String[] args) {

        Graph graph = new Graph(5);
        String[] nodeStr = {"A", "B", "C", "D", "E"};
        //循环的添加图结点
        for (int i = 0; i < nodeStr.length; i++) {
            graph.insertNode(nodeStr[i]);
        }
        //添加边
        //A-B
        graph.getEdge(0, 1, 1);
        //A-C
        graph.getEdge(0, 2, 1);
        //B-C
        graph.getEdge(1, 2, 1);
        //B-D
        graph.getEdge(1, 3, 1);
        //B-E
        graph.getEdge(1, 4, 1);
        //显示邻接矩阵
        graph.showEdge();
        //边的数量
        System.out.println(graph.getEdgeNum());
        //结点数量
        System.out.println(graph.getNodeNum());
        System.out.println(graph.getNeighbor(0));
        //深度遍历
//        System.out.println("深度遍历:");
//        graph.dfs();
//        System.out.println();
        //广度优先遍历
        System.out.println("广度优先遍历:");
        graph.bfs();
    }

    //初始化构建图
    public Graph(int nodeNum) {
        this.nodeNum = nodeNum;
        node = new ArrayList<>();
        edges = new int[nodeNum][nodeNum];
        isVisited = new boolean[nodeNum];
        edgeNum = 0;
    }

    //添加图结点
    public void insertNode(String v) {
        node.add(v);
    }

    //查询结点个数
    public int getNodeNum() {
        return node.size();
    }

    //构建邻接矩阵
    public void getEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgeNum++;
    }

    //查询边的数量
    public int getEdgeNum() {
        return edgeNum;
    }

    //返回结点下标对应的数据
    public String getStr(int v) {
        return node.get(v);
    }

    //得到v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图的邻接矩阵
    public void showEdge() {
        for (int[] data : edges) {
            System.out.println(Arrays.toString(data));
        }
    }

    //得到第一个邻接点的下标
    public int getNeighbor(int index) {
        for (int i = 0; i < node.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < node.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //深度优先遍历算法,i一开始为0
    public void dfs(boolean[] isVisited, int i) {
        //首先访问该结点,输出
        System.out.print(getStr(i) + "->");
        //将访问过的设置为true
        isVisited[i] = true;
        //查看第一个结点的邻接结点
        int w = getNeighbor(i);
        //如果有邻接结点，进行访问
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }

            //如果该节点被访问过就查找该节点的下一个邻接结点
            w = getNextNeighbor(i, w);

        }

    }

    //对dfs进行重载，遍历所有结点，并进行dfs
    public void dfs() {
        for (int i = 0; i < getNodeNum(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //广度优先遍历
    public void bfs(boolean[] isVisited, int i) {
        //队列头结点的下标
        int u;
        //邻接结点w
        int w;
        //结点访问顺序的记录
        Queue<Integer> queue = new LinkedList<>();
        //访问这个结点
        System.out.print(getStr(i) + "->");
        //标记为已访问
        isVisited[i] = true;
        //将结点入队
        queue.add(i);
        while (!queue.isEmpty()) {
            //取出队列的头结点下标
            u = queue.poll();
            //查看第一个结点的邻接结点
            w = getNeighbor(u);
            while (w != -1) {
                //是否访问过
                if (!isVisited[w]) {
                    System.out.print(getStr(w) + "->");
                    //标记已访问
                    isVisited[w] = true;
                    //入队列
                    queue.add(w);
                }
                //以原来结点为行，找出下一个邻接结点
                w = getNextNeighbor(u, w);
            }
        }
    }

    //遍历所有结点，并进行bfs
    public void bfs() {
        for (int i = 0; i < getNodeNum(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

}
