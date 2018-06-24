package cn.mypro.service;

import cn.mypro.entity.ClassType;

import java.util.List;

/**
 * Created by MrBread on 2017/7/17.
 */
public interface IClassTypeService {
    void save(ClassType classType);
    void update(ClassType classType);
    void delete(String id);
    ClassType findById(String id);
    List<ClassType> getAll();
}
