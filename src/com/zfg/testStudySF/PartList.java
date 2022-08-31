package com.zfg.testStudySF;

import com.zfg.testListNode.ListNode;

/**
 * @ClassName PartList
 * @Description 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * @Author zfg
 * @Date 2022/8/31 下午 06:22
 */
public class PartList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(4);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(5);
        ListNode head5 = new ListNode(2);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        ListNode resNode = partition(head, 3);
        while (resNode != null) {
            System.out.println(resNode);
            resNode = resNode.next;
        }

    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode cur = head;
        ListNode cur1 = smallHead;
        ListNode cur2 = bigHead;
        //小于x的放在samllHead中，大于x的放在bigHead中
        while (cur != null) {
            if (cur.val < x) {
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        //切断最后的连接，保证两个链表的数据真实
//        cur1.next = null;
        cur2.next = null;
        cur1.next = bigHead.next;
        return smallHead.next;
    }

}
