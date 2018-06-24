package cn.mypro.entity;

/**
 * 班级类
 * Created by MrBread on 2017/7/17.
 */
public class ClassType {
    String id;    //班级号
    int membernums;   //班级总人数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMembernums() {
        return membernums;
    }

    public void setMembernums(int membernums) {
        this.membernums = membernums;
    }
}
