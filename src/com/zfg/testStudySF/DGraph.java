package com.zfg.testStudySF;

import java.util.Arrays;

/**
 * @ClassName DGraph
 * @Description 图(迪杰斯特拉算法)
 * @Author zfg
 * @Date 2022/8/15 下午 12:19
 */
public class DGraph {

    //顶点集合
    private char[] vertexs;
    //邻接矩阵
    private int[][] matrix;
    //已访问结点的集合
    private VisitedVertex vv;

    //初始化图
    public DGraph(char[] vertexs, int[][] matrix) {
        this.matrix = matrix;
        this.vertexs = vertexs;
    }

    //展示图
    public void showGraph() {
        for (int[] data : matrix) {
            System.out.println(Arrays.toString(data));
        }
    }

    //迪杰斯特拉算法
    public void djs(int index) {
        vv = new VisitedVertex(vertexs.length, index);
        //更新Pre和Dis数组
        update(index);
        for (int i = 1; i < vertexs.length; i++) {
            index = vv.upadateArr();
            update(index);
        }
    }

    //更新index下标结点到周围结点的距离以及周围结点的前驱结点
    public void update(int index) {
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            len = vv.getDis(index) + matrix[index][i];
            //如果结点i没有被访问并且len小于出发顶点到i顶点的距离，更新
            if (!vv.isVisited(i) && len < vv.getDis(i)) {
                vv.updatePre(i, index);
                vv.updateDis(i, len);
            }
        }
    }

    //显示最后结果
    public void showDjs(int index) {
        vv.show(index);
    }

}
