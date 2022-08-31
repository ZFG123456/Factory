package com.zfg.testStudySF;

import com.zfg.testListNode.ListNode;

/**
 * @ClassName RevPartList
 * @Description 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * @Author zfg
 * @Date 2022/8/31 下午 07:16
 */
public class RevPartList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        ListNode res = reverseBetween(head, 2, 4);
        while (res != null) {
            System.out.println(res);
            res = res.next;
        }

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode leftNode = pre;
        ListNode rightNode = pre;
        if (left > right || head == null) {
            return null;
        }
        for (int i = 0; i < left - 1; i++) {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }
        ListNode part = leftNode.next;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode rightHead = rightNode.next;
        leftNode.next = null;
        rightNode.next = null;
        //翻转
        ListNode resNode = RevList(part);
        leftNode.next = resNode;
        part.next = rightHead;
        return pre.next;
    }

    //翻转链表
    public static ListNode RevList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

}
