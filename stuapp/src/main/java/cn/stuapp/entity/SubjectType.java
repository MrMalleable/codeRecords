package cn.stuapp.entity;

/**
 * 创建一个课程信息类，与数据库设置的列名对应
 * Created by MrBread on 2017/7/28.
 */
public class SubjectType {
    String subjectid;  //课程编号
    String subjectname; //课程名称
    String starttime; //上课时间
    String testtime; //考试时间
    String subjectplace;  //上课地点
    String teacher;  //任课老师
    int capacity; //课程容量
    int choosen_num; //已选人数

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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getTesttime() {
        return testtime;
    }

    public void setTesttime(String testtime) {
        this.testtime = testtime;
    }

    public String getSubjectplace() {
        return subjectplace;
    }

    public void setSubjectplace(String subjectplace) {
        this.subjectplace = subjectplace;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getChoosen_num() {
        return choosen_num;
    }

    public void setChoosen_num(int choosen_num) {
        this.choosen_num = choosen_num;
    }

}
