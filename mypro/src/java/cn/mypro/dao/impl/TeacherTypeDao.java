package cn.mypro.dao.impl;

import cn.mypro.dao.ITeacherTypeDao;
import cn.mypro.entity.TeacherType;
import cn.mypro.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrBread on 2017/7/14.
 */
public class TeacherTypeDao implements ITeacherTypeDao {
    @Override
    public void save(TeacherType teacherType) {
        String id=teacherType.getId();
        String name=teacherType.getName();
        String password=teacherType.getPassword();
        String subject=teacherType.getSubject();

        String sql="insert into teacher(id,name,password,subject) values(?,?,?,?)";
        try {
            JdbcUtils.getQueryRunner().update(sql,id,name,password,subject);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TeacherType teacherType) {
        String id=teacherType.getId();
        String name=teacherType.getName();
        String password=teacherType.getPassword();
        String subject=teacherType.getSubject();
        String sql="update teacher set name=?,password=?,subject=? where id=?";
        try {
            JdbcUtils.getQueryRunner().update(sql,name,password,subject,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql="delete from teacher where id=?";
        try{
            JdbcUtils.getQueryRunner().update(sql,id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public TeacherType findById(String id) {
        String sql="select * from teacher where id=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<TeacherType>(TeacherType.class),id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public TeacherType findByName(String name) {
        String sql="select * from teacher where name=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<TeacherType>(TeacherType.class),name);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean findByName(String name,String password) {
        String sql = "select * from teacher";
        try{
            List<TeacherType> list=JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<TeacherType>(TeacherType.class));

            List<String> namelist=new ArrayList<String>();
            List<String> pwdlist=new ArrayList<String>();

            for(TeacherType tt:list){
                namelist.add(tt.getName());
                pwdlist.add(tt.getPassword());
            }

            if(namelist.contains(name)&&pwdlist.contains(password)){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TeacherType> getAll() {
        String sql="select * from teacher";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<TeacherType>(TeacherType.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
