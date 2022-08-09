package com.zfg.testStudySF;

import java.util.Scanner;

/**
 * @ClassName testArrayQueue
 * @Description 用数组模拟队列
 * @Author zfg
 * @Date 2022/8/9 下午 06:12
 */
public class testArrayQueue {

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(3);
        boolean loop = true;
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加队列");
            System.out.println("g(get):取出队列数据");
            System.out.println("h(head):取出队列头数据");
            System.out.println("e(exit):退出");

            key = sc.next().charAt(0);

            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数:");
                    int vaule = sc.nextInt();
                    arrayQueue.addQueue(vaule);
                    break;
                case 'g':
                    int res = arrayQueue.getQueue();
                    System.out.println("取出的数据是:" + res);
                    break;
                case 'h':
                    int head = arrayQueue.getHeadQueue();
                    System.out.println("取出的头数据是:" + head);
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    System.out.println("程序退出!");
                    break;
                default:
                    System.out.println("输入错误!");
                    break;
            }
        }

    }

}
