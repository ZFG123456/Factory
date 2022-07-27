package com.zfg.testListNode;

import java.util.*;

/**
 * @ClassName TwoTreePre
 * @Description 二叉树的遍历
 * @Author zfg
 * @Date 2022/7/27 下午 07:58
 */
public class TwoTreePre {

    public static void main(String[] args) {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeE.left = nodeG;
        nodeC.right = nodeF;

        preOrder(nodeA);
        System.out.println();
        centerOrder(nodeA);
        System.out.println();
        afterOrder(nodeA);


        System.out.println();
        preOrder1(nodeA);
        System.out.println();
        centerOrder1(nodeA);
        System.out.println();
        centerOrder1(nodeA);
        System.out.println();
        afterOrder1(nodeA);
        System.out.println();
        bfs(nodeA);
        System.out.println();
        bfs1(nodeA);

    }

    /***
     * @Description: //先序遍历
     * @MethodName: preOrder
     * @Param: [root]
     * @return: void
     * @Author: zfg
     * @Date: 2022/7/27 下午 08:12
     */
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /***
     * @Description: //中序遍历
     * @MethodName: centerOrder
     * @Param: [root]
     * @return: void
     * @Author: zfg
     * @Date: 2022/7/27 下午 08:13
     */
    public static void centerOrder(Node root) {
        if (root == null) {
            return;
        }
        centerOrder(root.left);
        System.out.print(root.val + " ");
        centerOrder(root.right);
    }

    /***
     * @Description: //后序遍历
     * @MethodName: afterOrder
     * @Param: [root]
     * @return: void
     * @Author: zfg
     * @Date: 2022/7/27 下午 08:20
     */
    public static void afterOrder(Node root) {
        if (root == null) {
            return;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.val + " ");
    }

    /***
     * @Description: //栈的方式实现(先序遍历)
     * @MethodName: preOrder1
     * @Param: [root]
     * @return: void
     * @Author: zfg
     * @Date: 2022/7/27 下午 08:27
     */
    public static void preOrder1(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /***
     * @Description: //栈的方式实现(中序遍历)
     * @MethodName: preOrder1
     * @Param: [root]
     * @return: void
     * @Author: zfg
     * @Date: 2022/7/27 下午 08:27
     */
    public static void centerOrder1(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                cur = node.right;
            }
        }
    }

    /***
     * @Description: //栈的方式实现(后序遍历)
     * @MethodName: afterOrder1
     * @Param: [root]
     * @return: void
     * @Author: zfg
     * @Date: 2022/7/27 下午 08:58
     */
    public static void afterOrder1(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            stack1.push(node);
//            System.out.print(node.val+" ");
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!stack1.isEmpty()) {
            System.out.print(stack1.pop().val + " ");
        }
    }

    /***
     * @Description: //层次遍历(队列实现)
     * @MethodName: bfs
     * @Param: [root]
     * @return: void
     * @Author: zfg
     * @Date: 2022/7/27 下午 09:06
     */
    public static void bfs(Node root) {

        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    /***
     * @Description: //层序遍历实现一层一层打印
     * @MethodName: bfs1
     * @Param: [root]
     * @return: java.util.List<java.util.List < java.lang.String>>
     * @Author: zfg
     * @Date: 2022/7/27 下午 09:29
     */
    public static List<List<String>> bfs1(Node root) {

        List<List<String>> res = new ArrayList<>();

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<String> temp;

        while (!queue.isEmpty()) {

            int count = queue.size();
            temp = new ArrayList<>();

            while (count-- > 0) {

                Node node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }

        return res;

    }

}
