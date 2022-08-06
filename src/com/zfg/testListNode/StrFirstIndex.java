package com.zfg.testListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName StrFirstIndex
 * @Description 题目:
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 实例:
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * @Author zfg
 * @Date 2022/8/6 上午 10:41
 */
public class StrFirstIndex {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int[] res = getStrIndex(nums, 9);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }

    //查找表法
    public static int[] getStrIndex(int[] nums, int target) {

        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length - 1);
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }
        return res;

    }

}
