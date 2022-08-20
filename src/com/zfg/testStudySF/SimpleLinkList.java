package com.zfg.testStudySF;

/**
 * @ClassName SimpleLinkList
 * @Description 单链表
 * @Author zfg
 * @Date 2022/8/19 下午 06:12
 */
public class SimpleLinkList {

    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 4, 6, 7};
        LinkList ll = new LinkList();
        for (int i = 0; i < arr.length; i++) {
            ll.addOder(new SimpleLinkLIstNode(arr[i]));
        }
//        for (int i = 0; i < arr.length; i++) {
//            ll.creatSimpleList(new SimpleLinkLIstNode(arr[i]));
//        }
//        ll.creatSimpleList(null);
        ll.printList1();
//        ll.insertNode(10,7);
        ll.addOder(new SimpleLinkLIstNode(10));
        System.out.println();
        ll.printList1();
        System.out.println();
        System.out.println(ll.getIndex(7));
        System.out.println(ll.getLenth());
        System.out.println("逆序输出:");
        ll.revPrint();
//        ll.delNode(8);
//        ll.delNode(9);
//        ll.delNode(4);
//        ll.delNode(6);
//        ll.delNode(7);
//        ll.delNode(10);
//        ll.delNode(5);
//        System.out.println();
//        ll.printList1();
//        ll.updateNode(6,2);
//        System.out.println();
//        ll.printList1();
//        System.out.println();
//        int count = ll.getNode(10);
//        System.out.println(count);
    }

}
