package com.zfg.testStudySF;

import java.util.Arrays;

/**
 * @ClassName ArrBinaryTree
 * @Description 顺序存储二叉树---给定一个数组写出二叉树的遍历结果
 * <p>
 * 二叉树对应数组的公式：左子节点位置是:2*n+1;右子节点位置是:2*n+2;父节点的位置是:(n-1)/2
 * @Author zfg
 * @Date 2022/8/16 上午 09:44
 */
public class ArrBinaryTree {

    public static void main(String[] args) {

        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        arrBinary(arr, 0);

    }

    //创建数组的先序遍历
    public static void arrBinary(int[] arr, int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("数组为空,不能遍历!");
        }
        if (index < arr.length) {
            System.out.print(arr[index] + "->");
        }
        if (2 * index + 1 < arr.length) {
            arrBinary(arr, 2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            arrBinary(arr, 2 * index + 2);
        }

    }

}
