package com.zfg.testStudySF;

/**
 * @ClassName HuffNode
 * @Description 哈夫曼编码树
 * @Author zfg
 * @Date 2022/8/16 下午 05:51
 */
public class HuffNode implements Comparable<HuffNode> {

    //存放数据
    Byte data;
    //权值(字符出现的次数)
    Integer weight;
    HuffNode left;
    HuffNode right;

    public HuffNode(Byte data, Integer weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(HuffNode o) {
        //从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "HuffNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //先序遍历
    public void preOder() {
        System.out.print(this + "->");
        if (this.left != null) {
            this.left.preOder();
        }
        if (this.right != null) {
            this.right.preOder();
        }
    }
}
