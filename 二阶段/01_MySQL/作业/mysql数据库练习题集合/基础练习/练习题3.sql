建表：
create table dept
(
deptno varchar(10) primary key,
dname varchar(10)
);
create table emp
(
empno varchar(10) primary key,
ename varchar(10),
job varchar(10),
mgr varchar(10),
sal varchar(10),
deptno varchar(10) references dept(deptno)
);
表数据如下：
insert into dept values ('1','事业部');
insert into dept values ('2','销售部');
insert into dept values ('3','技术部');
insert into dept values ('4','工程部');
insert into emp values ('01','jacky','clerk','tom','1000','1');
insert into emp values ('02','tom','clerk','','2000','1');
insert into emp values ('07','biddy','clerk','','2000','1');
insert into emp values ('03','jenny','sales','pretty','600','2');
insert into emp values ('04','pretty','sales','','800','2');
insert into emp values ('05','buddy','jishu','canndy','1000','3');
insert into emp values ('06','canndy','jishu','','1500','3');
insert into emp values ('08','jacy','clerk','tom','1000','3');

题目：

--1 列出emp表中各部门的部门号，最高工资，最低工资
--2 列出emp表中各部门job为'CLERK'的员工的最低工资，最高工资
--3 对于emp中最低工资小于2000的部门，列出job为'CLERK'的员工的部门号，最低工资，最高工资
--4 根据部门号由高而低，工资有低而高列出每个员工的姓名，部门号，工资
--5 列出'buddy'所在部门中每个员工的姓名与部门号
--6 列出每个员工的姓名，工作，部门号，部门名
--7 列出emp中工作为'CLERK'的员工的姓名，工作，部门号，部门名
--8 对于emp中有管理者的员工，列出姓名，管理者姓名
--9 对于dept表中，列出所有部门名，部门号，同时列出各部门工作为'CLERK'的员工名与工作
