package cn.mypro.service.impl;

import cn.mypro.dao.IScoreTypeDao;
import cn.mypro.factory.BeanFactory;
import cn.mypro.service.IScoreTypeService;

/**
 * Created by MrBread on 2017/7/20.
 */
public class ScoreTypeService implements IScoreTypeService{

    private IScoreTypeDao scoreTypeDao= BeanFactory.getInstance("scoreTypeDao",IScoreTypeDao.class);
    @Override
    public void updateScore(String name, String subject,String score) {
       try{
           scoreTypeDao.updateScore(name,subject,score);
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    @Override
    public void addColumn(String subject,int status){
        try{
            scoreTypeDao.addColumn(subject,status);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addRecord(String name) {
        try{
            scoreTypeDao.addRecord(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
