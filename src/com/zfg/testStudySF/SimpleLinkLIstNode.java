package com.zfg.testStudySF;

/**
 * @ClassName SimpleLinkLIstNode
 * @Description 单链表结点
 * @Author zfg
 * @Date 2022/8/19 下午 06:13
 */
public class SimpleLinkLIstNode {

    int data;
    SimpleLinkLIstNode next;

    public SimpleLinkLIstNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SimpleLinkLIstNode{" +
                "data=" + data +
                '}';
    }

    //单链表的添加
    public void addNode(SimpleLinkLIstNode node) {
        if (node == null) {
            return;
        } else {
            SimpleLinkLIstNode temp = this;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    //单链表的添加
    public void addNode1(SimpleLinkLIstNode node) {
        if (node == null) {
            return;
        } else {
            SimpleLinkLIstNode temp = this;
            while (true) {
                if (temp == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    //单链表的添加按顺序
    public void addOder(SimpleLinkLIstNode node) {

        SimpleLinkLIstNode temp = this;
        boolean flag = false;
        while (true) {
            //链表最后
            if (temp.next == null) {
                break;
            }
            if (temp.next.data > node.data) {
                break;
            } else if (temp.next.data == node.data) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            node.next = temp.next;
            temp.next = node;
        } else {
            System.out.println("插入不成功，已经存在一样的数字!");
        }
    }

    //在单链表的某个位置后添加一个结点
    public void inserNode(int data, int val) {
        //创建结点
        SimpleLinkLIstNode node = new SimpleLinkLIstNode(data);
        SimpleLinkLIstNode temp = this;
        SimpleLinkLIstNode tempNode = null;
        //判断插入的位置
        while (temp.next != null) {
            tempNode = temp.next;
            if (val == temp.data) {
                temp.next = node;
                node.next = tempNode;
                return;
            } else {
                temp = temp.next;
            }
            if (temp.next == null) {
                temp.next = node;
                return;
            }
        }
        if (this.next == null) {
            temp.next = node;
        }
    }

    //删除结点
    public void delNode(int data) {
        SimpleLinkLIstNode temp = this;
        //只有头结点的情况
        if (temp.next == null && temp.data == data) {
            temp = null;
        }
        //中间结点的情况
        if (temp.next != null) {
            while (temp.next != null) {
                if (temp.next.data == data) {
                    SimpleLinkLIstNode tempNode = temp.next.next;
                    temp.next = tempNode;
                    return;
                }
                temp = temp.next;
            }
        }
    }

    //删除结点
    public void delNode1(int data) {
        SimpleLinkLIstNode pre = new SimpleLinkLIstNode(-1);
        pre.next = this;
        SimpleLinkLIstNode cur = this;
        boolean flag = false;
        while (true) {
            if (pre.next == null) {
                break;
            }
            while (cur != null) {
                if (cur.next.data == data) {
                    flag = true;
                    break;
                }
                cur = cur.next;
            }
        }
        if (flag) {
            cur = cur.next.next;
        }
    }

    //查找单链表的倒数第index个结点
    public SimpleLinkLIstNode getIndex(int index) {
        SimpleLinkLIstNode cur = this;
        int len = cur.getLenth();
        if (index <= 0 || index > len) {
            return null;
        }
        for (int i = 0; i < len - index; i++) {
            cur = cur.next;
        }
        return cur;

    }

    //单链表的长度
    public int getLenth() {
        SimpleLinkLIstNode cur = this;
        if (cur == null) {
            return 0;
        }
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //修改结点
    public void updateNode(int data, int val) {
        SimpleLinkLIstNode temp = this;
        while (temp != null) {
            if (temp.data == data) {
                temp.data = val;
                return;
            }
            temp = temp.next;
        }
    }

    //查找某个结点并返回其下标
    public int getNode(int data) {
        int count = 0;
        SimpleLinkLIstNode temp = this;
        while (temp != null) {
            if (temp.data == data) {
                return count;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }

    //遍历单链表
    public void printList(SimpleLinkLIstNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head + "->");
        printList(head.next);
    }

    //遍历单链表
    public void printList1(SimpleLinkLIstNode head) {
        SimpleLinkLIstNode temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.print(temp + "->");
            temp = temp.next;
        }
    }

}
