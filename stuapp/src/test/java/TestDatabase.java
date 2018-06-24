import cn.stuapp.entity.StudentType;
import cn.stuapp.factory.BeanFactory;
import cn.stuapp.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * 主要是为了测试当使用用username查询的select语句时如果数据库中不对应的记录是否返回的是null
 * Created by MrBread on 2017/7/28.
 */
public class TestDatabase {
    public static void main(String[] args) {
        String sql = "select * from student_info where username='banana'";
        //此时数据库没有banana的用户
        try{
            System.out.println(JdbcUtils.getQueryRunner().query(sql,new BeanHandler<StudentType>(StudentType.class)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
