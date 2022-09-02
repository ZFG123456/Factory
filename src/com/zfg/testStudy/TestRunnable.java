package com.zfg.testStudy;

/**
 * @ClassName TestRunnable
 * @Description TODO
 * @Author zfg
 * @Date 2022/7/16 下午 12:14
 */
public class TestRunnable implements Runnable {

    public static void main(String[] args) {

//        Runnable runnable = new TestRunnable();
        TestRunnable runnable = new TestRunnable();
        Thread t = new Thread(runnable);
        t.start();

    }

    @Override
    public void run() {

        System.out.println("1111");
    }
}
