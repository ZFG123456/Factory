package com.zfg.testfactory;

/**
 * @ClassName test4
 * @Description 工厂模式测试
 * @Author zfg
 * @Date 2022/4/19 上午 10:52
 */
public class test4 {

    public static void main(String[] args) {
        //笔芯
        PenCore penCore;
        //笔芯构造者
        CreatorPenCore creatorPenCore;
        //圆珠笔
        BallPen ballPen = new BallPen();
        creatorPenCore = new RedCoreCreator();
        penCore = creatorPenCore.getPenCore();
        ballPen.usePenCore(penCore);
        ballPen.writeWord("你好很高兴认识你!");
        creatorPenCore = new BlueCoreCreator();
        penCore = creatorPenCore.getPenCore();
        ballPen.usePenCore(penCore);
        ballPen.writeWord("nice to meet you!");
        creatorPenCore = new BlackCoreCreator();
        penCore = creatorPenCore.getPenCore();
        ballPen.usePenCore(penCore);
        ballPen.writeWord("how are you!");

    }

}
