package com.zfg.testListNode;

/**
 * @ClassName Graph
 * @Description 构建有权图(链表的方式)
 * @Author zfg
 * @Date 2022/7/30 上午 09:41
 */
public class Graph {

    public static void main(String[] args) {

        GraphNode[] graphNodes = new GraphNode[4];

        for (int i = 0; i < 4; i++) {
            graphNodes[i] = new GraphNode(i, i + 2);
        }

        graphNodes[0].next.add(graphNodes[2]);
        graphNodes[0].next.add(graphNodes[3]);

        graphNodes[1].next.add(graphNodes[0]);
        graphNodes[1].next.add(graphNodes[2]);


        graphNodes[2].next.add(graphNodes[3]);
        graphNodes[3].next.add(graphNodes[0]);

        for (int i = 0; i < graphNodes.length; i++) {
            System.out.print(graphNodes[i].node + " ");
        }
        System.out.println();
        for (int i = 0; i < graphNodes.length; i++) {
            System.out.print(graphNodes[i].val + " ");
        }
        System.out.println();
        for (int i = 0; i < graphNodes.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(graphNodes[j].next);
            }
        }


    }

}
