package com.zfg.testListNode;


import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Description 排序算法
 *
 * 快排思想参考:
 * https://blog.csdn.net/weixin_43586713/article/details/119820797
 *
 * @Author zfg
 * @Date 2022/7/28 下午 12:56
 */
public class BubbleSort {

    public static void main(String[] args) {

//        int[] arr = {48, 62, 35, 77, 55, 14, 35, 98};
//        maoPao(arr);
//        System.out.println("***********************");
//        xuanZe(arr);
//        System.out.println("***********************");
//        chaRu(arr);
//        System.out.println("***********************");
//        int[] arr1 = {14, 35, 48, 62, 77, 98, 100};
//        System.out.println("要查找的元素下标为:" + erFen(arr1, 100));
        int[] nums = {11, 24, 5, 32, 50, 34, 54, 76};
        System.out.println("排序前:" + Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println("排序后:" + Arrays.toString(nums));
    }

    /***
     * @Description: //冒泡排序
     * 两两比较小的交换到前面
     * @MethodName: maoPao
     * @Param: [arr]
     * @return: int[]
     * @Author: zfg
     * @Date: 2022/7/28 下午 01:33
     */
    public static int[] maoPao(int[] arr) {

        int len = arr.length;

        //将数据两两比较，小的放前面大的放后面
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            //每趟排序的结果打印
            for (int m = 0; m < len; m++) {
                System.out.print(arr[m] + " ");
            }
            System.out.println();

        }

        return arr;
    }

    /***
     * @Description: //选择排序
     * 每次找到最小值交换到前面
     * @MethodName: xuanZe
     * @Param: [arr]
     * @return: int[]
     * @Author: zfg
     * @Date: 2022/7/28 下午 01:45
     */
    public static int[] xuanZe(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            //找最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            //交换位置，将最小值放在最前面
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

            //每趟排序的结果打印
            for (int m = 0; m < arr.length; m++) {
                System.out.print(arr[m] + " ");
            }
            System.out.println();

        }

        return arr;
    }

    /***
     * @Description: //插入排序
     * @MethodName: chaRu
     * 找到小的数插入到前面
     * @Param: [arr]
     * @return: int[]
     * @Author: zfg
     * @Date: 2022/7/28 下午 01:52
     */
    public static int[] chaRu(int[] arr) {

        //从下标为1的元素开始插入，下标为0的元素只有一个,所以默认有序
        for (int i = 1; i < arr.length; i++) {

            //记录要插入的数据
            int temp = arr[i];

            int j = i;
            //从已经排序的序列最右边的开始比较，找到比其小的数
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = temp;
            }

            //每趟排序的结果打印
            for (int m = 0; m < arr.length; m++) {
                System.out.print(arr[m] + " ");
            }
            System.out.println();

        }

        return arr;
    }

    /***
     * @Description: //二分查找算法
     * @MethodName: erFen
     * @Param: [arr, target]
     * @return: int
     * @Author: zfg
     * @Date: 2022/7/28 下午 02:42
     */
    public static int erFen(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    /***
     * @Description: //快速排序
     * @MethodName: quickSort
     * @Param: [nums, start, end]
     * @return: void
     * @Author: zfg
     * @Date: 2022/8/29 下午 04:46
     */
    public static void quickSort(int[] nums, int start, int end) {

        if (start > end) {
            return;
        }

        int i, j, base;
        i = start;
        j = end;
        base = nums[start];
        while (i < j) {
            while (i < j && nums[j] >= base) {
                j--;
            }
            while (i < j && nums[i] <= base) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, start, i);
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);

    }

    //快排的用的工具方法交换
    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
