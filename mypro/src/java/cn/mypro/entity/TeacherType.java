package cn.mypro.entity;

/**教师类的相关属性
 * Created by MrBread on 2017/7/14.
 */
public class TeacherType {
    String id;
    String name;   //姓名
    String password;   //密码
    String subject;  //科目

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
