package cn.stuapp.service.impl;

import cn.stuapp.dao.IStudentTypeDao;
import cn.stuapp.entity.StudentType;
import cn.stuapp.factory.BeanFactory;
import cn.stuapp.service.IStudentTypeService;

import java.util.List;

/**
 * 学生类的服务层实现类，便于在servlet中使用
 * Created by MrBread on 2017/7/28.
 */
public class StudentTypeService implements IStudentTypeService {
    //从bean工厂中获取studentTypeDao
    private IStudentTypeDao studentTypeDao= BeanFactory.getInstance("studentTypeDao",IStudentTypeDao.class);
    //保存学生信息
    public void save(StudentType studentType) {
        try{
            studentTypeDao.save(studentType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //更新学生信息
    public void update(StudentType studentType) {
        try{
            studentTypeDao.update(studentType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //删除学生信息
    public void delete(String stuid) {
        try{
            studentTypeDao.delete(stuid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //通过学号获取学生信息
    public StudentType findById(String stuid) {
        try{
            return studentTypeDao.findById(stuid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    //通过用户名获取学生信息
    public StudentType findByName(String username) {
        try{
            return studentTypeDao.findByName(username);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    //判断该学生是否在数据库中
    public boolean contains(String username, String pwd) {
        try{
            return studentTypeDao.contains(username,pwd);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    //获取所有学生基本信息记录
    public List<StudentType> getAll() {
        try{
            return studentTypeDao.getAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
