package com.zfg.testStudySF;

import java.util.Arrays;

/**
 * @ClassName VisitedVertex
 * @Description 已访问顶点的集合(迪杰斯特拉算法)
 * @Author zfg
 * @Date 2022/8/15 下午 12:36
 */
public class VisitedVertex {

    //记录各个顶点是否呗访问过
    public int[] already_arr;
    //每个下标对应的值是前一个结点下标
    public int[] pre_visited;
    //记录出发顶点到各个顶点的距离
    public int[] dis;

    public VisitedVertex(int len, int index) {
        already_arr = new int[len];
        pre_visited = new int[len];
        dis = new int[len];
        //设置出发顶点已经访问
        already_arr[index] = 1;
        //初始化dis数组
        Arrays.fill(dis, Dijkstra.N);
        //设置自己到自己为0
        this.dis[index] = 0;
    }

    //判断index结点是否被访问过
    public boolean isVisited(int index) {
        return already_arr[index] == 1;
    }

    //更新dis数组,出发结点到index结点的距离
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    //更新前驱数组,更新pre的前驱结点为index结点
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    //出发顶点到index顶点的距离
    public int getDis(int index) {
        return dis[index];
    }

    //继续选择并返回新的访问结点
    public int upadateArr() {
        int min = 65535;
        int index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        //更新index结点被访问
        already_arr[index] = 1;
        return index;
    }

    //显示最后结果
    public void show(int index) {
        System.out.println("**************");
        System.out.println("访问的数组情况:");
        for (int vaule : already_arr) {
            System.out.print(vaule + " ");
        }
        System.out.println();
        System.out.println("前驱的数组情况:");
        for (int vaule : pre_visited) {
            System.out.print(vaule + " ");
        }
        System.out.println();
        System.out.println("结果的数组情况:");
        for (int vaule : dis) {
            System.out.print(vaule + " ");
        }
        System.out.println();
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int i = 0;
        for (int data : dis) {
            if (data != Dijkstra.N) {
                System.out.println(vertexs[index] + "->" + vertexs[i] + "(" + data + ")");
            }
            i++;
        }
    }
}
