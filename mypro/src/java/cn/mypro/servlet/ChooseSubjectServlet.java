package cn.mypro.servlet;

import cn.mypro.entity.SubjectType;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.IScoreTypeService;
import cn.mypro.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import sun.security.x509.SubjectAlternativeNameExtension;

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
 * Created by MrBread on 2017/7/20.
 */
public class ChooseSubjectServlet extends HttpServlet {
    private IScoreTypeService scoreTypeService= BeanFactory.getInstance("scoreTypeService",IScoreTypeService.class);
    private Object uri;

    //存储分数表中的列名
    private List<String> columnNameList=new ArrayList<String>();
    //存储分数表中列名所对应的值
    private List<String> columnValueList=new ArrayList<String>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String sql="select * from subjects where status=1";
        try{
            //list存储的是所有的科目
            List<String> list=new ArrayList<String>();
            for(SubjectType subjectType:JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<SubjectType>(SubjectType.class))){
                list.add(subjectType.getName());
            }
            String name=request.getParameter("name");
            for(String var:list){
                if("selected".equals(request.getParameter(var))){
                    scoreTypeService.updateScore(name,var,"0");
                }
            }
            getList(name);
            request.setAttribute("columnNameList",columnNameList);
            request.setAttribute("columnValueList",columnValueList);
            request.setAttribute("name",name);
            uri = request.getRequestDispatcher("/sys/type/subjectslist.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
        goTo(request,response,uri);
        columnNameList.clear();
        columnValueList.clear();
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        this.doGet(request,response);
    }

    private void goTo(HttpServletRequest request,HttpServletResponse response,Object uri) throws ServletException,IOException {
        if(uri instanceof RequestDispatcher){
            ((RequestDispatcher)uri).forward(request,response);
        }else if(uri instanceof  String){
            response.sendRedirect(request.getContextPath()+uri);
        }
    }

    private void getList(String name){
        Connection connection=getConnection();
        String sql="select * from score where name="+"'"+name+"'";
        PreparedStatement preparedStatement;
        try{
            preparedStatement=connection.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData=rs.getMetaData();
            while(rs.next()){
                for(int i=1;i<=resultSetMetaData.getColumnCount();i++){
                    if(!"-1".equals(rs.getString(i))) {
                       columnNameList.add(resultSetMetaData.getColumnName(i));
                       columnValueList.add(rs.getString(i));
                    }
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
}

