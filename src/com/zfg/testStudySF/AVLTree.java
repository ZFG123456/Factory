package com.zfg.testStudySF;

/**
 * @ClassName AVLTree
 * @Description 平衡二叉树
 * @Author zfg
 * @Date 2022/8/19 下午 03:38
 */
public class AVLTree {

    public static void main(String[] args) {

//        int[] arr = {4,3,6,5,7,8};
//        int[] arr = {10,12,8,9,7,6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        BinaryAvlTree avl = new BinaryAvlTree();
        for (int i = 0; i < arr.length; i++) {
            avl.addAvlTree(new AVLNode(arr[i]));
        }
        System.out.println("中序遍历:");
        avl.cenOder();
        System.out.println();
        int hight = avl.getHeight();
        System.out.println("树的高度:" + hight);
        int leftHight = avl.leftHight();
        System.out.println("左子树的高度:" + leftHight);
        int rightHight = avl.rightHight();
        System.out.println("右子树的高度:" + rightHight);
        System.out.println("先序遍历:");
        avl.preOder();

    }

}
