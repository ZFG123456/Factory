package com.zfg.testListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName ListRevStack
 * @Description 链表翻转栈实现
 * @Author zfg
 * @Date 2022/8/5 上午 09:37
 */
public class ListRevStack {

    public static void main(String[] args) {

        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(2);
        ListNode headC = new ListNode(3);
        ListNode headD = new ListNode(4);
        ListNode headE = new ListNode(5);
        headA.next = headB;
        headB.next = headC;
        headC.next = headD;
        headD.next = headE;

//        List<Integer> list = listRev(headA);
        List<Integer> list1 = listRev1(headA);
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }

    }

    //链表翻转栈实现
    public static List<Integer> listRev(ListNode head) {

//        if (head==null){
//            return null;
//        }

        List<Integer> list = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode cur = stack.pop();
        ListNode res = cur;
        while (!stack.isEmpty()) {

//            list.add(cur.val);
            ListNode temp = stack.pop();
            cur.next = temp;
            cur = cur.next;

        }
        cur.next = null;
        while (res != null) {
            list.add(res.val);
            res = res.next;
        }

        return list;
    }

    //链表翻转双链表实现
    public static List<Integer> listRev1(ListNode head) {

        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        ListNode newHead = null;
        while (head != null) {

            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;

        }

        while (newHead != null) {

            list.add(newHead.val);
            newHead = newHead.next;

        }

        return list;
    }


}
