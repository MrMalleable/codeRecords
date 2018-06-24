package cn.stuapp.entity;

/**
 * 创建一个学生类，属性和数据库设置的相同
 * Created by MrBread on 2017/7/28.
 */
public class StudentType {
    String stuid; //学号
    String username;  //用户名
    String sex;  //性别
    String academy; //学院
    String class_in; //所属班级
    String pwd;   //密码
    String pwd_confirm;  //确认密码
    String tel;  //手机号码
    String contact; //紧急联系人
    String email;  //邮箱
    String qq;  //QQ号码
    String address;  //家庭住址

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getClass_in() {
        return class_in;
    }

    public void setClass_in(String class_in) {
        this.class_in = class_in;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //确认密码和密码时一样的
    public String getPwd_confirm() {
        return pwd;
    }

    public void setPwd_confirm() {
        this.pwd_confirm = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
