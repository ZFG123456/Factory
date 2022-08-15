package com.zfg.testStudySF;

/**
 * @ClassName FenZhi
 * @Description 分治算法解决汉诺塔问题
 * 总体思想将整体分为几个小的部分，依次递归解决小的部分
 * 1.如果只有一盘子，直接移动返回
 * 2.如果有大于1个盘子，将盘子看做两部分，一部分最下面的一个盘子，一部分是上面的所有盘子
 * 3.不断递归移动实现
 * @Author zfg
 * @Date 2022/8/13 下午 12:32
 */
public class FenZhi {

    public static void main(String[] args) {

        HanNuoTower(5, 'A', 'B', 'C');

    }

    //汉诺塔问题分治算法的实现
    public static void HanNuoTower(int nums, char a, char b, char c) {

        if (nums == 1) {
            System.out.println("第" + nums + "个盘子从" + a + "->" + c);
        } else if (nums <= 0) {
            System.out.println("没有盘子可以移动!");
        } else {
            //将上面的所有盘子从A->B
            HanNuoTower(nums - 1, a, c, b);
            //最下面的盘从A->C
            System.out.println("第" + nums + "个盘子从" + a + "->" + c);
            //将B->C
            HanNuoTower(nums - 1, b, a, c);
        }

    }

}
