package cn.stuapp.dao.impl;

import cn.stuapp.dao.ISubjectTypeDao;
import cn.stuapp.entity.SubjectType;
import cn.stuapp.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 对数据库进行操作的方法
 * Created by MrBread on 2017/7/30.
 */
public class SubjectTypeDao implements ISubjectTypeDao {
    public void save(SubjectType subjectType) {
        String subjectid=subjectType.getSubjectid();
        String subjectname=subjectType.getSubjectname();
        String starttime=subjectType.getStarttime();
        String testtime=subjectType.getTesttime();
        String subjectplace=subjectType.getSubjectplace();
        String teacher=subjectType.getTeacher();
        int capacity=subjectType.getCapacity();
        int choosen_num=subjectType.getChoosen_num();

        String sql="insert into subjects(subjectid,subjectname,starttime,testtime,subjectplace,teacher,capacity,choosen_num) values(?,?,?,?,?,?,?,?)";
        try{
            JdbcUtils.getQueryRunner().update(sql,subjectid,subjectname,starttime,testtime,subjectplace,teacher,capacity,choosen_num);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(SubjectType subjectType) {
        String subjectid=subjectType.getSubjectid();
        String subjectname=subjectType.getSubjectname();
        String starttime=subjectType.getStarttime();
        String testtime=subjectType.getTesttime();
        String subjectplace=subjectType.getSubjectplace();
        String teacher=subjectType.getTeacher();
        int capacity=subjectType.getCapacity();
        int choosen_num=subjectType.getChoosen_num();

        String sql="update subjects set subjectname=?,starttime=?,testtime=?,subjectplace=?,teacher=?,capacity=?,choosen_num=? where subjectid=?";
        try{
            JdbcUtils.getQueryRunner().update(sql,subjectname,starttime,testtime,subjectplace,teacher,capacity,choosen_num,subjectid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(String subjectid) {
        String sql="delete from subjects where subjectid=?";
        try {
            JdbcUtils.getQueryRunner().update(sql,subjectid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<SubjectType> findById(String subjectid) {
        String sql="select * from subjects where subjectid=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<SubjectType>(SubjectType.class),subjectid);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<SubjectType> findByName(String subjectname) {
        String sql="select * from subjects where subjectname=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<SubjectType>(SubjectType.class),subjectname);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<SubjectType> getAll() {
        String sql="select * from subjects";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<SubjectType>(SubjectType.class));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<SubjectType> findIsFull(){
        String sql="select * from subjects where choosen_num < capacity";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<SubjectType>(SubjectType.class));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public SubjectType findByIdAndName(String subjectid,String subjectname){
        String sql="select * from subjects where subjectid=? and subjectname=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<SubjectType>(SubjectType.class),subjectid,subjectname);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
