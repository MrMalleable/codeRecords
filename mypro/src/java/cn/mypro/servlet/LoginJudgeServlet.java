package cn.mypro.servlet;

import cn.mypro.entity.AdminType;
import cn.mypro.entity.InnerType;
import cn.mypro.entity.TeacherType;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.IAdminTypeService;
import cn.mypro.service.IStudentTypeService;
import cn.mypro.service.ITeacherTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrBread on 2017/7/13.
 */
public class LoginJudgeServlet extends HttpServlet {

    private IAdminTypeService adminTypeService= BeanFactory.getInstance("adminTypeService",IAdminTypeService.class);
    private IStudentTypeService studentTypeService=BeanFactory.getInstance("studentTypeService",IStudentTypeService.class);
    private ITeacherTypeService teacherTypeService=BeanFactory.getInstance("teacherTypeService",ITeacherTypeService.class);
    private Object uri;

    private static List<InnerType> list=new ArrayList<InnerType>();
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String method=request.getParameter("method");
        if("login".equals(method)){
            login(request,response);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        this.doGet(request,response);
    }

    public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        //判断登录用户类型
        if(adminTypeService.contains(name,password)){
            request.setAttribute("name",name);
            uri=request.getRequestDispatcher("/sys/admin_index.jsp");
        }else if (teacherTypeService.findByName(name,password)){
            //是教师登录的话需要从分数表中取出所有选择该门学科的学生
            TeacherType tt=teacherTypeService.findByName(name);
            String subject=tt.getSubject();
            getList(subject);

            request.setAttribute("resultList",list);
            request.setAttribute("name",name);
            System.out.println("老师登录时设置的名字：  "+name);
            uri=request.getRequestDispatcher("/sys/teacher_index.jsp");
        }else if(studentTypeService.findByName(name,password)){
            request.setAttribute("name",name);
            uri=request.getRequestDispatcher("/sys/student_index.jsp");
        }
        else{
            uri="/sys/login.jsp";
        }
        goTo(request,response,uri);
        list.clear();
    }

    private void getList(String subject){
        Connection connection=getConnection();
        String sql="select name,"+subject+" from score";

        PreparedStatement preparedStatement;
        try{
            preparedStatement=connection.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery(sql);
            while(rs.next()){
                    if(!"-1".equals(rs.getString(2))) {
                        InnerType innerType=new InnerType();
                        innerType.setName(rs.getString(1));
                        innerType.setScore(rs.getString(2));
                        list.add(innerType);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/mypro";
            String user="root";
            String password="jiaojiao.667";
            connection= DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    private void goTo(HttpServletRequest request,HttpServletResponse response,Object uri) throws ServletException,IOException{
        if(uri instanceof RequestDispatcher){
            ((RequestDispatcher)uri).forward(request,response);
        }else if(uri instanceof  String){
            response.sendRedirect(request.getContextPath()+uri);
        }
    }

}
