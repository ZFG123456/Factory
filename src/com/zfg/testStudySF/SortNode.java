package com.zfg.testStudySF;

/**
 * @ClassName SortNode
 * @Description 二叉排序树结点
 * @Author zfg
 * @Date 2022/8/18 下午 03:59
 */
public class SortNode {

    int val;
    SortNode left;
    SortNode right;

    public SortNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "SortNode{" +
                "val=" + val +
                '}';
    }

    //添加结点(递归)
    public void add(SortNode node) {
        if (node == null) {
            return;
        }
        //添加左子节点
        if (node.val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        }
        //添加右子节点
        if (node.val > this.val) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    //查找要删除的结点
    public SortNode searchNode(int val) {
        if (val == this.val) {
            return this;
        } else if (val < this.val) {
            if (this.left == null) {
                return null;
            }
            return this.left.searchNode(val);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.searchNode(val);
        }
    }

    //查找要删除结点的父节点
    public SortNode searchParent(int val) {
        if ((this.left != null && this.left.val == val) || (this.right != null && this.right.val == val)) {
            return this;
        } else {
            if (this.left != null && this.val > val) {
                return this.left.searchParent(val);
            } else if (this.right != null && this.val <= val) {
                return this.right.searchParent(val);
            } else {
                return null;
            }
        }
    }

    //先序遍历
    public void preOder() {
        System.out.print(this + "--->");
        if (this.left != null) {
            this.left.preOder();
        }
        if (this.right != null) {
            this.right.preOder();
        }
    }


    //中序遍历
    public void cenOder() {
        if (this.left != null) {
            this.left.cenOder();
        }
        System.out.print(this + "--->");
        if (this.right != null) {
            this.right.cenOder();
        }
    }

}
