package cn.mypro.servlet;

import cn.mypro.entity.InnerType;
import cn.mypro.entity.TeacherType;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.IScoreTypeService;
import cn.mypro.service.ITeacherTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 该servlet主要是处理在教室登录成功界面中对学生分数的更新
 * Created by MrBread on 2017/7/22.
 */
public class UpdateScoreServlet extends HttpServlet{
    private IScoreTypeService scoreTypeService= BeanFactory.getInstance("scoreTypeService",IScoreTypeService.class);
    private List<String> StudentNameList=new ArrayList<String>();
    private ITeacherTypeService teacherTypeService=BeanFactory.getInstance("teacherTypeService",ITeacherTypeService.class);
    private Object uri;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        //先从界面中获得学生姓名和老师所给分数
        String name=request.getParameter("name");
        TeacherType tt=teacherTypeService.findByName(name);
        getList(tt.getSubject());
        for(String studentname:StudentNameList){
            System.out.println(name);
            String score=request.getParameter(studentname);
            scoreTypeService.updateScore(studentname,tt.getSubject(),score);
        }
        uri="/sys/update_success.jsp";

        goTo(request,response,uri);
        StudentNameList.clear();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        this.doGet(request,response);
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
                    StudentNameList.add(rs.getString(1));
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
