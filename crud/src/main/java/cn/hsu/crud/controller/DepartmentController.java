//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.hsu.crud.controller;

import cn.hsu.crud.bean.Department;
import cn.hsu.crud.bean.Msg;
import cn.hsu.crud.service.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    public DepartmentController() {
    }

    @ResponseBody
    @RequestMapping({"/depts"})
    public Msg getDeptsByJson() throws Exception {
        List<Department> deptList = this.departmentService.getAllDepts();
        return Msg.success().add("deptsList", deptList);
    }
}
