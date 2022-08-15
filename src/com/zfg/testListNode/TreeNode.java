package com.zfg.testListNode;

/**
 * @ClassName TreeNode
 * @Description 树结点
 * @Author zfg
 * @Date 2022/7/28 下午 06:12
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    //查找树中某个结点教程代码(前序遍历)
    public TreeNode getNode(int index) {
        if (this.val == index) {
            return this;
        }
        TreeNode resNode = null;
        if (this.left != null) {
            resNode = this.left.getNode(index);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.getNode(index);
        }
        return resNode;
    }

    //查找树中某个结点教程代码(中序遍历)
    public TreeNode getNode1(int index) {
        TreeNode resNode = null;
        if (this.left != null) {
            resNode = this.left.getNode1(index);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.val == index) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.getNode1(index);
        }
        return resNode;
    }

    //查找树中某个结点教程代码(后序遍历)
    public TreeNode getNode2(int index) {
        TreeNode resNode = null;
        if (this.left != null) {
            resNode = this.left.getNode2(index);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.getNode2(index);
        }
        if (this.val == index) {
            return this;
        }
        return resNode;
    }

    //递归删除指定结点
    //如果该节点是叶子结点，直接删除。如果不是则删除该子树
    public void delNode(int index) {
        //左子节点匹配成功，删除左子节点
        if (this.left != null && this.left.val == index) {
            this.left = null;
            return;
        }
        //右子节点匹配成功，删除右子节点
        if (this.right != null && this.right.val == index) {
            this.right = null;
            return;
        }
        //左子树递归删除
        if (this.left != null) {
            this.left.delNode(index);
        }
        //右子树递归删除
        if (this.right != null) {
            this.right.delNode(index);
        }
    }

    //先序遍历
    public void preDisplay() {
        System.out.print(this.val + "->");
        if (this.left != null) {
            this.left.preDisplay();
        }
        if (this.right != null) {
            this.right.preDisplay();
        }
    }

}
