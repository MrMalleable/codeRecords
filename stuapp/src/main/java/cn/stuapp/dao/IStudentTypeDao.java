package cn.stuapp.dao;

import cn.stuapp.entity.StudentType;

import java.util.List;

/**
 * 定义对学生类操作的接口
 * Created by MrBread on 2017/7/28.
 */
public interface IStudentTypeDao {
    void save(StudentType studentType);
    void update(StudentType studentType);
    void delete(String stuid);
    StudentType findById(String stuid);
    StudentType findByName(String username);
    boolean contains(String username,String pwd);
    List<StudentType> getAll();
}
