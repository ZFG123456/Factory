package com.zfg.testMianShi;

/**
 * @ClassName Main1
 * @Description 实现二叉树，二叉树的中序遍历
 * @Author zfg
 * @Date 2022/8/11 下午 03:51
 */
public class Main1 {

    public static void main(String[] args) {

        TreeNode nodeA = new TreeNode(1);
        TreeNode nodeB = new TreeNode(2);
        TreeNode nodeC = new TreeNode(3);
        TreeNode nodeD = new TreeNode(4);
        TreeNode nodeE = new TreeNode(5);

        nodeA.left = nodeB;
        nodeA.right = nodeD;
        nodeB.right = nodeC;
        nodeD.right = nodeE;

        centerTree(nodeA);


    }

    //二叉树的中序遍历(递归实现)
    public static void centerTree(TreeNode root) {

        if (root == null) {
            return;
        }
        centerTree(root.left);
        System.out.print(root.val + " ");
        centerTree(root.right);

    }

}
