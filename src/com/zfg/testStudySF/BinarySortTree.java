package com.zfg.testStudySF;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinarySortTree
 * @Description 二叉排序树
 * @Author zfg
 * @Date 2022/8/18 下午 03:59
 */
public class BinarySortTree {

    public static void main(String[] args) {

        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        List<SortNode> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            SortNode temp = new SortNode(arr[i]);
            nodes.add(temp);
        }
        SortTree st = new SortTree();
        for (SortNode data : nodes) {
            st.add(data);
        }
        st.preOder();
        System.out.println();
        st.cenOder();
        System.out.println("删除节点:");
        st.delNode(3);
        st.cenOder();
        System.out.println();
        st.preOder();
    }

}
