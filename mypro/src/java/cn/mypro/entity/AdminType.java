package cn.mypro.entity;

import java.util.Date;

/**管理员类
 * Created by MrBread on 2017/7/12.
 */
public class AdminType {
    String name;  //用户名
    String password;  //密码
    Date lastdate;  //最后一次登录日期

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

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }
}
