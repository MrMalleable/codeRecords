package cn.mypro.dao.impl;

import cn.mypro.dao.IAdminTypeDao;
import cn.mypro.entity.AdminType;
import cn.mypro.entity.StudentType;
import cn.mypro.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrBread on 2017/7/13.
 */
public class AdminTypeDao implements IAdminTypeDao {
    @Override
    public boolean contains(String name,String password) {
        try {
            String sql = "select * from admin";
            List<AdminType> list=JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<AdminType>(AdminType.class));

            List<String> namelist=new ArrayList<String>();
            List<String> pwdlist=new ArrayList<String>();

            for(AdminType at:list){
                namelist.add(at.getName());
                pwdlist.add(at.getPassword());
            }

            if(namelist.contains(name)&&pwdlist.contains(password)){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
