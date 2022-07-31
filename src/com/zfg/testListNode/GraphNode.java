package com.zfg.testListNode;

import java.util.LinkedList;

/**
 * @ClassName GraphNode
 * @Description 图的结点
 * @Author zfg
 * @Date 2022/7/30 上午 09:39
 */
public class GraphNode {

    int node;
    int val;
    LinkedList next;

    public GraphNode(int node, int val) {
        this.node = node;
        this.val = val;
        this.next = new LinkedList<>();
    }
}
