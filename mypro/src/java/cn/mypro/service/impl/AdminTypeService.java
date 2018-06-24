package cn.mypro.service.impl;

import cn.mypro.dao.IAdminTypeDao;
import cn.mypro.entity.AdminType;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.IAdminTypeService;

/**管理员的service
 * Created by MrBread on 2017/7/13.
 */
public class AdminTypeService implements IAdminTypeService{
    private IAdminTypeDao adminTypeDao= BeanFactory.getInstance("adminTypeDao",IAdminTypeDao.class);
    @Override
    public boolean contains(String name,String password) {
        try{
            return adminTypeDao.contains(name,password);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
