//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.hsu.crud.dao;

import cn.hsu.crud.bean.Department;
import cn.hsu.crud.bean.DepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    long countByExample(DepartmentExample var1);

    int deleteByExample(DepartmentExample var1);

    int deleteByPrimaryKey(Integer var1);

    int insert(Department var1);

    int insertSelective(Department var1);

    List<Department> selectByExample(DepartmentExample var1);

    Department selectByPrimaryKey(Integer var1);

    int updateByExampleSelective(@Param("record") Department var1, @Param("example") DepartmentExample var2);

    int updateByExample(@Param("record") Department var1, @Param("example") DepartmentExample var2);

    int updateByPrimaryKeySelective(Department var1);

    int updateByPrimaryKey(Department var1);
}
