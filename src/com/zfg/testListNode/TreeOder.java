package com.zfg.testListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TreeOder
 * @Description 二叉树遍历返回数组
 * @Author zfg
 * @Date 2022/7/28 下午 06:14
 */
public class TreeOder {

    public static void main(String[] args) {

        TreeNode nodeA = new TreeNode(1);
        TreeNode nodeB = new TreeNode(2);
        TreeNode nodeC = new TreeNode(3);
        TreeNode nodeD = new TreeNode(4);
        TreeNode nodeE = new TreeNode(5);

//        nodeA.right = nodeB;
//        nodeB.left = nodeC;
        nodeA.left = nodeB;
        nodeB.left = nodeC;
        nodeC.left = nodeD;
        nodeD.left = nodeE;

        int[] res = preorderTraversal(nodeA);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    //先序遍历
    public static void proOder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        proOder(list, root.left);
        proOder(list, root.right);
    }

    //中序遍历
    public static void cenOder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        cenOder(list, root.left);
        list.add(root.val);
        cenOder(list, root.right);
    }

    //后序遍历
    public static void aftOder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        aftOder(list, root.left);
        aftOder(list, root.right);
        list.add(root.val);
    }

    public static int[] preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
//        proOder(list,root);
//        cenOder(list,root);
        aftOder(list, root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

}
