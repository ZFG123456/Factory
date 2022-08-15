package com.zfg.testStudySF;

import com.zfg.testListNode.TreeNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName TreeDepth
 * @Description 二叉树的深度(递归)
 * https://blog.csdn.net/weixin_38383877/article/details/89363080可以参考这篇文章的递归理解
 * @Author zfg
 * @Date 2022/8/15 下午 06:20
 */
public class TreeDepth {

    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode(1);
        TreeNode nodeB = new TreeNode(2);
        TreeNode nodeC = new TreeNode(3);
        TreeNode nodeD = new TreeNode(4);
        TreeNode nodeE = new TreeNode(5);
        TreeNode nodeF = new TreeNode(6);
        TreeNode nodeG = new TreeNode(7);

        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeE.left = nodeG;
        nodeC.right = nodeF;

        System.out.print("树的深度为:");
        System.out.println(getDepth(nodeA));
        System.out.println("是否为平衡二叉树:");
        System.out.println(isBalacedTree(nodeA));
        System.out.println("前序遍历查找某个结点:");
//        System.out.println(getNode(nodeA,nodeE).val);
        System.out.println(nodeA.getNode(5));
        System.out.println(nodeA.getNode1(8));
//        System.out.println("删除前二叉树:");
//        preOder(nodeA);
//        delNode(nodeA,1);
//        System.out.println();
//        System.out.println("删除后二叉树:");
//        preOder(nodeA);

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(nodeA);
        System.out.println("删除前二叉树:");
        binaryTree.preShow();
        binaryTree.delNode(1);
        System.out.println();
        System.out.println("删除后二叉树:");
        binaryTree.preShow();
    }

    //树的深度
    public static int getDepth(TreeNode root) {
        if (root != null) {
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }

    //判断是否为平衡二叉树
    public static boolean isBalacedTree(TreeNode root) {

        if (root == null) {
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalacedTree(root.left) && isBalacedTree(root.right);

    }

    //查找树中的某个结点
    public static TreeNode getNode(TreeNode root, TreeNode node) {
        TreeNode resNode = null;
        if (root.val == node.val) {
            resNode = root;
            return resNode;
        }
        if (root.left != null) {
            resNode = getNode(root.left, node);
        }
        if (resNode != null) {
            return resNode;
        }
        if (root.right != null) {
            resNode = getNode(root.right, node);
        }
        return resNode;
    }

    //删除某个结点
    public static void delNode(TreeNode root, int index) {
        if (root != null) {
            if (root.val == index) {
                root = null;
            } else {
                root.delNode(index);
            }
        } else {
            System.out.println("没有可以删除的结点!");
        }
    }

    //先序遍历
    public static void preOder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "->");
        preOder(root.left);
        preOder(root.right);
    }
}
