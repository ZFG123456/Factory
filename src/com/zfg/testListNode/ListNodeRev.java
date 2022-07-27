package com.zfg.testListNode;

import java.util.Stack;

/**
 * @ClassName ListNodeRev
 * @Description 链表的翻转
 * @Author zfg
 * @Date 2022/7/27 下午 02:18
 */
public class ListNodeRev {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(ListNodeRev.NodeRev(head));
//        System.out.println(ListNodeRev.NodeRev1(head));
    }

    /***
     * @Description: //栈的方式实现
     * @MethodName: NodeRev
     * @Param: []
     * @return: com.zfg.testListNode.ListNode
     * @Author: zfg
     * @Date: 2022/7/27 下午 02:19
     */
    public static ListNode NodeRev(ListNode head) {

        Stack<ListNode> stack = new Stack<>();

        //将链表入栈
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        //对空链表处理
        if (stack.isEmpty()) {
            return null;
        }

        ListNode fistNode = stack.pop();
        ListNode resultNode = fistNode;

        //出栈,建立新的链表
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            fistNode.next = temp;
            fistNode = fistNode.next;
        }

        fistNode.next = null;

        return resultNode;

    }

    /***
     * @Description: //双链表实现
     * @MethodName: NodeRev1
     * @Param: [head]
     * @return: com.zfg.testListNode.ListNode
     * @Author: zfg
     * @Date: 2022/7/27 下午 02:27
     */
    public static ListNode NodeRev1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        while (head != null) {
            //保存下一个结点
            ListNode temp = head.next;
            //翻转，即将后一个结点连接到前一个结点
            head.next = newHead;
            //将新链表的头结点不断更新
            newHead = head;
            //操纵的head结点不断后移完成操作
            head = temp;
        }


        return newHead;
    }

}
