package cn.mypro.service;

import cn.mypro.entity.StudentType;

import java.util.List;

/**服务层的接口
 * Created by MrBread on 2017/7/12.
 */
public interface IStudentTypeService {
    /**
     * 保存学生信息
     * @param studentType
     */
    void save(StudentType studentType);

    /**
     * 更新学生信息
     * @param studentType
     */
    void update(StudentType studentType);

    /**
     * 根据学号删除该学生的信息
     * @param id
     */
    void delete(String id);

    /**
     * 根据学号查询该学生的信息
     * @param id
     * @return StudentType
     */
    StudentType findById(String id);

    /**
     * 根据用户名和密码查询该学生是否在数据库中
     * @param name,password
     * @return boolean
     */
    boolean findByName(String name,String password);

    /**
     * 获取所有学生的信息
     * @return List<StudentType>
     */
    List<StudentType> getAll();
    //之后再加上班级可以通过班级获取该班级全部的学生
    //List<StudentType> getAll(String classname)
}
