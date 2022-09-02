package com.zfg.testStudy;

/**
 * @ClassName TestThread
 * @Description TODO
 * @Author zfg
 * @Date 2022/7/15 下午 03:12
 */
public class TestThread extends Thread {

    //构造方法
    private TestThread() {
    }

    ;
    public static TestThread testThread = new TestThread();

    public static TestThread getTestThread() {
        if (testThread == null) {
            testThread = new TestThread();
        }
        return testThread;
    }

    @Override
    public void run() {
        getTestThread();
    }

    public static void main(String[] args) {
        testThread.start();
        System.out.println(testThread.getName());
    }


}
