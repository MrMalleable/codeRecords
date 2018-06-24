package cn.mypro.service;

import cn.mypro.entity.TeacherType;

import java.util.List;

/**
 * Created by MrBread on 2017/7/14.
 */
public interface ITeacherTypeService {
    /**
     * 保存教师信息
     * @param teacherType
     */
    void save(TeacherType teacherType);

    /**
     * 更新教师信息
     * @param teacherType
     */
    void update(TeacherType teacherType);

    /**
     * 根据教师编号删除该教师的信息
     * @param id
     */
    void delete(String id);

    /**
     * 根据教师编号查询该教师的信息
     * @param id
     * @return TeacherTypeService
     */
    TeacherType findById(String id);

    TeacherType findByName(String name);

    /**
     * 根据用户名查询该教师是否在数据库中
     * @param name
     * @return boolean
     */
    boolean findByName(String name,String password);

    /**
     * 获取所有教师的信息
     * @return List<TeacherTypeService>
     */
    List<TeacherType> getAll();
}
