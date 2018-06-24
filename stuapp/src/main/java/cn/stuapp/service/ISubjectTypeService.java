package cn.stuapp.service;

import cn.stuapp.entity.SubjectType;

import java.util.List;

/**
 * Created by MrBread on 2017/7/30.
 */
public interface ISubjectTypeService {
    void save(SubjectType subjectType);
    void update(SubjectType subjectType);
    void delete(String subjectid);
    SubjectType findByIdAndName(String subjectid,String subjectname);
    List<SubjectType> findById(String subjectid);
    List<SubjectType> findByName(String subjectname);
    List<SubjectType> findIsFull();
    List<SubjectType> getAll();
}
