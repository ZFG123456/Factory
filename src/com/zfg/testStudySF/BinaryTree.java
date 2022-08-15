package com.zfg.testStudySF;

import com.zfg.testListNode.TreeNode;

/**
 * @ClassName BinaryTree
 * @Description 遍历二叉树
 * @Author zfg
 * @Date 2022/8/15 下午 11:09
 */
public class BinaryTree {

    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    //删除某个结点
    public void delNode(int index) {
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
    public void preShow() {
        if (this.root != null) {
            this.root.preDisplay();
        } else {
            System.out.println("二叉树为空!");
        }
    }

}
