package com.zfg.testStudySF;

/**
 * @ClassName Node
 * @Description 哈夫曼树
 * @Author zfg
 * @Date 2022/8/16 下午 03:23
 */
public class Node implements Comparable<Node> {

    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}
