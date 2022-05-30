package com.zfg.testFanXing;

/**
 * @ClassName testUser
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/23 下午 06:50
 */
public class testUser {

    public static void main(String[] args) {
        User<Integer,String> user = new User();
        user.setAge(18);
        user.setName("张三");
        fun(user);
        fun1(user);

    }

    /***
    * @Description: //不加通配符的方法，耦合度高，改变12行的数据类型方法也需要相应的改变
    * @MethodName: fun
    * @Param: [user]
    * @return: void
    * @Author: zfg
    * @Date: 2022/4/23 下午 06:53
    */
    public static void  fun(User<Integer,String> user){
        System.out.println(user.toString());
    }

    /***
    * @Description: //加通配符的方法--'?'
    * @MethodName: fun1
    * @Param: [user]
    * @return: void
    * @Author: zfg
    * @Date: 2022/4/23 下午 06:57
    */
    public static void  fun1(User<?,?> user){
        System.out.println(user.toString());
    }

}
