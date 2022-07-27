package com.zfg.testStudy;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestTicket
 * @Description TODO
 * @Author zfg
 * @Date 2022/7/16 下午 03:46
 */
public class TestTicket implements Runnable {

    //使用lock锁更加灵活
//    Lock l = new ReentrantLock();
    private volatile int ticketNum = 100;

    @Override
    public synchronized void run() {
//        l.lock();
        long t1 = System.currentTimeMillis();
        //卖票逻辑
        while (ticketNum > 0) {
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum-- + "张票！");
        }
        long t2 = System.currentTimeMillis();

        long time = t2-t1;
        System.out.println("本次抢票总共用时:"+time);
//        l.unlock();

    }

    public static void main(String[] args) {

        TestTicket t1 = new TestTicket();
//        TestTicket t2 = new TestTicket();
//        TestTicket t3 = new TestTicket();


        new Thread(t1, "张三").start();
        new Thread(t1, "李四").start();
        new Thread(t1, "王五").start();

    }

}

//alt+shift+insert竖向修改
