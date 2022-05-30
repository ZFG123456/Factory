package com.zfg.testFanXing;

/**
 * @ClassName User
 * @Description 利用泛型学习通配符
 * @Author zfg
 * @Date 2022/4/23 下午 06:48
 */
public class User<T,V> {

    private T age;
    private V name;

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public V getName() {
        return name;
    }

    public void setName(V name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name=" + name +
                '}';
    }
}
