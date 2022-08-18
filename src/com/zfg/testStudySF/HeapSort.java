package com.zfg.testStudySF;

import java.util.Arrays;

/**
 * @ClassName HeapSort
 * @Description 堆排序
 * 升序用大顶堆,降序用小顶堆
 * @Author zfg
 * @Date 2022/8/16 下午 02:18
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);

    }

    //堆排序
    public static void heapSort(int[] arr) {
        //分步完成
        //第一次调整大顶堆
//        adjustHeap(arr,1, arr.length);
//        System.out.println(Arrays.toString(arr));
        //第二次调整大顶堆
//        adjustHeap(arr,0, arr.length);
//        System.out.println(Arrays.toString(arr));

        int temp = 0;
        //构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        //排序
        for (int i = arr.length - 1; i > 0; i--) {
            //交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
        //输出
        System.out.println(Arrays.toString(arr));

    }

    //将一个数组调整成大顶堆
    //i标识从下往上第一个非叶子结点---arr.lenth/2-1可得
    public static void adjustHeap(int[] arr, int i, int len) {
        //取出当前的值
        int temp = arr[i];
        //i*2+1找左子节点
        for (int j = i * 2 + 1; j < len; j = j * 2 + 1) {
            //左子节点小于右子节点
            if (j + 1 < len && arr[j] < arr[j + 1]) {
                //指向右子节点
                j++;
            }
            //最大的子节点大于父节点
            if (arr[j] > temp) {
                //把较大的值赋予当前结点
                arr[i] = arr[j];
                //继续循环比较
                i = j;
            } else {
                break;
            }
        }
        //将temp值放到调整后的位置
        arr[i] = temp;
    }

}
