package cn.stuapp.dao;

import cn.stuapp.entity.ScoreType;

import java.util.List;

/**
 * Created by MrBread on 2017/8/1.
 */
public interface IScoreTypeDao {
    void save(ScoreType scoreType);
    void update(ScoreType scoreType);
    void delete(String username,String subjectid);
    ScoreType findRecord(String username,String subjectid);
    List<ScoreType> findByUsername(String username);
    List<ScoreType> findBySubjectid(String subjectid);
    List<ScoreType> findBySubjectname(String subjectname);
    List<ScoreType> findByTesttime(String testtime);
}
