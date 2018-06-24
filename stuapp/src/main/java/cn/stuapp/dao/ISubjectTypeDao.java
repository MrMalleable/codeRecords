package cn.stuapp.dao;

import cn.stuapp.entity.SubjectType;

import java.util.List;

/**
 * 课程类的操作接口
 * Created by MrBread on 2017/7/30.
 */
public interface ISubjectTypeDao {
    void save(SubjectType subjectType);
    void update(SubjectType subjectType);
    void delete(String subjectid);
    SubjectType findByIdAndName(String subjectid,String subjectname);
    List<SubjectType> findById(String subjectid);
    List<SubjectType> findByName(String subjectname);
    List<SubjectType> findIsFull();
    List<SubjectType> getAll();
}
