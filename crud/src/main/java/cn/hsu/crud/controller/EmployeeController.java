//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.hsu.crud.controller;

import cn.hsu.crud.bean.Employee;
import cn.hsu.crud.bean.Msg;
import cn.hsu.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    public EmployeeController() {
    }

    @ResponseBody
    @RequestMapping(
        value = {"/emp/{ids}"},
        method = {RequestMethod.DELETE}
    )
    public Msg empDelete(@PathVariable("ids") String ids) {
        if (ids.contains("-")) {
            List<Integer> del_ids = new ArrayList();
            String[] strs_ids = ids.split("-");
            String[] var7 = strs_ids;
            int var6 = strs_ids.length;

            for(int var5 = 0; var5 < var6; ++var5) {
                String str_id = var7[var5];
                del_ids.add(Integer.parseInt(str_id));
            }

            this.employeeService.deleteBatch(del_ids);
        } else {
            Integer id = Integer.parseInt(ids);
            this.employeeService.empDelete(id);
        }

        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(
        value = {"/emp/{empId}"},
        method = {RequestMethod.PUT}
    )
    public Msg saveEmp(Employee employee) {
        this.employeeService.updateEmp(employee);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(
        value = {"/emp/{id}"},
        method = {RequestMethod.GET}
    )
    public Msg getEmp(@PathVariable("id") Integer id) {
        Employee employee = this.employeeService.getEmp(id);
        return Msg.success().add("emp", employee);
    }

    @ResponseBody
    @RequestMapping({"/checkUser"})
    public Msg checkUser(@RequestParam("empName") String empName) {
        String regx = "(^[a-zA-Z0-9_-]{4,16}$)|(^[⺀-\u9fff]{2,6})";
        if (!empName.matches(regx)) {
            return Msg.fail().add("valid_msg", "用户名中文长度为2-6位，字母、数字及非特殊字符长度为4-16位");
        } else {
            boolean flag = this.employeeService.checkUser(empName);
            return flag ? Msg.success() : Msg.fail().add("valid_msg", "用户名不可用！");
        }
    }

    @ResponseBody
    @RequestMapping(
        value = {"/emp"},
        method = {RequestMethod.POST}
    )
    public Msg saveEmp(@Valid Employee emp, BindingResult result) {
        if (!result.hasErrors()) {
            this.employeeService.saveEmp(emp);
            return Msg.success();
        } else {
            Map<String, Object> map = new HashMap();
            List<FieldError> errors = result.getFieldErrors();
            Iterator var6 = errors.iterator();

            while(var6.hasNext()) {
                FieldError fieldError = (FieldError)var6.next();
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            return Msg.fail().add("errorFields", map);
        }
    }

    @RequestMapping({"/emps"})
    @ResponseBody
    public Msg getEmpsByJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn) throws Exception {
        PageHelper.startPage(pn.intValue(), 10);
        List<Employee> emps = this.employeeService.getAll();
        PageInfo page = new PageInfo(emps, 5);
        return Msg.success().add("pageInfo", page);
    }
}
