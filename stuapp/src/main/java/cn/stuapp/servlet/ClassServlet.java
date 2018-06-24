package cn.stuapp.servlet;

import cn.stuapp.entity.StudentType;
import cn.stuapp.entity.SubjectType;
import cn.stuapp.factory.BeanFactory;
import cn.stuapp.service.IStudentTypeService;
import cn.stuapp.service.ISubjectTypeService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 主要处理选课系统的servlet
 * Created by MrBread on 2017/7/30.
 */
public class ClassServlet extends HttpServlet{
    private ISubjectTypeService subjectTypeService= BeanFactory.getInstance("subjectTypeService",ISubjectTypeService.class);
    private IStudentTypeService studentTypeService=BeanFactory.getInstance("studentTypeService",IStudentTypeService.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("UTf-8");
        response.setContentType("text/html;charset=UTF-8");
        List<SubjectType> subjectTypeList=new ArrayList<SubjectType>();
        HttpSession session=request.getSession();
        String username=request.getParameter("username");
        String method=request.getParameter("method");

        if("search".equals(method)){
            String subject_id=request.getParameter("subject_id");  //课程名称
            String subject_name=request.getParameter("subject_name");//课程名称
            String isFull=request.getParameter("isFull"); //人数是否满
            //默认以课程编号、课程名称和人数是否满依次优先
            if(!"".equals(subject_id)){
                subjectTypeList=subjectTypeService.findById(subject_id);
            }else if(!"".equals(subject_name)){
                subjectTypeList=subjectTypeService.findByName(subject_name);
            }else if("False".equals(isFull)){
                subjectTypeList=subjectTypeService.findIsFull();
            }else{
                subjectTypeList=subjectTypeService.getAll();
            }
        }else {
            //根据学生的用户名从分数表中找到所有该学生的记录
            subjectTypeList = subjectTypeService.getAll();
        }

        //由于还要修改信息必须将该学生的信息传到页面中
        StudentType studentType=studentTypeService.findByName(username);
        session.setAttribute("studentType",studentType);
        session.setAttribute("subjectTypeList",subjectTypeList);

        if("search".equals(method)){
            request.getRequestDispatcher("/inner/class.jsp").forward(request, response);
        }else {
            //转到details_of_class.jsp页面
            request.getRequestDispatcher("/inner/details_of_class.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        this.doGet(request,response);
    }
}
