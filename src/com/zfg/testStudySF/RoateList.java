package com.zfg.testStudySF;

import com.zfg.testListNode.ListNode;

/**
 * @ClassName RoateList
 * @Description 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 输入：head = [1,2,3,4,5], k = 2 输出：[4,5,1,2,3]
 * @Author zfg
 * @Date 2022/8/31 上午 11:36
 */
public class RoateList {

    static ListNode head = null;
    static ListNode cur = null;

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            if (head == null && i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = cur.next;
            }
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("旋转后的链表!");
        ListNode resNode = rotateRight(head, 2);
        while (resNode != null) {
            System.out.println(resNode);
            resNode = resNode.next;
        }

    }

    public static ListNode rotateRight(ListNode head, int k) {
        //处理特殊情况
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        //链表长度n,iter指向链表的最后一个位置
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        //add是新链表最后的结点元素位置
        int add = n - k % n;
        //当需要翻转的元素是链表的头部，不需要翻转
        if (add == n) {
            return head;
        }
        iter.next = head;
        //新的链表连接
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

}
