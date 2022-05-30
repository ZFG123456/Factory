package com.zfg.testfactory;

/**
 * @ClassName ElectricAdapter
 * @Description 适配器
 * @Author zfg
 * @Date 2022/4/18 下午 04:47
 */
public class ElectricAdapter implements DitectCurrent{

    AlternateCurrent out;

    public ElectricAdapter(AlternateCurrent out) {
        this.out = out;
    }

    @Override
    public String giveDirectCurrent() {
        String m = out.giveAlternateCurrent();
        StringBuffer str = new StringBuffer(m);
        //将交流电转换为直流电
        for(int i=0;i<str.length();i++){
            if (str.charAt(i)=='0'){
                str.setCharAt(i,'1');
            }
        }
        m = new String(str);
        return m;
    }
}
