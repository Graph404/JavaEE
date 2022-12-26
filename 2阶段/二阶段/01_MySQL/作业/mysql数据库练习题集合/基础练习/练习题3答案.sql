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
SELECT DEPTNO,MAX(SAL) MAX_SAL,MIN(SAL) MIN_SAL FROM EMP GROUP BY DEPTNO;
--2 列出emp表中各部门job为'CLERK'的员工的最低工资，最高工资
SELECT DEPTNO,MAX(SAL) MAX_SAL,MIN(SAL) MIN_SAL FROM EMP WHERE JOB = 'CLERK' GROUP BY DEPTNO;
--3 对于emp中最低工资小于2000的部门，列出job为'CLERK'的员工的部门号，最低工资，最高工资
SELECT DEPTNO,MAX(SAL) MAX_SAL,MIN(SAL) MIN_SAL,JOB FROM EMP WHERE JOB = 'CLERK' AND SAL < 2000 GROUP BY DEPTNO;
--4 根据部门号由高而低，工资有低而高列出每个员工的姓名，部门号，工资
SELECT ENAME,DEPTNO,SAL FROM EMP ORDER BY DEPTNO DESC,SAL;
--5 列出'buddy'所在部门中每个员工的姓名与部门号
SELECT ENAME,DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BUDDY');
--6 列出每个员工的姓名，工作，部门号，部门名
SELECT E.ENAME,E.JOB,E.DEPTNO,D.DNAME FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO;
--7 列出emp中工作为'CLERK'的员工的姓名，工作，部门号，部门名
SELECT E.ENAME,E.JOB,E.DEPTNO,D.DNAME FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.JOB = 'CLERK';
--8 对于emp中有管理者的员工，列出姓名，管理者姓名（管理者外键为mgr）
SELECT ENAME,MGR FROM EMP WHERE MGR != '';
SELECT ENAME,MGR FROM EMP WHERE MGR NOT IN ('');
--9 对于dept表中，列出所有部门名，部门号，同时列出各部门工作为'CLERK'的员工名与工作
SELECT E.ENAME,E.JOB,E.DEPTNO,D.DNAME FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.JOB = 'CLERK';
