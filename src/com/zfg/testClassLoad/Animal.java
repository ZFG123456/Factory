package com.zfg.testClassLoad;

/**
 * @ClassName Animal
 * @Description 父类
 * @Author zfg
 * @Date 2022/9/1 下午 04:58
 */
public class Animal {

    public String test = "父类的属性";
    public static String testStatic = "父类的静态属性";

    public static void testStatic() {
        System.out.println("父类的静态方法!" + testStatic);
    }

    public void test() {
        System.out.println("父类的普通方法!" + test);
    }

    static {
        Animal.testStatic();
        System.out.println("父类静态代码块!");
    }

    {
        this.test();
        System.out.println("父类代码块!");
    }

    public Animal() {
        System.out.println("父类的构造方法!");
    }

}
