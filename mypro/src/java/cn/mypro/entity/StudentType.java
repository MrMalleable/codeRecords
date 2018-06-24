package cn.mypro.entity;

/**
 * 学生类
 * Created by MrBread on 2017/7/12.
 * @author MrBread
 */
public class StudentType {
    String id;    //学号
    String name;    //姓名
    String password;   //密码,默认密码222222
    int sex;   //(0代表男，1d代表女)
    int age;   //年龄
    String email;  //常用邮箱
    String phonenumber;  //手机号码
    String in_which_class;//所在班级

    public String getIn_which_class() {
        return in_which_class;
    }

    public void setIn_which_class(String in_which_class) {
        this.in_which_class = in_which_class;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
