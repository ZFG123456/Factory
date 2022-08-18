package com.zfg.testStudySF;

/**
 * @ClassName ThreadedBinaryTree
 * @Description 线索二叉树(中序遍历的方式)
 * @Author zfg
 * @Date 2022/8/16 下午 12:24
 */
public class ThreadedBinaryTree {

    TreeNode pre = null;
    TreeNode root = null;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public static void main(String[] args) {

        TreeNode nodeA = new TreeNode(1);
        TreeNode nodeB = new TreeNode(3);
        TreeNode nodeC = new TreeNode(8);
        TreeNode nodeD = new TreeNode(10);
        TreeNode nodeE = new TreeNode(6);
        TreeNode nodeF = new TreeNode(14);

        nodeA.left = nodeB;
        nodeA.right = nodeE;
        nodeB.left = nodeC;
        nodeB.right = nodeD;
        nodeE.left = nodeF;

        ThreadedBinaryTree tb = new ThreadedBinaryTree();
        tb.setRoot(nodeA);
        //先序遍历实现线索化二叉树
//        tb.preThreadedNode(tb.root);
        System.out.println("中序遍历:");
        nodeA.cenOder(tb.root);
//        tb.preThreadedNode(tb.root);
        tb.threadedNode(tb.root);
        System.out.println();
        System.out.println(tb.root.left.left.right.val);
        //线索化方式遍历线索二叉树
        tb.threadedList();

    }

    //线索化二叉树
    //node为当前需要线索化的结点
    public void threadedNode(TreeNode node) {
        if (node == null) {
            return;
        }
        //线索化左子树
        threadedNode(node.left);
        //线索化当前结点
        //处理当前结点的前驱结点
        if (node.left == null) {
            //让当前结点的左指针指向前驱结点
            node.left = pre;
            //修改当前结点的左指针的类型
            node.leftType = 1;
        }
        //处理当前结点的后继结点
        if (pre != null && pre.right == null) {
            //前驱结点的右指针指向当前结点
            pre.right = node;
            pre.rightType = 1;
        }
        //当前结点指向下一个结点的前驱结点
        pre = node;
        //线索化右子树
        threadedNode(node.right);
    }

    //线索化二叉树(先序)
    public void preThreadedNode(TreeNode node) {

        if (node == null) {
            return;
        }
        //线索化当前结点
        //处理当前结点的前驱结点
        if (node.left == null) {
            //让当前结点的左指针指向前驱结点
            node.left = pre;
            //修改当前结点的左指针的类型
            node.leftType = 1;
        }
        //处理当前结点的后继结点
        if (pre != null && pre.right == null) {
            //前驱结点的右指针指向当前结点
            pre.right = node;
            pre.rightType = 1;
        }
        //当前结点指向下一个结点的前驱结点
        pre = node;

        //线索化左子树
        if (node.leftType == 0) {
            preThreadedNode(node.left);
        }

        //线索化右子树
        if (node.rightType == 0) {
            preThreadedNode(node.right);
        }

    }

    //遍历线索化二叉树
    public void threadedList() {
        //定义一个临时变量来保存当前结点
        TreeNode node = root;
        while (node != null) {
            while (node.leftType == 0) {
                node = node.left;
            }
            System.out.print(node.val + "->");
            while (node.rightType == 1) {
                node = node.right;
                System.out.print(node.val + "->");
            }
            node = node.right;
        }
    }

}
