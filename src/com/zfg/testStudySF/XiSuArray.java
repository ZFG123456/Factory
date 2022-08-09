package com.zfg.testStudySF;

/**
 * @ClassName XiSuArray
 * @Description 稀疏数组与数组的转化
 * @Author zfg
 * @Date 2022/8/9 下午 04:41
 */
public class XiSuArray {

    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        printArr(arr);
        System.out.println("转化为的稀疏数组为:");
//        getXiSu(arr);
        printArr(getXiSu(arr));
        System.out.println("转化为的数组为:");
        printArr(getShuZu(getXiSu(arr)));
    }

    //打印数组
    public static void printArr(int[][] arr) {
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    //数组转化为稀疏数组
    //1.遍历数组，取到有效数值的个数sum
    public static int[][] getXiSu(int[][] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2.确定稀疏数组的行为sum+1和列为3
        int[][] array = new int[sum + 1][3];
        //3.转化稀疏数组
        array[0][0] = arr.length;
        array[0][1] = arr.length;
        array[0][2] = sum;
        //遍历数组存放到稀疏数组中
        //计数器记录非零的个数
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    array[count][0] = i;
                    array[count][1] = j;
                    array[count][2] = arr[i][j];
                }
            }
        }
        return array;
    }

    //稀疏数组转化为数组
    //1.创建数组根据稀疏数组的第0行的数据
    public static int[][] getShuZu(int[][] array) {

        int[][] arr = new int[array[0][0]][array[0][1]];
        //2.根据稀疏数组的剩下的行的值赋值给数组
        for (int i = 1; i < array.length; i++) {
            arr[array[i][0]][array[i][1]] = array[i][2];
        }
        //3.转化为数组
        return arr;
    }

}
