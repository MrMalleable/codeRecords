//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.hsu.crud.dao;

import cn.hsu.crud.bean.Employee;
import cn.hsu.crud.bean.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    long countByExample(EmployeeExample var1);

    int deleteByExample(EmployeeExample var1);

    int deleteByPrimaryKey(Integer var1);

    int insert(Employee var1);

    int insertSelective(Employee var1);

    List<Employee> selectByExample(EmployeeExample var1);

    Employee selectByPrimaryKey(Integer var1);

    List<Employee> selectByExampleWithDept(EmployeeExample var1);

    Employee selectByPrimaryKeyWithDept(Integer var1);

    int updateByExampleSelective(@Param("record") Employee var1, @Param("example") EmployeeExample var2);

    int updateByExample(@Param("record") Employee var1, @Param("example") EmployeeExample var2);

    int updateByPrimaryKeySelective(Employee var1);

    int updateByPrimaryKey(Employee var1);
}
