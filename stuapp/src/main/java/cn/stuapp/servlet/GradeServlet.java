package cn.stuapp.servlet;

import cn.stuapp.entity.ScoreType;
import cn.stuapp.entity.StudentType;
import cn.stuapp.entity.SubjectType;
import cn.stuapp.factory.BeanFactory;
import cn.stuapp.service.IScoreTypeService;
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
 * 主要是处理成绩界面的servlet
 * Created by MrBread on 2017/7/30.
 */
public class GradeServlet extends HttpServlet{
    private IScoreTypeService scoreTypeService= BeanFactory.getInstance("scoreTypeService",IScoreTypeService.class);
    private IStudentTypeService studentTypeService=BeanFactory.getInstance("studentTypeService",IStudentTypeService.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("UTf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session= request.getSession(true);
        List<ScoreType> scoreTypeList=new ArrayList<ScoreType>();

        //获取学生的用户名
        String username=request.getParameter("username");
        //获取是正常显示学生分数还是查询特定学科分数
        String method=request.getParameter("method");

        if("search".equals(method)){
            String subjectid=request.getParameter("subjectid");  //课程名称
            String subjectname=request.getParameter("subjectname");//课程名称
            String testtime=request.getParameter("testtime"); //考试时间
            //默认以课程编号、课程名称和考试时间依次优先
            if(!"".equals(subjectid)){
                scoreTypeList=scoreTypeService.findBySubjectid(subjectid);
            }else if(!"".equals(subjectname)){
                scoreTypeList=scoreTypeService.findBySubjectname(subjectname);
            }else if(!"".equals(testtime)){
                scoreTypeList=scoreTypeService.findByTesttime(testtime);
            }else{
                scoreTypeList=scoreTypeService.findByUsername(username);
            }
        }else {
            //根据学生的用户名从分数表中找到所有该学生的记录
            scoreTypeList = scoreTypeService.findByUsername(username);
        }
        //由于还要修改信息必须将该学生的信息传到页面中
        StudentType studentType=studentTypeService.findByName(username);
        session.setAttribute("studentType",studentType);
        //将属于该学生的分数列表传到jsp页面显示
       session.setAttribute("scoreTypeList",scoreTypeList);

        if("search".equals(method)){
            request.getRequestDispatcher("/inner/grade.jsp").forward(request, response);
        }else {
            //转到details_of_grade.jsp页面
            request.getRequestDispatcher("/inner/details_of_grade.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        this.doGet(request,response);
    }
}
