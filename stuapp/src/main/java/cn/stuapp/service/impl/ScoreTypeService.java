package cn.stuapp.service.impl;

import cn.stuapp.dao.IScoreTypeDao;
import cn.stuapp.entity.ScoreType;
import cn.stuapp.factory.BeanFactory;
import cn.stuapp.service.IScoreTypeService;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by MrBread on 2017/8/1.
 */
public class ScoreTypeService implements IScoreTypeService {
    private IScoreTypeDao scoreTypeDao= BeanFactory.getInstance("scoreTypeDao",IScoreTypeDao.class);
    public void save(ScoreType scoreType) {
        try{
            scoreTypeDao.save(scoreType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(ScoreType scoreType) {
        try{
            scoreTypeDao.update(scoreType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(String username, String subjectid) {
        try{
            scoreTypeDao.delete(username,subjectid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ScoreType findRecord(String username, String subjectid) {
        try{
            return scoreTypeDao.findRecord(username,subjectid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<ScoreType> findByUsername(String username) {
        try{
            return scoreTypeDao.findByUsername(username);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<ScoreType> findBySubjectid(String subjectid) {
        try{
            return scoreTypeDao.findBySubjectid(subjectid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<ScoreType> findByTesttime(String testtime) {
        try{
            return scoreTypeDao.findByTesttime(testtime);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<ScoreType> findBySubjectname(String subjectname) {
        try{
            return scoreTypeDao.findBySubjectname(subjectname);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
