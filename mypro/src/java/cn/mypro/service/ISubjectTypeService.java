package cn.mypro.service;

import cn.mypro.entity.SubjectType;

import java.util.List;

/**
 * Created by MrBread on 2017/7/21.
 */
public interface ISubjectTypeService {
    void save(SubjectType subjectType);
    void update(SubjectType subjectType);
    void delete(String name);
    SubjectType findByName(String name);
    List<SubjectType> getAll();
}
