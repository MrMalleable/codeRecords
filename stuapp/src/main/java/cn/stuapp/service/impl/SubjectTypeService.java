package cn.stuapp.service.impl;

import cn.stuapp.dao.ISubjectTypeDao;
import cn.stuapp.entity.SubjectType;
import cn.stuapp.factory.BeanFactory;
import cn.stuapp.service.IStudentTypeService;
import cn.stuapp.service.ISubjectTypeService;

import java.util.List;

/**
 * Created by MrBread on 2017/7/30.
 */
public class SubjectTypeService implements ISubjectTypeService {
    private ISubjectTypeDao subjectTypeDao= BeanFactory.getInstance("subjectTypeDao",ISubjectTypeDao.class);
    public void save(SubjectType subjectType) {
        try{
            subjectTypeDao.save(subjectType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(SubjectType subjectType) {
        try{
            subjectTypeDao.update(subjectType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(String subjectid) {
        try{
            subjectTypeDao.delete(subjectid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<SubjectType> findById(String subjectid) {
        try{
            return subjectTypeDao.findById(subjectid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<SubjectType> findByName(String subjectname) {
        try{
            return subjectTypeDao.findByName(subjectname);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<SubjectType> findIsFull() {
        try{
            return subjectTypeDao.findIsFull();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<SubjectType> getAll() {
        try{
            return subjectTypeDao.getAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public SubjectType findByIdAndName(String subjectid, String subjectname) {
        try{
            return subjectTypeDao.findByIdAndName(subjectid,subjectname);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
