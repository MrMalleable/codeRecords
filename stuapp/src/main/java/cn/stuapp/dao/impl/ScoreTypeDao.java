package cn.stuapp.dao.impl;

import cn.stuapp.dao.IScoreTypeDao;
import cn.stuapp.entity.ScoreType;
import cn.stuapp.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by MrBread on 2017/8/1.
 */
public class ScoreTypeDao implements IScoreTypeDao {
    public List<ScoreType> findBySubjectname(String subjectname) {
        String sql="select * from score where subjectname=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<ScoreType>(ScoreType.class),subjectname);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void save(ScoreType scoreType) {
        String username=scoreType.getUsername();
        String subjectid=scoreType.getSubjectid();
        String subjectname=scoreType.getSubjectname();
        String testtime=scoreType.getTesttime();
        int score=scoreType.getScore();

        //将数据保存到数据库
        String sql="insert into score(username,subjectid,subjectname,testtime,score) values(?,?,?,?,?)";
        try{
            JdbcUtils.getQueryRunner().update(sql,username,subjectid,subjectname,testtime,score);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(ScoreType scoreType) {
        String username=scoreType.getUsername();
        String subjectid=scoreType.getSubjectid();
        String subjectname=scoreType.getSubjectname();
        String testtime=scoreType.getTesttime();
        int score=scoreType.getScore();

        //将数据保存到数据库
        String sql="update score set subjectname=?,testtime=?,score=? where username=? and subjectid=?";
        try{
            JdbcUtils.getQueryRunner().update(sql,subjectname,testtime,score,username,subjectid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(String username, String subjectid) {
        String sql="delete * from score where username=? and subjectid=?";
        try{
            JdbcUtils.getQueryRunner().update(sql,username,subjectid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ScoreType findRecord(String username, String subjectid) {
        String sql="select * from score where username=? and subjectid=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<ScoreType>(ScoreType.class),username,subjectid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<ScoreType> findByUsername(String username) {
        String sql="select * from score where username=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<ScoreType>(ScoreType.class),username);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<ScoreType> findBySubjectid(String subjectid) {
        String sql="select * from score where subjectid=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<ScoreType>(ScoreType.class),subjectid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<ScoreType> findByTesttime(String testtime) {
        String sql="select * from score where testtime=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<ScoreType>(ScoreType.class),testtime);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
