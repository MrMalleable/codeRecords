package cn.stuapp.servlet;

import cn.stuapp.entity.StudentType;
import cn.stuapp.factory.BeanFactory;
import cn.stuapp.service.IStudentTypeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 主要是修改学生信息的servlet，对应info_modify.action
 * Created by MrBread on 2017/7/29.
 * 2017/7/30实现可以修改学生信息
 */
public class ModifyInformationServlet extends HttpServlet{
    private IStudentTypeService studentTypeService= BeanFactory.getInstance("studentTypeService",IStudentTypeService.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        modify(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        this.doGet(request,response);
    }

    public void modify(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        //先从jsp界面提交的表单数据中获取修改后的学生基本信息的各个属性值
        StudentType studentType=new StudentType();
        studentType.setStuid(request.getParameter("stuid"));
        studentType.setUsername(request.getParameter("username"));
        studentType.setSex(request.getParameter("sex"));
        studentType.setAcademy(request.getParameter("academy"));
        studentType.setClass_in(request.getParameter("class_in"));
        studentType.setPwd(request.getParameter("pwd"));
        studentType.setPwd_confirm();
        studentType.setTel(request.getParameter("tel"));
        studentType.setContact(request.getParameter("contact"));
        studentType.setEmail(request.getParameter("email"));
        studentType.setQq(request.getParameter("qq"));
        studentType.setAddress(request.getParameter("address"));

        //获取修改信息的请求是从那个页面的模态框发送过来的
        String location=request.getParameter("location");

        //调用service将信息更新到数据库中
        studentTypeService.update(studentType);

        //跳转到指定的页面
        request.setAttribute("update","success_update");
        request.setAttribute("studentType",studentType);
        if("index".equals(location)) {
            request.getRequestDispatcher("/inner/index.jsp").forward(request, response);
        }else if("grade".equals(location)){
            request.getRequestDispatcher("/inner/details_of_grade.jsp").forward(request,response);
        }else if("class".equals(location)){
            request.getRequestDispatcher("/inner/details_of_class.jsp").forward(request,response);
        }
    }
}
