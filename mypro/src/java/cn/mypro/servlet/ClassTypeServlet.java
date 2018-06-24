package cn.mypro.servlet;

import cn.mypro.entity.ClassType;
import cn.mypro.entity.TeacherType;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.IClassTypeService;
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
public class ClassTypeServlet extends HttpServlet {
    private IClassTypeService classTypeService= BeanFactory.getInstance("classTypeService",IClassTypeService.class);
    private Object uri;

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String method=request.getParameter("method");
        if("addClassType".equals(method)){
            addClassType(request,response);
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

    public void addClassType(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            ClassType ct=new ClassType();
            ct.setId(request.getParameter("id"));
            ct.setMembernums(Integer.parseInt(request.getParameter("membernums")));
            classTypeService.save(ct);

            uri=request.getRequestDispatcher("/classtype?method=list");
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void list(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            List<ClassType> list=classTypeService.getAll();
            request.setAttribute("listClassType",list);
            uri=request.getRequestDispatcher("/sys/type/classtype_list.jsp");
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void search(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            String id=request.getParameter("id");
            ClassType ct=classTypeService.findById(id);
            List<ClassType> list=new ArrayList<ClassType>();
            list.add(ct);
            request.setAttribute("listClassType",list);
            uri=request.getRequestDispatcher("/sys/type/classtype_list.jsp");
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            ClassType ct=new ClassType();
            ct.setId(request.getParameter("id"));
            ct.setMembernums(Integer.parseInt(request.getParameter("membernums")));

            classTypeService.update(ct);

            uri="/classtype?method=list";
        }catch(Exception e){
            e.printStackTrace();
            uri="error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void delete(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            String id=request.getParameter("id");
            classTypeService.delete(id);
            uri="/classtype?method=list";
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void viewUpdate(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        try {
            String id = request.getParameter("id");
            ClassType ct = classTypeService.findById(id);
            request.setAttribute("classType", ct);
            uri = request.getRequestDispatcher("/sys/type/classtype_update.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            uri = "/error/error.jsp";
        }
        goTo(request,response,uri);
    }
}
