package cn.mypro.dao;

import cn.mypro.entity.SubjectType;

import java.util.List;

/**
 * Created by MrBread on 2017/7/21.
 */
public interface ISubjectTypeDao {
    void save(SubjectType subjectType);
    void update(SubjectType subjectType);
    void delete(String name);
    SubjectType findByName(String name);
    List<SubjectType> getAll();
}
