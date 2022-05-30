package com.zfg.testfactory;

/**
 * @ClassName BallPen
 * @Description 圆珠笔类
 * @Author zfg
 * @Date 2022/4/19 上午 10:50
 */
public class BallPen {

    PenCore penCore;
    public void usePenCore(PenCore penCore){
        this.penCore = penCore;
    }
    public void writeWord(String s){
        penCore.writeWord(s);
    }

}
