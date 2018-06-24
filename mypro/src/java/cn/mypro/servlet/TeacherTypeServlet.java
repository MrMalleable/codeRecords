package cn.mypro.servlet;

import cn.mypro.entity.TeacherType;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.ITeacherTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrBread on 2017/7/14.
 */
public class TeacherTypeServlet extends HttpServlet {
    private ITeacherTypeService teacherTypeService= BeanFactory.getInstance("teacherTypeService",ITeacherTypeService.class);
    private Object uri;

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String method=request.getParameter("method");
        if("addTeacherType".equals(method)){
            addTeacherType(request,response);
        }

        else if("delete".equals(method)){
            delete(request,response);
        }

        else if("list".equals(method)){
            list(request,response);
        }

        else if("viewUpdate".equals(method)){
            viewUpdate(request,response);
        }
        else if("update".equals(method)){
            update(request,response);
        }
        else if("search".equals(method)){
            search(request,response);
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        this.doGet(request,response);
    }
    private void goTo(HttpServletRequest request,HttpServletResponse response,Object uri) throws ServletException,IOException{
        if(uri instanceof RequestDispatcher){
            ((RequestDispatcher)uri).forward(request,response);
        }else if(uri instanceof  String){
            response.sendRedirect(request.getContextPath()+uri);
        }
    }

    public void addTeacherType(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            TeacherType tt=new TeacherType();
            tt.setId(request.getParameter("id"));
            tt.setName(request.getParameter("name"));
            tt.setPassword(request.getParameter("password"));
            tt.setSubject(request.getParameter("subject"));

            teacherTypeService.save(tt);

            uri=request.getRequestDispatcher("/teachertype?method=list");
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void list(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            List<TeacherType> list=teacherTypeService.getAll();
            request.setAttribute("listTeacherType",list);
            uri=request.getRequestDispatcher("/sys/type/teachertype_list.jsp");
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void search(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            String id=request.getParameter("id");
            TeacherType tt=teacherTypeService.findById(id);
            List<TeacherType> list=new ArrayList<TeacherType>();
            list.add(tt);
            request.setAttribute("listTeacherType",list);
            uri=request.getRequestDispatcher("/sys/type/teachertype_list.jsp");
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            TeacherType tt=new TeacherType();
            tt.setId(request.getParameter("id"));
            tt.setName(request.getParameter("name"));
            tt.setPassword(request.getParameter("password"));
            tt.setSubject(request.getParameter("subject"));

            System.out.println(tt.getSubject());
            teacherTypeService.update(tt);

            uri="/teachertype?method=list";
        }catch(Exception e){
            e.printStackTrace();
            uri="error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void delete(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            String id=request.getParameter("id");
            teacherTypeService.delete(id);
            uri="/teachertype?method=list";
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void viewUpdate(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        try {
            String id = request.getParameter("id");
            TeacherType tt = teacherTypeService.findById(id);
            request.setAttribute("teacherType", tt);
            uri = request.getRequestDispatcher("/sys/type/teachertype_update.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            uri = "/error/error.jsp";
        }
        goTo(request,response,uri);
    }
}
