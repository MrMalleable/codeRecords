package cn.mypro.dao.impl;

import cn.mypro.dao.IClassTypeDao;
import cn.mypro.entity.ClassType;
import cn.mypro.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by MrBread on 2017/7/17.
 */
public class ClassTypeDao implements IClassTypeDao{
    @Override
    public void save(ClassType classType) {
        try{
            String sql="insert into class(id,membernums) values(?,?)";
            JdbcUtils.getQueryRunner().update(sql,classType.getId(),classType.getMembernums());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(ClassType classType) {
        try{
            String sql="update class set membernums=? where id=?";
            JdbcUtils.getQueryRunner().update(sql,classType.getMembernums(),classType.getId());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try{
            String sql="delete from class where id=?";
            JdbcUtils.getQueryRunner().update(sql,id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ClassType findById(String id) {
        try{
            String sql="select * from class where id=?";
            return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<ClassType>(ClassType.class),id);
        }catch(Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public List<ClassType> getAll() {
        try{
            String sql="select * from class";
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<ClassType>(ClassType.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
