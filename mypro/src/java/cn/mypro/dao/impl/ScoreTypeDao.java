package cn.mypro.dao.impl;

import cn.mypro.dao.IScoreTypeDao;
import cn.mypro.dao.IStudentTypeDao;
import cn.mypro.entity.StudentType;
import cn.mypro.utils.JdbcUtils;
import jdk.nashorn.internal.scripts.JD;

/**当学生选了一门课的时候就在分数表中更新该科目的分数值
 * Created by MrBread on 2017/7/20.
 */
public class ScoreTypeDao implements IScoreTypeDao{

    @Override
    public void updateScore(String name,String subject,String score) {
        String sql="update score set "+subject.replaceAll("\"","").replaceAll("\'","")+"='"+score+"' where name='"+name+"'";
        System.out.println("sql:   "+sql);
        try{
            JdbcUtils.getQueryRunner().update(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addColumn(String subject,int status) {
        String sql=null;
        if(status==1) {
             sql = "alter table score add column " + subject + " varchar(20) default '-1'";
        }
        if(status==0){
             sql = "alter table score add column " + subject + " varchar(20) default '0'";
        }
        try{
            JdbcUtils.getQueryRunner().update(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    /**
     * 增加一条新的记录，对应于增加一个新学生的分数
     */
    public void addRecord(String name) {
        String sql="insert into score(name) value(?)";
        try{
            JdbcUtils.getQueryRunner().update(sql,name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
