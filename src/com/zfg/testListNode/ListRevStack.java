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
        ListNode headF = new ListNode(6);
        headA.next = headB;
        headB.next = headC;
        headC.next = headD;
        headD.next = headE;
        headE.next = headF;

//        List<Integer> list = listRev(headA);
//        List<Integer> list1 = listRev1(headA);
        List<Integer> list2 = listZiDingRev(headA, 2, 5);
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");
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

    //单链表指定区间翻转
    public static List<Integer> listZiDingRev(ListNode head, int left, int right) {

        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        //翻转后的新链表
        ListNode newHead = null;
        //构建虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        //利用头结点的优势可以避免复杂的头结点的处理
        dummyNode.next = head;
        //头指针指向虚拟头结点
        ListNode pre = dummyNode;
        //1.截取局部链表
        //将头指针移动到left的左边前一个结点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //将头指针移动到left结点
        ListNode leftNode = pre.next;
        //将尾指针移动到right的结点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        //将剩余的链表进行保存
        ListNode cur = rightNode.next;
        //2.切断连接
        pre.next = null;
        rightNode.next = null;
        //3.翻转局部链表
        ListNode res = leftNode;
        while (res != null) {
            ListNode temp = res.next;
            res.next = newHead;
            newHead = res;
            res = temp;
        }
        //链接原来的结点
        pre.next = rightNode;
        leftNode.next = cur;

        while (dummyNode.next != null) {
            list.add(dummyNode.next.val);
            dummyNode = dummyNode.next;
        }

        return list;

    }


}
