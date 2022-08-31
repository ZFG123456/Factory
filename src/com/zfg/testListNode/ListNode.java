package com.zfg.testListNode;

/**
 * @ClassName ListNode
 * @Description 链表的结点
 * @Author zfg
 * @Date 2022/7/27 下午 02:16
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
