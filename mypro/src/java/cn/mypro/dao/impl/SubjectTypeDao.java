package cn.mypro.dao.impl;

import cn.mypro.dao.ISubjectTypeDao;
import cn.mypro.entity.SubjectType;
import cn.mypro.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by MrBread on 2017/7/21.
 */
public class SubjectTypeDao implements ISubjectTypeDao {
    @Override
    public void save(SubjectType subjectType) {
        String name=subjectType.getName();
        int status=subjectType.getStatus();
        String teacher=subjectType.getTeacher();
        String sql="insert into subjects(name,status,teacher) values(?,?,?)";
        try{
            JdbcUtils.getQueryRunner().update(sql,name,status,teacher);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(SubjectType subjectType) {
        String name=subjectType.getName();
        int status=subjectType.getStatus();
        String teacher=subjectType.getTeacher();
        String sql="update subjects set status=?,teacher=? where name=?";
        try{
            JdbcUtils.getQueryRunner().update(sql,status,teacher,name);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) {
        String sql="delete from subjects where name=?";
        try{
            JdbcUtils.getQueryRunner().update(sql,name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public SubjectType findByName(String name) {
        String sql="select * from subjects where name=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<SubjectType>(SubjectType.class),name);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SubjectType> getAll() {
        String sql="select * from subjects";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<SubjectType>(SubjectType.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
