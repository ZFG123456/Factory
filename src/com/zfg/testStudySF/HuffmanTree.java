package com.zfg.testStudySF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName HuffmanTree
 * @Description 哈夫曼树
 * @Author zfg
 * @Date 2022/8/16 下午 03:26
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node res = creatHuffmanTree(arr);
        preOder(res);
    }

    //创建哈夫曼树
    public static Node creatHuffmanTree(int[] arr) {
        //遍历arr数组创建结点,将结点集合放大list中
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            nodes.add(temp);
        }
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //取出权值最小的两颗二叉树
            //1.取出权值最小的结点
            Node leftNode = nodes.get(0);
            //2.取出权值次小的结点
            Node rightNode = nodes.get(1);
            //3.构建新的二叉树
            Node parent = new Node(leftNode.val + rightNode.val);
            parent.left = leftNode;
            parent.right = rightNode;
            //4.删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5.加入新的二叉树
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    //先序遍历
    public static void preOder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "->");
        preOder(root.left);
        preOder(root.right);
    }

}
