package com.zfg.testStudy;

/**
 * @ClassName TestRunable
 * @Description TODO
 * @Author zfg
 * @Date 2022/7/16 上午 10:33
 */
public class TestRunable extends Thread {

    private Thread t;
    private String tName;

    public TestRunable() {

    }

    public TestRunable(String name) {

        tName = name;
        System.out.println("构造器声明:" + tName);

    }


    public static void main(String[] args) {

        TestRunable t1 = new TestRunable("Mike-1");
        t1.start();
        TestRunable t2 = new TestRunable("Mike-2");
        t2.start();

    }

    @Override
    public void start() {

        System.out.println(tName + "开始工作");
        if (t == null) {
            t = new Thread(this, tName);
        }
        t.start();

    }

    @Override
    public void run() {

        System.out.println("开始运行:" + tName);
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("线程名称:" + tName + "," + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("中断!");
        }
        System.out.println(tName + "结束!");
    }
}
