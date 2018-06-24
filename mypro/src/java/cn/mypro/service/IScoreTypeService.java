package cn.mypro.service;

/**
 * Created by MrBread on 2017/7/20.
 */
public interface IScoreTypeService {
    void updateScore(String name,String subject,String score);
    void addColumn(String subject,int status);
    void addRecord(String name);
}
