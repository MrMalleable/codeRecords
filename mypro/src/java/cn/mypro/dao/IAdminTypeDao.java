package cn.mypro.dao;

import cn.mypro.entity.AdminType;

/**管理员的dao接口
 * Created by MrBread on 2017/7/13.
 */
public interface IAdminTypeDao {
    /**
     *判断该用户是否在数据库中
     * @param name,password
     */
    boolean contains(String name,String password);
}
