package cn.stuapp.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/**
 * 操作数据库的工具类
 * 注意：必须引入c3p0的包
 * Created by MrBread on 2017/7/28.
 */
public class JdbcUtils {
        private static DataSource dataSource;
        static {
            dataSource=new ComboPooledDataSource();
        }

        //获取数据源
        public static DataSource getDataSource(){
            return dataSource;
        }

        //对数据库数据进行操作的queryRunner
        public static QueryRunner getQueryRunner(){
            return new QueryRunner(dataSource);
        }
}

