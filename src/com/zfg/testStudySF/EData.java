package com.zfg.testStudySF;

/**
 * @ClassName EData
 * @Description 两顶点边的关系(克鲁斯卡尔算法)
 * @Author zfg
 * @Date 2022/8/14 下午 06:56
 */
public class EData {

    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    //

    //输出
    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
