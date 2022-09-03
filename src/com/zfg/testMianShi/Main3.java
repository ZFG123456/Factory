package com.zfg.testMianShi;

import java.util.Scanner;

/**
 * @ClassName Main3
 * @Description 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、蓝色、白色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,2,2,1,1]
 * <p>
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,2,1]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 * @Author zfg
 * @Date 2022/9/2 上午 09:26
 */
public class Main3 {

    public static void main(String[] args) {

//        int[] nums = {2,0,2,1,1,0};
//        int[] nums = {2,0,1};
//        int[] nums = {0};
        int[] nums = {0, 2, 0, 2, 1, 3, 1, 3, 0};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }

    }

    public static void sortColors(int[] nums) {
        int len = nums.length;
        int m = 0;
        for (int i = 0; i < len; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[m];
                nums[m] = temp;
                ++m;
            }
        }

        for (int i = m; i < len; ++i) {
            if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[m];
                nums[m] = temp;
                ++m;
            }
        }

        for (int i = m; i < len; ++i) {
            if (nums[i] == 3) {
                int temp = nums[i];
                nums[i] = nums[m];
                nums[m] = temp;
                ++m;
            }
        }
    }

}
