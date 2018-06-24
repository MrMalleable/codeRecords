//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.hsu.crud.service;

import cn.hsu.crud.bean.Employee;
import cn.hsu.crud.bean.EmployeeExample;
import cn.hsu.crud.bean.EmployeeExample.Criteria;
import cn.hsu.crud.dao.EmployeeMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper mapper;

    public EmployeeService() {
    }

    public List<Employee> getAll() {
        return this.mapper.selectByExampleWithDept((EmployeeExample)null);
    }

    public void saveEmp(Employee emp) {
        this.mapper.insertSelective(emp);
    }

    public boolean checkUser(String empName) {
        EmployeeExample example = new EmployeeExample();
        Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = this.mapper.countByExample(example);
        return count == 0L;
    }

    public Employee getEmp(Integer id) {
        Employee employee = this.mapper.selectByPrimaryKey(id);
        return employee;
    }

    public void updateEmp(Employee employee) {
        this.mapper.updateByPrimaryKeySelective(employee);
    }

    public void empDelete(Integer id) {
        this.mapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        EmployeeExample example = new EmployeeExample();
        Criteria criteria = example.createCriteria();
        criteria.andEmpIdIn(ids);
        this.mapper.deleteByExample(example);
    }
}
