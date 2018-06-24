package cn.stuapp.servlet;

import cn.stuapp.entity.StudentType;
import cn.stuapp.factory.BeanFactory;
import cn.stuapp.service.IStudentTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 主要是处理登录界面时的用户和密码，如果符合要求的用户直接跳转到相应主页，否则直接留在登录界面并输出提示
 * Created by MrBread on 2017/7/28.
 */
public class LoginServlet extends HttpServlet{
    //获取bean工厂的service
    private IStudentTypeService studentTypeService= BeanFactory.getInstance("studentTypeService",IStudentTypeService.class);
    private Object uri;

    //doGet和doPost方法的重载
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
        String username=request.getParameter("username");
        String pwd=request.getParameter("pwd");
        //判断登录用户类型
        if(studentTypeService.contains(username,pwd)){
            StudentType st=studentTypeService.findByName(username);
            request.setAttribute("studentType",st);
            uri=request.getRequestDispatcher("/inner/index.jsp");
        }
        else{
            String failure="failure";
            request.setAttribute("status",failure);
            //这样的话地址栏的地址localhost:8080/loginjudge?method=login 而不是login.jsp
            uri=request.getRequestDispatcher("/login.jsp");
        }
        goTo(request,response,uri);
    }

    private void goTo(HttpServletRequest request, HttpServletResponse response, Object uri) throws ServletException,IOException {
        if(uri instanceof RequestDispatcher){
            ((RequestDispatcher)uri).forward(request,response);
        }else if(uri instanceof  String){
            //重定向的话会将request清空，设置的attribute无法传到jsp
            response.sendRedirect(request.getContextPath()+uri);
        }
    }
}
