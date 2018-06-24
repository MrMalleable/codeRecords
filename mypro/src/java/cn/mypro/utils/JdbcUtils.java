package cn.mypro.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/**操作数据库的工具类
 * Created by MrBread on 2017/7/12.
 */
public class JdbcUtils {
    private static DataSource dataSource;
    static {
        dataSource=new ComboPooledDataSource();
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static QueryRunner getQueryRunner(){
        return new QueryRunner(dataSource);
    }
}
