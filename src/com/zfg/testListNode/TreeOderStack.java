package com.zfg.testListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName TreeOderStack
 * @Description 树的遍历栈实现
 * @Author zfg
 * @Date 2022/8/3 下午 08:32
 */
public class TreeOderStack {

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

        List<Integer> list = proOder(nodeA);
        List<Integer> list1 = centerOder(nodeA);
        List<Integer> list2 = afterOder(nodeA);

        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");
        }

    }

    //先序遍历栈实现
    public static List<Integer> proOder(TreeNode root) {

        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

        return list;

    }

    //中序遍历栈实现
    public static List<Integer> centerOder(TreeNode root) {

        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) {
                cur = temp.right;
            }

        }
        return list;

    }

    //后序遍历栈实现
    public static List<Integer> afterOder(TreeNode root) {

        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            stack1.push(temp);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }

        }

        while (!stack1.isEmpty()) {
            list.add(stack1.pop().val);
        }
        return list;

    }

}
