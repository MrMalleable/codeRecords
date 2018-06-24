package cn.stuapp.servlet;

import cn.stuapp.entity.ScoreType;
import cn.stuapp.entity.StudentType;
import cn.stuapp.entity.SubjectType;
import cn.stuapp.factory.BeanFactory;
import cn.stuapp.service.IScoreTypeService;
import cn.stuapp.service.IStudentTypeService;
import cn.stuapp.service.ISubjectTypeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 主要是处理选课的提交
 * Created by MrBread on 2017/8/4.
 */
public class ChooseClassServlet extends HttpServlet {
    private ISubjectTypeService subjectTypeService= BeanFactory.getInstance("subjectTypeService",ISubjectTypeService.class);
    private IStudentTypeService studentTypeService=BeanFactory.getInstance("studentTypeService",IStudentTypeService.class);
    private IScoreTypeService scoreTypeService=BeanFactory.getInstance("scoreTypeService",IScoreTypeService.class);

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();

        String username=request.getParameter("username");
        String subjectid=request.getParameter("subjectid");
        String subjecname=request.getParameter("subjectname");
        SubjectType subjectType=subjectTypeService.findByIdAndName(subjectid,subjecname);
        //如果分数表中没有该门课程的信息，则添加新纪录到分数表并更新课程表中的已选人数
        if(scoreTypeService.findRecord(username,subjectid)==null) {//说明不存在该条记录
            ScoreType scoreType=new ScoreType();
            scoreType.setUsername(username);
            scoreType.setSubjectid(subjectType.getSubjectid());
            scoreType.setSubjectname(subjectType.getSubjectname());
            scoreType.setTesttime(subjectType.getTesttime());
            scoreType.setScore(0);
            //将该条新纪录更新到分数表中
            scoreTypeService.save(scoreType);

            //同时对应的课程表中的该门课程已选人数需要加一
            subjectType.setChoosen_num(subjectType.getChoosen_num() + 1);//该门课程已选人数加一
            subjectTypeService.update(subjectType);
        }

        StudentType studentType=studentTypeService.findByName(username);
        session.setAttribute("studentType",studentType);

        List<SubjectType> subjectTypeList=subjectTypeService.getAll();
        session.setAttribute("subjectTypeList",subjectTypeList);

        request.getRequestDispatcher("/inner/class.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        this.doGet(request,response);
    }
}
