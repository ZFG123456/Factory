package com.zfg.testCompareable;

/**
 * @ClassName User
 * @Description TODO
 * @Author zfg
 * @Date 2022/4/25 下午 07:00
 */
public class User implements Comparable{
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {

        User user = (User) o;
        //按照id从小到大排列对象
        int result = this.getId()-((User) o).getId();
        //按照id从大到小排列对象
        int result1 = ((User) o).getId()-this.getId();
        //按照字典顺序排列
        int result2 = this.getName().compareTo(((User) o).getName());
        //按照名字长度排序
        int result3 = this.getName().length()-((User) o).getName().length();
        //如果名字长度相同按照字典顺序排列
        if(result3==0){
            //如果名字相同按照id从小到大排列对象
            if(this.getName().equals(((User) o).getName())){
                return result;
            }
            return result2;
        }

        return result3;
    }
}
