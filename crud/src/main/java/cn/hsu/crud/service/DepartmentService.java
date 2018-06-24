//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.hsu.crud.service;

import cn.hsu.crud.bean.Department;
import cn.hsu.crud.bean.DepartmentExample;
import cn.hsu.crud.dao.DepartmentMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper deptMapper;

    public DepartmentService() {
    }

    public List<Department> getAllDepts() {
        return this.deptMapper.selectByExample((DepartmentExample)null);
    }
}
