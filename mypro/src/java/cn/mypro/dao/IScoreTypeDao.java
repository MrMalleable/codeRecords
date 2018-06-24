package cn.mypro.dao;

/**
 * Created by MrBread on 2017/7/20.
 */
public interface IScoreTypeDao {
    /**
     * 在分数表中添加给科目更新分数，选修课的话如果该学生未选，则默认为-1,选择之后则更新为“0”
     * @param subject,name name代表学生学号
     */
    void updateScore(String name,String subject,String score);

    /**
     *每当增加一门新的课程时就必须在分数表里增加一列，默认的值为-1
     * @param
     */
    void addColumn(String subject,int status);
    //删除了一门课程的话在分数表的该列就应该被删除
    //void deleteColumn(String subject);

    void addRecord(String name);

    //如果删除了一个学生的话那么在分数表中该学生的所有分数记录应该被删除
    //void deleteRecord(String name);
}
