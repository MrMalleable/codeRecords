package cn.mypro.servlet;

import cn.mypro.entity.SubjectType;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.IScoreTypeService;
import cn.mypro.service.ISubjectTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by MrBread on 2017/7/21.
 */
public class SubjectTypeServlet extends HttpServlet {
    private ISubjectTypeService subjectTypeService= BeanFactory.getInstance("subjectTypeService",ISubjectTypeService.class);
    private IScoreTypeService scoreTypeService=BeanFactory.getInstance("scoreTypeService",IScoreTypeService.class);
    private Object uri;

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String method=request.getParameter("method");
        if("addSubjectType".equals(method)){
            addSubjectType(request,response);
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

    public void addSubjectType(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            SubjectType st=new SubjectType();
            st.setName(request.getParameter("name"));
            st.setStatus(Integer.parseInt(request.getParameter("status")));
            st.setTeacher(request.getParameter("teacher"));
            subjectTypeService.save(st);

            scoreTypeService.addColumn(st.getName(),st.getStatus());

            uri=request.getRequestDispatcher("/subjecttype?method=list");
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void list(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            List<SubjectType> list=subjectTypeService.getAll();
            request.setAttribute("listSubjectType",list);
            uri=request.getRequestDispatcher("/sys/type/subjecttype_list.jsp");
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void search(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            String name=request.getParameter("name");
            SubjectType st=subjectTypeService.findByName(name);
            List<SubjectType> list=new ArrayList<SubjectType>();
            list.add(st);
            request.setAttribute("listSubjectType",list);
            uri=request.getRequestDispatcher("/sys/type/subjecttype_list.jsp");
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            SubjectType st=new SubjectType();
            st.setName(request.getParameter("name"));
            st.setTeacher(request.getParameter("teacher"));
            st.setStatus(Integer.parseInt(request.getParameter("status")));

            subjectTypeService.update(st);

            uri="/subjecttype?method=list";
        }catch(Exception e){
            e.printStackTrace();
            uri="error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void delete(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            String name=request.getParameter("name");
            subjectTypeService.delete(name);
            uri="/subjecttype?method=list";
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void viewUpdate(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        try {
            String name = request.getParameter("name");
            SubjectType st = subjectTypeService.findByName(name);
            request.setAttribute("subjectType", st);
            uri = request.getRequestDispatcher("/sys/type/subjecttype_update.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            uri = "/error/error.jsp";
        }
        goTo(request,response,uri);
    }
}
