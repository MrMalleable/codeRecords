package cn.mypro.service.impl;

import cn.mypro.dao.IStudentTypeDao;
import cn.mypro.dao.impl.StudentTypeDao;
import cn.mypro.entity.StudentType;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.IStudentTypeService;
import oracle.jrockit.jfr.StringConstantPool;

import java.util.List;

/**
 * Created by MrBread on 2017/7/12.
 */
public class StudentTypeService implements IStudentTypeService {

    private IStudentTypeDao studentTypeDao= BeanFactory.getInstance("studentTypeDao",IStudentTypeDao.class);
    @Override
    public void save(StudentType studentType) {
        try{
            studentTypeDao.save(studentType);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(StudentType studentType) {
        try{
            studentTypeDao.update(studentType);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        try{
            studentTypeDao.delete(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public StudentType findById(String id) {
        try{
            return studentTypeDao.findById(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean findByName(String name,String password) {
        try{
            return studentTypeDao.findByName(name, password);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<StudentType> getAll() {
        try{
            return studentTypeDao.getAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
