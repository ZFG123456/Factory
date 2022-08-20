package com.zfg.testStudySF;

import java.util.Stack;

/**
 * @ClassName LinkList
 * @Description 操作单链表
 * @Author zfg
 * @Date 2022/8/19 下午 06:16
 */
public class LinkList {

    private SimpleLinkLIstNode head;

    //单链表的添加
    public void creatSimpleList(SimpleLinkLIstNode node) {
        if (head == null) {
            head = node;
        } else {
            head.addNode(node);
        }
    }

    //单链表的添加按顺序
    public void addOder(SimpleLinkLIstNode node) {
        if (head == null) {
            head = node;
        } else {
            head.addOder(node);
        }
    }

    //查找单链表的倒数第index个结点
    public SimpleLinkLIstNode getIndex(int index) {
        if (head == null) {
            return null;
        } else {
            return head.getIndex(index);
        }
    }

    //单链表的长度
    public int getLenth() {
        return head.getLenth();
    }

    //在单链表的某个位置后添加一个结点
    public void insertNode(int data, int val) {
        if (head == null) {
            SimpleLinkLIstNode node = new SimpleLinkLIstNode(data);
            head = node;
        } else {
            head.inserNode(data, val);
        }
    }

    //单链表的逆序输出(Stack)
    public void revPrint() {

        if (head == null) {
            return;
        } else {
            Stack<SimpleLinkLIstNode> stacks = new Stack<>();
            //入栈
            while (head != null) {
                stacks.push(head);
                head = head.next;
            }
            while (!stacks.isEmpty()) {
                System.out.print(stacks.pop() + "->");
            }
        }

    }

    //删除结点
    public void delNode(int data) {
        if (head == null) {
            return;
            //删除头结点的情况
        } else if (head != null && head.data == data) {
            head = null;
        } else {
            head.delNode(data);
        }
    }

    //修改结点
    public void updateNode(int data, int val) {
        if (head == null) {
            return;
        } else {
            head.updateNode(data, val);
        }
    }

    //查找某个结点并返回其下标
    public int getNode(int data) {
        if (head == null) {
            return -1;
        } else {
            return head.getNode(data);
        }
    }

    //遍历单链表
    public void printList() {
        if (head == null) {
            System.out.println("链表为空!");
        } else {
            head.printList(head);
        }

    }

    //遍历单链表
    public void printList1() {
        if (head == null) {
            System.out.println("链表为空!");
        } else {
            head.printList1(head);
        }
    }

}
