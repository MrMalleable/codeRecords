package cn.mypro.servlet;

import cn.mypro.entity.ClassType;
import cn.mypro.entity.StudentType;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.IClassTypeService;
import cn.mypro.service.IScoreTypeService;
import cn.mypro.service.IStudentTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrBread on 2017/7/12.
 */
public class StudentTypeServlet extends HttpServlet {
    private IStudentTypeService studentTypeService= BeanFactory.getInstance("studentTypeService",IStudentTypeService.class);
    private IClassTypeService classTypeService=BeanFactory.getInstance("classTypeService",IClassTypeService.class);
    private IScoreTypeService scoreTypeService=BeanFactory.getInstance("scoreTypeService",IScoreTypeService.class);
    private Object uri;

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String method=request.getParameter("method");
        if("addStudentType".equals(method)){
            addStudentType(request,response);
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

    public void addStudentType(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            StudentType st=new StudentType();
            st.setId(request.getParameter("id"));
            st.setName(request.getParameter("name"));
            st.setPassword(request.getParameter("password"));
            st.setSex(Integer.parseInt(request.getParameter("sex")));
            st.setAge(Integer.parseInt(request.getParameter("age")));
            st.setPhonenumber(request.getParameter("phonenumber"));
            st.setEmail(request.getParameter("email"));
            st.setIn_which_class(request.getParameter("in_which_class"));

            studentTypeService.save(st);
            scoreTypeService.addRecord(st.getName());
            //对应的需要在班级表中的总人数加1
            ClassType classType=classTypeService.findById(request.getParameter("in_which_class"));
            int num=classType.getMembernums()+1;
            classType.setMembernums(num);
            classTypeService.update(classType);

            uri=request.getRequestDispatcher("/studenttype?method=list");
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void list(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            List<StudentType> list=studentTypeService.getAll();
            request.setAttribute("listStudentType",list);
            uri=request.getRequestDispatcher("/sys/type/studenttype_list.jsp");
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void search(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            String id=request.getParameter("id");
            StudentType st=studentTypeService.findById(id);
            List<StudentType> list=new ArrayList<StudentType>();
            list.add(st);
            request.setAttribute("listStudentType",list);
            uri=request.getRequestDispatcher("/sys/type/studenttype_list.jsp");
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            StudentType st=new StudentType();
            st.setId(request.getParameter("id"));
            st.setName(request.getParameter("name"));
            st.setPassword(request.getParameter("password"));
            st.setSex(Integer.parseInt(request.getParameter("sex")));
            st.setAge(Integer.parseInt(request.getParameter("age")));
            st.setPhonenumber(request.getParameter("phonenumber"));
            st.setEmail(request.getParameter("email"));
            st.setIn_which_class(request.getParameter("in_which_class"));

            studentTypeService.update(st);

            uri="/studenttype?method=list";
        }catch(Exception e){
            e.printStackTrace();
            uri="error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void delete(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            String id=request.getParameter("id");
            studentTypeService.delete(id);
            uri="/studenttype?method=list";
        }catch(Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void viewUpdate(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        try {
            String id = request.getParameter("id");
            StudentType st = studentTypeService.findById(id);
            request.setAttribute("studentType", st);
            uri = request.getRequestDispatcher("/sys/type/studenttype_update.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            uri = "/error/error.jsp";
        }
        goTo(request,response,uri);
    }
}
