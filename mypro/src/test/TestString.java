/**
 * Created by MrBread on 2017/7/21.
 */
public class TestString {
    public static void main(String[] args){
        String japan="japanese";
        String sql="update score set "+japan+"='0'where name=?";
        System.out.println(sql);
    }
}
