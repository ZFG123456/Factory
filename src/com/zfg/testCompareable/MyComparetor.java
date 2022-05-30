package com.zfg.testCompareable;

import java.util.Comparator;

/**
 * @ClassName MyComparetor
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/25 下午 07:33
 */
public class MyComparetor implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {

        //按照id从小到大排列对象
        int result = o1.getId()-o2.getId();
        //按照id从大到小排列对象
        int result1 = o2.getId()-o1.getId();
        //按照字典顺序排列
        int result2 = o1.getName().compareTo(o2.getName());
        //按照名字长度排序
        int result3 = o1.getName().length()-o2.getName().length();
        //如果名字长度相同按照字典顺序排列
        if(result3==0){
            //如果名字相同按照id从小到大排列对象
            if(o1.getName().equals(o2.getName())){
                return result;
            }
            return result2;
        }

        return result3;

    }
}
