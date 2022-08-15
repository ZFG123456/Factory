package com.zfg.testStudySF;

import java.util.*;

/**
 * @ClassName TanXin
 * @Description 贪心算法解决集合覆盖问题
 * @Author zfg
 * @Date 2022/8/13 下午 05:12
 */
public class TanXin {

    public static void main(String[] args) {

        //创建电台
        Map<String, Set<String>> broadCast = new HashMap<>();
        Set<String> k1 = new HashSet<>();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");
        Set<String> k2 = new HashSet<>();
        k2.add("广州");
        k2.add("北京");
        k2.add("深圳");
        Set<String> k3 = new HashSet<>();
        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");
        Set<String> k4 = new HashSet<>();
        k4.add("上海");
        k4.add("天津");
        Set<String> k5 = new HashSet<>();
        k5.add("杭州");
        k5.add("大连");
        broadCast.put("k1", k1);
        broadCast.put("k2", k2);
        broadCast.put("k3", k3);
        broadCast.put("k4", k4);
        broadCast.put("k5", k5);

        //创建需要覆盖的全部电台城市集合
        Set<String> allAreas = new HashSet<>();
        for (String data : k1) {
            allAreas.add(data);
        }
        for (String data : k2) {
            allAreas.add(data);
        }
        for (String data : k3) {
            allAreas.add(data);
        }
        for (String data : k4) {
            allAreas.add(data);
        }
        for (String data : k5) {
            allAreas.add(data);
        }

        //创建一个集合存放选择的电台集合
        List<String> selectList = new ArrayList<>();
        //定义一个临时集合，存放遍历过程中电台与allAreas的交集的部分
        Set<String> tempSet = new HashSet<>();
        //定义一个maxKey标识当前能未能覆盖的最大电台的key，若不为null则加入selectList中
        String maxKey = null;
        while (allAreas.size() != 0) {
            //清空maxKey
            maxKey = null;
            //取出对应的key标识当前的电台覆盖数，然后比较最大赋予maxKey
            for (String key : broadCast.keySet()) {
                //清空tempSet
                tempSet.clear();
                Set<String> areas = broadCast.get(key);
                tempSet.addAll(areas);
                //求出tempSet和allAreas的交集并赋值给tempSet
                tempSet.retainAll(allAreas);
                //如果当前的集合交集的数量大于maxKey指向的集合的数量多,将maxKey赋予最大值
                //贪心算法的核心
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadCast.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            //如果maxKey!=null,就加入selectList
            if (maxKey != null) {
                selectList.add(maxKey);
                //将已加入的集合从allAreas中清除
                allAreas.removeAll(broadCast.get(maxKey));
            }
        }

        System.out.println("选择后的电台是:" + selectList);

    }

}
