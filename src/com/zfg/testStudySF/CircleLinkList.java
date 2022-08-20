package com.zfg.testStudySF;

import org.jetbrains.annotations.NotNull;

/**
 * @ClassName CircleLinkList
 * @Description 环形链表解决约瑟夫问题
 * @Author zfg
 * @Date 2022/8/20 下午 04:05
 */
public class CircleLinkList {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 11, 12};
        CircleNode res = creatList1(arr);
        circleprint2(res);
        int len = getLen(res);
        System.out.println();
        System.out.println(len);
        System.out.println(getEndNode(res).val);
        YueSeFu(5, 2, res);
    }

    static CircleNode first = null;

    //创建环形链表
    public static void creatList(int @NotNull [] arr) {

        CircleNode cur = null;

        for (int i = 0; i < arr.length; i++) {
            CircleNode node = new CircleNode(arr[i]);
            if (i == 0) {
                first = node;
                first.next = first;
                cur = first;
            } else {
                cur.next = node;
                node.next = first;
                cur = node;
            }
        }

    }

    //创建环形链表
    public static CircleNode creatList1(int @NotNull [] arr) {
        CircleNode cur = null;
        CircleNode first = null;
        for (int i = 0; i < arr.length; i++) {
            CircleNode node = new CircleNode(arr[i]);
            if (i == 0) {
                first = node;
                first.next = first;
                cur = first;
            } else {
                cur.next = node;
                node.next = first;
                cur = node;
            }
        }
        return first;
    }

    //遍历循环链表
    public static void circleprint() {

        if (first == null) {
            return;
        } else {
            CircleNode temp = first;
            while (temp != null) {
                System.out.print(temp.val + "\t");
                temp = temp.next;
                if (temp == first) {
                    break;
                }
            }
        }

    }

    //遍历循环链表
    public static void circleprint1() {
        if (first == null) {
            return;
        } else {
            CircleNode temp = first;
            while (true) {
                System.out.print(temp.val + "\t");
                if (temp.next == first) {
                    break;
                }
                temp = temp.next;
            }

        }
    }

    //遍历循环链表
    public static void circleprint2(CircleNode first) {
        if (first == null) {
            return;
        } else {
            CircleNode temp = first;
            while (true) {
                System.out.print(temp.val + "\t");
                if (temp.next == first) {
                    break;
                }
                temp = temp.next;
            }

        }
    }

    //循环链表的长度
    public static int getLen(CircleNode first) {
        if (first == null) {
            return 0;
        } else {
            CircleNode cur = first;
            int size = 0;
            while (true) {
                size++;
                if (cur.next == first) {
                    break;
                }
                cur = cur.next;
            }
            return size;
        }
    }

    //返回循环链表的最后一个结点
    public static CircleNode getEndNode(CircleNode first) {
        if (first == null) {
            return null;
        } else {
            CircleNode temp = first;
            while (true) {
                if (temp.next == first) {
                    return temp;
                }
                temp = temp.next;
            }
        }
    }

    //约瑟夫问题(报数:共有m个人围成一个圈，要求每数n个人(包括自己)就报数，按照这个方式来报数)
    public static void YueSeFu(int startNo, int countNum, CircleNode first) {
        if (first == null || startNo < first.val || startNo > getEndNode(first).val) {
            return;
        }
        //创建辅助指针指向最后一个结点
        CircleNode helper = getEndNode(first);
        //创建辅助指针指向第一个结点
        CircleNode cur = first;
        for (int i = 0; i < startNo - cur.val; i++) {
            first = first.next;
            helper = helper.next;
        }
        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.print(first.val + "\t");
            first = first.next;
            helper.next = first;
        }
        System.out.print(helper.val);
    }

}

