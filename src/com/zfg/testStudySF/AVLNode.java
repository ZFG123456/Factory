package com.zfg.testStudySF;

/**
 * @ClassName AVLNode
 * @Description 平衡二叉树结点
 * @Author zfg
 * @Date 2022/8/19 下午 03:40
 */
public class AVLNode {

    int val;
    AVLNode left;
    AVLNode right;

    public AVLNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "val=" + val +
                '}';
    }

    //创建二叉平衡树
    public void addNode(AVLNode node) {
        if (node == null) {
            return;
        }

        //添加左节点
        if (node.val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addNode(node);
            }
        }

        //添加右节点
        if (node.val > this.val) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }

        //当右子树添加的时候(右-左)高度差>1时发生左旋转,调整二叉树为平衡二叉树
        if (rightHight() - leftHight() > 1) {
            //当前结点的右子树的左子树高度大于右子树高度--->先右旋转再左旋转
            if (this.right != null && this.right.leftHight() > this.right.rightHight()) {
                //当前结点的右子树进行左旋转
                this.right.rightRoate();
                //当前结点进行右旋转
                leftRoate();
            } else {
                leftRoate();
            }
            return;
        }
        //当左子树添加的时候(左-右)高度差>1时发生左旋转,调整二叉树为平衡二叉树
        if (leftHight() - rightHight() > 1) {
            //当前结点的左子树的右子树高度大于左子树高度--->先左旋转再右旋转
            if (this.left != null && this.left.rightHight() > this.left.leftHight()) {
                //当前结点的左子树进行左旋转
                this.left.leftRoate();
                //当前结点进行右旋转
                rightRoate();
            } else {
                rightRoate();
            }
            return;
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

    //查找要删除的结点
    public AVLNode searchNode(int val) {

        if (val == this.val) {
            return this;
        } else if (val < this.val) {
            return this.left.searchNode(val);
        } else {
            return this.right.searchNode(val);
        }

    }

    //查找要删除结点的父节点
    public AVLNode parent(int val) {

        if ((this.left != null && this.left.val == val) || (this.right != null && this.right.val == val)) {
            return this;
        } else if (this.left != null && this.val > val) {
            return this.left.parent(val);
        } else if (this.right != null && this.val <= val) {
            return this.right.parent(val);
        } else {
            return null;
        }

    }

    //以当前结点为根结点的高度
    public int getHeight() {
        return Math.max(this.left == null ? 0 : this.left.getHeight(), this.right == null ? 0 : this.right.getHeight()) + 1;
    }

    //左子树高度
    public int leftHight() {
        if (this.left == null) {
            return 0;
        } else {
            return this.left.getHeight();
        }
    }

    //右子树高度
    public int rightHight() {
        if (this.right == null) {
            return 0;
        } else {
            return this.right.getHeight();
        }
    }

    //左旋转方法
    public void leftRoate() {
        //创建一个新的结点
        AVLNode temp = new AVLNode(this.val);
        //新的节点的左子树设置成当前结点的左子树
        temp.left = this.left;
        //新节点的右子树设置成当前结点的右子树的左子树
        temp.right = this.right.left;
        //当前结点的值替换为右子节点的值
        this.val = this.right.val;
        //当前结点的右子树设置成当前结点的右子树的右子树
        this.right = this.right.right;
        //当前结点的左子树设置成temp
        this.left = temp;

    }

    //右旋转方法
    public void rightRoate() {
        //创建一个新的结点
        AVLNode temp = new AVLNode(this.val);
        //新的节点的右子树设置成当前结点的右子树
        temp.right = this.right;
        //新节点的左子树设置成当前结点的左子树的右子树
        temp.left = this.left.right;
        //当前结点的值替换为左子节点的值
        this.val = this.left.val;
        //当前结点的左子树设置成当前结点的左子树的左子树
        this.left = this.left.left;
        //当前结点的右子树设置成temp
        this.right = temp;

    }


}
