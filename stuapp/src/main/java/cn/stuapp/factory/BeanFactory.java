package cn.stuapp.factory;

import java.util.ResourceBundle;

/**工厂生成dao和service对象
 * Created by MrBread on 2017/7/28.
 */
public class BeanFactory {
    private static ResourceBundle bundle;
    static{
        bundle=ResourceBundle.getBundle("instance");
    }

    public static <T> T getInstance(String key,Class<T> clazz){
        String className=bundle.getString(key);
        try{
            return (T)Class.forName(className).newInstance();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
