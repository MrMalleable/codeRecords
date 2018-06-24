package cn.mypro.service.impl;

import cn.mypro.dao.ISubjectTypeDao;
import cn.mypro.entity.SubjectType;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.ISubjectTypeService;
import com.sun.org.apache.bcel.internal.generic.ISUB;

import java.util.List;

/**
 * Created by MrBread on 2017/7/21.
 */
public class SubjectTypeService implements ISubjectTypeService {

    private ISubjectTypeDao subjectTypeDao= BeanFactory.getInstance("subjectTypeDao",ISubjectTypeDao.class);
    @Override
    public void save(SubjectType subjectType) {
        try{
            subjectTypeDao.save(subjectType);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(SubjectType subjectType) {
        try{
            subjectTypeDao.update(subjectType);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) {
        try{
            subjectTypeDao.delete(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public SubjectType findByName(String name) {
        try{
            return subjectTypeDao.findByName(name);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SubjectType> getAll() {
        try{
            return subjectTypeDao.getAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
