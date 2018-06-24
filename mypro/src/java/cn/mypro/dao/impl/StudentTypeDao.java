package cn.mypro.dao.impl;

import cn.mypro.dao.IStudentTypeDao;
import cn.mypro.entity.StudentType;
import cn.mypro.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员对学生信息进行操作的dao
 * Created by MrBread on 2017/7/12.
 * @author MrBread
 * @date 2017-7-12
 */
public class StudentTypeDao implements IStudentTypeDao{

    @Override
    public void save(StudentType studentType) {
        String id=studentType.getId();
        String name=studentType.getName();
        String password=studentType.getPassword();
        int sex=studentType.getSex();
        int age=studentType.getAge();
        String phonenumber=studentType.getPhonenumber();
        String email=studentType.getEmail();
        String in_which_class=studentType.getIn_which_class();

        String sql="insert into student(id,name,password,sex,age,phonenumber,email,in_which_class) values(?,?,?,?,?,?,?,?)";
        try {
            JdbcUtils.getQueryRunner().update(sql,id,name,password,sex,age,phonenumber,email,in_which_class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(StudentType studentType) {
        String name=studentType.getName();
        String password=studentType.getPassword();
        int sex=studentType.getSex();
        int age=studentType.getAge();
        String phonenumber=studentType.getPhonenumber();
        String email=studentType.getEmail();
        String in_which_class=studentType.getIn_which_class();

        String sql="update student set name=?,password=?,sex=?,age=?,phonenumber=?,email=?,in_which_class=? where id=?";
        try {
            JdbcUtils.getQueryRunner().update(sql,name,password,sex,age,phonenumber,email,in_which_class,studentType.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql="delete from student where id=?";
        try {
            JdbcUtils.getQueryRunner().update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public StudentType findById(String id) {
        String sql="select * from student where id=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<StudentType>(StudentType.class),id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean findByName(String name,String password) {
        try {
            String sql = "select * from student";
            List<StudentType> list = JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<StudentType>(StudentType.class));

            List<String> namelist = new ArrayList<String>();
            List<String> pwdlist = new ArrayList<String>();

            for (StudentType st : list) {
                namelist.add(st.getName());
                pwdlist.add(st.getPassword());
            }

            if (namelist.contains(name) && pwdlist.contains(password)) {
                return true;
            } else {
                return false;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<StudentType> getAll() {
        String sql="select * from student";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<StudentType>(StudentType.class));
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
