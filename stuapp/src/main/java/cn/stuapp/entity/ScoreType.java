package cn.stuapp.entity;

/**
 * 创建分数类，用于学生各科分数的保存
 * Created by MrBread on 2017/8/1.
 */
public class ScoreType {
    String username;  //学生姓名
    String subjectid; //课程编号
    String subjectname; //课程名称
    String testtime;  //考试时间
    int score;  //分数
    //状态的话直接在jsp页面判断score来显示是已通过还是未通过


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getTesttime() {
        return testtime;
    }

    public void setTesttime(String testtime) {
        this.testtime = testtime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
