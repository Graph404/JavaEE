一、设有一数据库，包括四个表：学生表（Student）、课程表（Course）、成绩表（Score）以及教师信息表（Teacher）。四个表的结构分别如表1-1的表（一）~表（四）所示，数据如表1-2的表（一）~表（四）所示。用SQL语句创建四个表并完成相关题目。

表1-1数据库的表结构
表（一）Student (学生表)

属性名			数据类型	可否为空	含 义
Sno				varchar (20)	否		学号（主键）
Sname			varchar (20)	否		学生姓名
Ssex			varchar (20)	否		学生性别
Sbirthday		date			可		学生出生年月
Class			varchar (20)	可		学生所在班级

create table student(
	sno varchar(50) not null,
	sname varchar(50) not null,
	ssex varchar(50) not null,
	sbrithday  date,
	class varchar(50),
	primary key (sno)
);
insert into student values('108','曾华','男','1977-09-01','95033');
insert into student values('105','匡明','男','1975-10-02','95031');
insert into student values('107','王丽','女','1976-01-23','95033');
insert into student values('101','李军','男','1976-02-20','95033');
insert into student values('109','王芳','女','1975-02-10','95031');
insert into student values('103','陆军','男','1974-06-03','95031');

表（二）Course（课程表）

属性名			数据类型	可否为空	含 义
Cno				varchar (20)	否		课程号（主键）
Cname			varchar (20)	否		课程名称
Tno				varchar (20)	否		教工编号（外键）
create table course(
	cno varchar(50) not null,
	cname varchar(50) not null,
	tno varchar(50) references tacher(tno),
	primary key (cno)
);
insert into course values('3-105','计算机导论','825');
insert into course values('3-245','操作系统','804');
insert into course values('6-166','数字电话','856');
insert into course values('9-888','高等数学','831');
表（三）Score(成绩表)

属性名			数据类型	可否为空	含 义
Sno				varchar (20)	否		学号（外键）
Cno				varchar (20)	否		课程号（外键）
Degree			Decimal(4,1)	可		成绩
主键：Sno+ Cno(联合主键)
create table score(
	sno varchar(50) not null,
	cno varchar(50) not null,
	degree decimal(4,1),
	foreign key (sno) references student(sno),
	foreign key (cno) references course(cno)
);
insert into score values('103','3-245',86);
insert into score values('105','3-245',75);
insert into score values('109','3-245',68);
insert into score values('103','3-105',92);
insert into score values('105','3-105',88);
insert into score values('109','3-105',76);
insert into score values('101','3-105',64);
insert into score values('107','3-105',91);
insert into score values('108','3-105',78);
insert into score values('101','6-166',85);
insert into score values('107','6-166',79);
insert into score values('108','6-166',81);
表（四）Teacher(教师表)

属性名			数据类型	可否为空	含 义
Tno				varchar (20)	否		教工编号（主码）
Tname			varchar (20)	否		教工姓名
Tsex			varchar (20)	否		教工性别
Tbirthday		date			可		教工出生年月
Prof			varchar (20)	可		职称
Depart			varchar (20)	否		教工所在部门
create table teacher(
	tno varchar(50) not null,
	tname varchar(50) not null,
	tsex varchar(50) not null,
	tbrithday date,
	prof varchar(50),
	depart varchar(50) not null,
	primary key(tno)
);
insert into teacher values('804','李诚','男','1958-12-02','副教授','计算机系');
insert into teacher values('856','张旭','男','1969-03-12','讲师','电子工程系');
insert into teacher values('825','王萍','女','1972-05-05','助教','计算机系');
insert into teacher values('831','刘冰','女','1977-08-14','助教','电子工程系');

1、 查询Student表中的所有记录的Sname、Ssex和Class列。
2、 查询教师所有的单位即不重复的Depart列。
3、 查询Student表的所有记录。
4、 查询Score表中成绩在60到80之间的所有记录。
5、 查询Score表中成绩为85，86或88的记录。
6、 查询Student表中“95031”班或性别为“女”的同学记录。
7、 以Class降序查询Student表的所有记录。
8、 以Cno升序、Degree降序查询Score表的所有记录。
9、 查询“95031”班的学生人数。
10、查询Score表中的最高分的学生学号和课程号。（子查询或者排序）
11、查询每门课的平均成绩。
12、查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。
13、查询分数大于70，小于90的Sno列。
14、查询所有学生的Sname、Cno和Degree列。
15、查询所有学生的Sno、Cname和Degree列。
16、查询所有学生的Sname、Cname和Degree列。
17、查询“95033”班学生的平均分。
18、假设使用如下命令建立了一个grade表：

create table grade(low  int(3),upp  int(3),rank  char(1));

insert into grade values(90,100,'A');

insert into grade values(80,89,'B');

insert into grade values(70,79,'C');

insert into grade values(60,69,'D');

insert into grade values(0,59,'E');

现查询所有同学的Sno、Cno和rank列。

19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。
20、选了多门课程并且是这个课程下不是最高分的
21、查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录。
22、查询和学号为108、101的同学同年出生的所有学生的Sno、Sname和Sbirthday列。
23、查询“张旭“教师任课的学生成绩。
24、查询选修某课程的同学人数多于5人的教师姓名。
25、查询95033班和95031班全体学生的记录。
26、  查询存在有85分以上成绩的课程Cno.
27、查询出“计算机系“教师所教课程的成绩表。
28、查询“计算 机系”与“电子工程系“不同职称的教师的Tname和Prof。
29、查询选修编号为“3-105“课程且成绩至少高于选修编号为“3-245”的同学的Cno、Sno和Degree,并按Degree从高到低次序排序。
any:代表括号中任意一个成绩就可以
30、查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的Cno、Sno和Degree.
all:代表括号中的所有成绩

31、 查询所有教师和同学的name、sex和birthday.
32、查询所有“女”教师和“女”同学的name、sex和birthday.
33、 查询成绩比该课程平均成绩低的同学的成绩表。
34、 查询所有任课教师的Tname和Depart.
35 、 查询所有未讲课的教师的Tname和Depart.
36、查询至少有2名男生的班号。
37、查询Student表中不姓“王”的同学记录。
38、查询Student表中每个学生的姓名和年龄。
39、查询Student表中最大和最小的Sbirthday日期值。
40、以班号和年龄从大到小的顺序查询Student表中的全部记录。
41、查询“男”教师及其所上的课程。
42、查询最高分同学的Sno、Cno和Degree列。
43、查询和“李军”同性别的所有同学的Sname.
44、查询和“李军”同性别并同班的同学Sname.
45、查询所有选修“计算机导论”课程的“男”同学的成绩表。