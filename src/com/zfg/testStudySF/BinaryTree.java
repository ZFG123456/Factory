package com.zfg.testStudySF;
import com.zfg.testListNode.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    //中序遍历
    public void cenOder(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        cenOder(list, root.left);
        list.add(root.val);
        cenOder(list, root.right);
    }

    //调用方法实现返回结果数组
    public int[] inorderTraversal(Node root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        cenOder(list, root);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //后序遍历
    public void aftOder(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        cenOder(list, root.left);
        cenOder(list, root.right);
        list.add(root.val);
    }

    //层序遍历
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // write code here
        if (root == null) {
            return null;
        }
        //结果集合
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        //层结点集合
        ArrayList<Integer> tempList = null;
        //队列操作
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            //层结点集合
            tempList = new ArrayList<>();
            while (size-- > 0) {
                //结点出队列
                Node temp = queue.poll();
                tempList.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            resList.add(tempList);
        }

        return resList;
    }

    //二叉树的深度
    public int maxDepth(Node root) {
        // write code here
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    //平衡二叉树的判断
    public boolean IsBalanced_Solution(Node root) {

        if (root == null) {
            return true;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

    }

    //给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
    //1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
    //2.叶子节点是指没有子节点的节点
    //3.路径只能从父节点到子节点，不能从子节点到父节点
    //4.总节点数目为n
    public boolean hasPathSum(Node root, int sum) {
        // write code here
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }

    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    //思路:
    //二叉搜索树最左端的元素一定最小，最右端的元素一定最大，
    // 符合“左中右”的特性，因此二叉搜索树的中序遍历就是一个递增序列，
    // 我们只要对它中序遍历就可以组装称为递增双向链表。
    //step 1：创建两个指针，一个指向题目中要求的链表头（head），一个指向当前遍历的前一节点（pre)。
    Node head = null;
    Node pre = null;

    public Node Convert(Node pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        //step 2：首先递归到最左，初始化head与pre。
        Convert(pRootOfTree.left);
        if (pre == null) {
            head = pRootOfTree;
            pre = pRootOfTree;
        } else {
            //step 3：然后处理中间根节点，依次连接pre与当前节点，连接后更新pre为当前节点。
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }
        //step 4：最后递归进入右子树，继续处理。
        Convert(pRootOfTree.right);
        //step 5：递归出口即是节点为空则返回。
        return head;

    }

    //判断一棵二叉树是否是镜像，即判断二叉树是否是轴对称图形
    boolean isSymmetrical(Node pRoot) {
        return recursion(pRoot, pRoot);
    }

    //思路：
    //前序遍历的时候我们采用的是“根左右”的遍历次序，如果这棵二叉树是对称的，
    // 即相应的左右节点交换位置完全没有问题，那我们是不是可以尝试“根右左”遍历，
    // 按照轴对称图像的性质，这两种次序的遍历结果应该是一样的。
    boolean recursion(Node pRoot1, Node pRoot2) {
        //step 1：两种方向的前序遍历，同步过程中的当前两个节点，同为空，属于对称的范畴。
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }
        //step 2：当前两个节点只有一个为空或者节点值不相等，已经不是对称的二叉树了。
        if (pRoot1 == null || pRoot2 == null || pRoot1.val != pRoot2.val) {
            return false;
        }
        //step 3：第一个节点的左子树与第二个节点的右子树同步递归对比，第一个节点的右子树与第二个节点的左子树同步递归比较。
        return recursion(pRoot1.left, pRoot2.right) && recursion(pRoot1.right, pRoot2.left);
    }

    public static void main(String[] args) {

        Node pRootOfTree = new Node(4);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node8 = new Node(8);
        Node node6 = new Node(6);
        Node node9 = new Node(9);

        pRootOfTree.left = node2;
        pRootOfTree.right = node8;
        node2.left = node1;
        node2.right = node3;
        node8.left = node6;
        node8.right = node9;

        BinaryTree bt = new BinaryTree();
        bt.Convert(pRootOfTree);
    }

}
