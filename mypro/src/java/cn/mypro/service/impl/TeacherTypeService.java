package cn.mypro.service.impl;

import cn.mypro.dao.ITeacherTypeDao;
import cn.mypro.dao.impl.TeacherTypeDao;
import cn.mypro.entity.TeacherType;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.ITeacherTypeService;

import java.util.List;

/**
 * Created by MrBread on 2017/7/14.
 */
public class TeacherTypeService implements ITeacherTypeService{

    private ITeacherTypeDao teacherTypeDao= BeanFactory.getInstance("teacherTypeDao", ITeacherTypeDao.class);
    @Override
    public void save(TeacherType teacherType) {
        try{
            teacherTypeDao.save(teacherType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(TeacherType teacherType) {
        try{
            teacherTypeDao.update(teacherType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try{
            teacherTypeDao.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public TeacherType findById(String id) {
        try{
            return teacherTypeDao.findById(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public TeacherType findByName(String name) {
        try{
            return teacherTypeDao.findByName(name);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean findByName(String name, String password) {
        try{
            return teacherTypeDao.findByName(name,password);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TeacherType> getAll() {
        try{
            return teacherTypeDao.getAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
