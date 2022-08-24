package com.zfg.testStudySF;

import com.zfg.testListNode.ListNode;

/**
 * @ClassName AddOderList
 * @Description 合并两个有序链表
 * @Author zfg
 * @Date 2022/8/21 下午 07:11
 */
public class AddOderList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        list1.next = node2;
        node2.next = node3;

        ListNode list2 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        list2.next = node4;
        node4.next = node5;

        ListNode res = mergeTwoLists(list1, list2);
        printList(res);

    }

    //正常方法
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        } else {
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    temp.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    temp.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                temp = temp.next;
            }
            temp.next = list1 == null ? list2 : list1;
            return res.next;
        }
    }

    //递归方法
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    //遍历单链表
    public static void printList(ListNode list) {
        if (list == null) {
            System.out.println("链表为空!");
        } else {
            ListNode cur = list;
            while (cur != null) {
                System.out.println(cur.val);
                cur = cur.next;
            }
        }
    }

}
