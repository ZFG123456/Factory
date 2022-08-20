package com.zfg.testStudySF;

/**
 * @ClassName BinaryAvlTree
 * @Description 平衡二叉树
 * @Author zfg
 * @Date 2022/8/19 下午 03:39
 */
public class BinaryAvlTree {

    private AVLNode root;

    //构建平衡二叉树
    public void addAvlTree(AVLNode node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    //查找要删除的结点
    public AVLNode searchNode(int val) {
        if (root == null) {
            return null;
        } else {
            return root.searchNode(val);
        }
    }

    //查找要删除结点的父节点
    public AVLNode parent(int val) {

        if (root == null) {
            return null;
        } else {
            return root.parent(val);
        }

    }

    //以当前结点为根结点的高度
    public int getHeight() {
        return root.getHeight();
    }

    //左子树高度
    public int leftHight() {
        return root.leftHight();
    }

    //右子树高度
    public int rightHight() {
        return root.rightHight();
    }

    //先序遍历
    public void preOder() {
        if (root == null) {
            System.out.println("二叉排序树为空!");
        } else {
            root.preOder();
        }
    }

    //中序遍历
    public void cenOder() {
        if (root == null) {
            System.out.println("二叉排序树为空!");
        } else {
            root.cenOder();
        }
    }

}
