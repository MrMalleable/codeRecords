package cn.mypro.dao;

import cn.mypro.entity.ClassType;

import java.util.List;

/**
 * Created by MrBread on 2017/7/17.
 */
public interface IClassTypeDao {
    /**
     * 保存班级信息
     * @param classType
     */
    void save(ClassType classType);

    /**
     * 更新班级信息
     * @param classType
     */
    void update(ClassType classType);

    /**
     * 根据班级号删除该班级的信息
     * @param id
     */
    void delete(String id);

    /**
     * 根据班级号查询该班级的信息
     * @param id
     * @return ClassType
     */
    ClassType findById(String id);

    /**
     * 获取所有班级的信息
     * @return List<ClassType>
     */
    List<ClassType> getAll();

}
