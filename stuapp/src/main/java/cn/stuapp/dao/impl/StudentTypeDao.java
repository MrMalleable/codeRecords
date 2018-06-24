package cn.stuapp.dao.impl;

import cn.stuapp.dao.IStudentTypeDao;
import cn.stuapp.entity.StudentType;
import cn.stuapp.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by MrBread on 2017/7/28.
 */
public class StudentTypeDao implements IStudentTypeDao {

    /**
     * 添加新的学生信息到数据库中
     * @param studentType
     */
    public void save(StudentType studentType) {
        //获取学生基本信息
        String stuid=studentType.getStuid();
        String username=studentType.getUsername();
        String sex=studentType.getSex();
        String academy=studentType.getAcademy();
        String class_in=studentType.getClass_in();
        String pwd=studentType.getPwd();
        String pwd_confirm=studentType.getPwd_confirm();
        String tel=studentType.getTel();
        String contact=studentType.getContact();
        String email=studentType.getEmail();
        String qq=studentType.getQq();
        String address=studentType.getAddress();

        //将该学生信息添加到数据库中
        String sql="insert into student_info(stuid,username,sex,academy,class_in,pwd,pwd_confirm,tel,contact,email,qq,address) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            JdbcUtils.getQueryRunner().update(sql,stuid,username,sex,academy,class_in,pwd,pwd_confirm,tel,contact,email,qq,address);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 更新学生基本信息
     * @param studentType
     */
    public void update(StudentType studentType) {
        //获取学生基本信息
        String stuid=studentType.getStuid();
        String username=studentType.getUsername();
        String sex=studentType.getSex();
        String academy=studentType.getAcademy();
        String class_in=studentType.getClass_in();
        String pwd=studentType.getPwd();
        String pwd_confirm=studentType.getPwd_confirm();
        String tel=studentType.getTel();
        String contact=studentType.getContact();
        String email=studentType.getEmail();
        String qq=studentType.getQq();
        String address=studentType.getAddress();

        //将该学生信息更新到数据库中
        String sql="update student_info set username='"+username+"',sex='"+sex+"',academy='"+academy+"',class_in='"+class_in+"',pwd='"+pwd+"',pwd_confirm='"+pwd_confirm+"',tel='"+tel+"',contact='"+contact+"',email='"+email+"',qq='"+qq+"',address='"+address+"' where stuid='"+stuid+"'";
        System.out.println(sql);
        try{
            JdbcUtils.getQueryRunner().update(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 从数据库中删除学生的基本信息
     * @param stuid
     */
    public void delete(String stuid) {
        String sql="delete from student_info where stuid=?";
        try{
            JdbcUtils.getQueryRunner().update(sql,stuid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 通过学号查找学生基本信息
     * @param stuid
     * @return StudentType
     */
    public StudentType findById(String stuid) {
        String sql="select * from student_info where stuid=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<StudentType>(StudentType.class),stuid);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过学生用户名查找学生基本信息
     * @param username
     * @return StudentType
     */
    public StudentType findByName(String username) {
        String sql="select * from student_info where username=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<StudentType>(StudentType.class),username);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过用户名和密码判断该学生是否在数据库中
     * 主要用于登录判断使用
     * @param username
     * @param pwd
     * @return true代表数据库中有该学生，false代表数据库中无该学生，拒绝其登录
     */
    public boolean contains(String username, String pwd) {
        String sql="select * from student_info where username=? and pwd=?";
        try{
            //如果查找不到数据则会返回null，证明数据库中没有该学生
            if(null==JdbcUtils.getQueryRunner().query(sql,new BeanHandler<StudentType>(StudentType.class),username,pwd)){
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<StudentType> getAll() {
        String sql="select * from student_info";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<StudentType>(StudentType.class));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
