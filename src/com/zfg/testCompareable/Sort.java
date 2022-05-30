package com.zfg.testCompareable;

import java.util.Arrays;

/**
 * @ClassName Sort
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/25 下午 07:04
 */
public class Sort {

    public static void main(String[] args) {

        User[] u = {new User(5,"张三"),new User(1,"李四李四"),new User(3,"王五王五"),new User(2,"张三")};
//        Arrays.sort(u);
        Arrays.sort(u,new MyComparetor());
        System.out.println(Arrays.toString(u));
    }

}
