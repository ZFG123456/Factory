package com.zfg.testStudySF;

/**
 * @ClassName TreeNode
 * @Description 线索二叉树
 * @Author zfg
 * @Date 2022/8/16 下午 12:27
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    //如果leftType == 0标识指向的是左子树,leftType == 1标识指向的是前驱结点
    int leftType;
    //rightType == 0标识指向的是右子树,rightType == 1标识指向的是后继结点
    int rightType;

    public TreeNode(int val) {
        this.val = val;
    }

    //先序遍历
    public void preOder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "->");
        preOder(root.left);
        preOder(root.right);
    }

    //中序遍历
    public void cenOder(TreeNode root) {
        if (root == null) {
            return;
        }
        cenOder(root.left);
        System.out.print(root.val + "->");
        cenOder(root.right);
    }

    //后序遍历
    public void aftOder(TreeNode root) {
        if (root == null) {
            return;
        }
        aftOder(root.left);
        aftOder(root.right);
        System.out.print(root.val + "->");
    }
}
