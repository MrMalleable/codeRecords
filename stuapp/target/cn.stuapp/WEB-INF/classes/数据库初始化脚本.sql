drop database stuapp;
-- 创建数据库 stuapp
create database stuapp;
-- 使用数据库stuapp
use stuapp;

-- 创建学生基本信息表,存储学生的基本信息
create table student_info(
-- 学号，主键，自增
stuid  int not NULL auto_increment PRIMARY KEY ,
-- 用户名
username varchar(100),
-- 性别
sex varchar(10),
-- 学院
academy varchar(100),
-- 所属班级
class_in varchar(100),
-- 密码
pwd varchar(100),
-- 确认密码
pwd_confirm varchar(100),
-- 手机号码
tel varchar(100),
-- 紧急联系人
contact varchar(100),
-- 邮箱
email varchar(100),
-- QQ
qq varchar(20),
-- 家庭住址
address varchar(200)
);

-- 设置学号的初始值为100000
alter table student_info auto_increment=100000;

-- 创建课程基本信息表
create table subjects(
-- 课程编号，不为空，主键
subjectid varchar(20) not null primary key ,
-- 课程名称
subjectname varchar(100),
-- 上课时间
starttime varchar(100) ,
-- 考试时间
testtime varchar(100) ,
-- 上课地点
subjectplace varchar(20),
-- 任课老师
teacher VARCHAR(100),
-- 课程容量
capacity int,
-- 已选人数
choosen_num int
);

-- 往学生基本信息表中和课程信息表中分别增加一条记录
insert into student_info(username,sex,academy,class_in,pwd,pwd_confirm,tel,contact,email,qq,address) values("apple","男","计算机学院","软工五班","123","123","18888888888","18388888888","apple@qq.com","123456789","江西吉安市万安县光明村");
insert into subjects(subjectid,subjectname,starttime,testtime,subjectplace,teacher,capacity,choosen_num) values("001324","语文","2017-7-26","2017-12-28","DJ123","Tomcat",50,0);

insert into subjects(subjectid,subjectname,starttime,testtime,subjectplace,teacher,capacity,choosen_num) values("001325","数学","2017-7-26","2017-12-28","DJ125","Orange",50,0);

-- 增加分数表
create table score(
username varchar(100),
subjectid varchar(100),
subjectname varchar(100),
testtime varchar(100),
score varchar(100) default "0"  -- 默认分数为0
);

insert into score(username,subjectid,subjectname,testtime) values("apple","001324","语文","2017-12-28");