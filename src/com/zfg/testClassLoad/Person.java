package com.zfg.testClassLoad;

/**
 * @ClassName Person
 * @Description 子类
 * @Author zfg
 * @Date 2022/9/1 下午 04:58
 */
public class Person extends Animal {

    public String test = "子类的属性";
    public static String testStatic = "子类的静态属性";

    public static void testStatic() {
        System.out.println("子类的静态方法!" + testStatic);
    }

    public void test1() {
        System.out.println("子类的普通方法!" + test);
    }

    static {
        Person.testStatic();
        System.out.println("子类静态代码块!");
    }

    {
        this.test1();
        System.out.println("子类代码块!");
    }

    public Person() {
        System.out.println("子类的构造方法!");
    }

}
