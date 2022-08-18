package com.zfg.testStudySF;

/**
 * @ClassName SortTree
 * @Description 二叉排序树
 * @Author zfg
 * @Date 2022/8/18 下午 04:10
 */
public class SortTree {

    private SortNode root;

    //创建二叉排序树
    public void add(SortNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //查找要删除的节点
    public SortNode searchNode(int val) {
        if (root == null) {
            return null;
        } else {
            return root.searchNode(val);
        }
    }

    //查找要删除的结点的父节点
    public SortNode searchParent(int val) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(val);
        }
    }

    //删除结点
    public void delNode(int val) {
        if (root == null) {
            return;
        } else {
            SortNode targetNode = searchNode(val);
            if (targetNode == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            SortNode parent = searchParent(val);
            //删除叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.val == val) {
                    parent.left = null;
                }
                if (parent.right != null && parent.right.val == val) {
                    parent.right = null;
                }
                //删除有两颗子树的结点
            } else if (targetNode.left != null && targetNode.right != null) {
                int treeMin = delTreeMin(targetNode.right);
                targetNode.val = treeMin;
            } else {
                //删除有一颗子树的结点
                if (targetNode.left != null) {
                    if (parent != null) {
                        if (parent.left.val == val) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else if (targetNode.right != null) {
                    if (parent != null) {
                        if (parent.left.val == val) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    //查找要删除的有两颗子树的最小结点并删除该节点
    public int delTreeMin(SortNode node) {
        SortNode temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        delNode(temp.val);
        return temp.val;
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
