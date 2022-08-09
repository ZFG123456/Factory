package com.zfg.testStudySF;

/**
 * @ClassName ArrayQueue
 * @Description 用数组模拟队列
 * @Author zfg
 * @Date 2022/8/9 下午 05:44
 */
public class ArrayQueue {

    //数组最大长度
    private int maxSize;
    //数组的头指针
    private int front;
    //数组的尾指针
    private int rear;
    //数组即模拟的队列
    private int[] arr;

    //初始化数组
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //头指针和尾指针指向-1的位置
        front = -1;
        rear = -1;
    }

    //判断数组是否为空
    public boolean isEmpty(int[] arr) {
        return front == rear;
    }

    //判断数组是否满
    public boolean isFull(int[] arr) {
        return rear == maxSize - 1;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull(arr)) {
            System.out.println("队列已满，无法放入!");
        }
//        rear++;
        arr[++rear] = n;
    }

    //数据出队列
    public int getQueue() {
        if (isEmpty(arr)) {
            System.out.println("队列还没有数据，无法取数据!");
        }
//        front++;
        return arr[++front];
    }

    //查看队列头的数据
    public int getHeadQueue() {

        if (isEmpty(arr)) {
            System.out.println("队列还没有数据，无法查看头数据!");
        }
        return arr[front + 1];

    }

    //展示队列
    public void showQueue() {
        if (isEmpty(arr)) {
            System.out.println("队列还没有数据!");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]=" + arr[i] + "\t");
        }
    }

}
