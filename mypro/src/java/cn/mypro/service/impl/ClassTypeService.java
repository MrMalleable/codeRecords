package cn.mypro.service.impl;

import cn.mypro.dao.IClassTypeDao;
import cn.mypro.entity.ClassType;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.IClassTypeService;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by MrBread on 2017/7/17.
 */
public class ClassTypeService implements IClassTypeService {
    private IClassTypeDao classTypeDao= BeanFactory.getInstance("classTypeDao",IClassTypeDao.class);
    @Override
    public void save(ClassType classType) {
        try{
            classTypeDao.save(classType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(ClassType classType) {
        try{
            classTypeDao.update(classType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try{
            classTypeDao.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ClassType findById(String id) {
        try{
            return classTypeDao.findById(id);
        }catch(Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public List<ClassType> getAll() {
        try{
            return classTypeDao.getAll();
        }catch(Exception e){
            throw  new RuntimeException(e);
        }
    }
}
