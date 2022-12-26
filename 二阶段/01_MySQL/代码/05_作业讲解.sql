-- 1.找出奖金高于工资的雇员
select * from emp where comm > sal;
-- 2.找出奖金高于工资60%的雇员
select * from emp where comm > sal * 0.6;
-- 3.找出部门10中所有经理和部门20中所有店员的信息
select * from emp where (deptno = 10 and job = 'manager') or (deptno = 20 and job = 'CLERK');
-- 4.薪资大于或等于2000的所有员工的信息。
select * from emp where sal >= 2000;
-- 5.查询没有奖金或者奖金低于100的员工信息
select * from emp where comm is null or comm < 100; 
-- 6.查询姓名不带”R”的员工姓名
select * from emp where ename not like '%R%';
-- 7.显示员工的姓名和入职时间，根据入职时间，将最老的员工排放在最前面。
select ename,hiredate from emp order by hiredate;
-- 8.查询所有员工的月薪（工资+奖金）
select ename,sal + ifnull(comm,0) from emp;






-- 1.查询学生平均分
select sname,avg(score) from stuscore group by sname;
-- 2.查询姓名是张三的学生 成绩和
select sname,sum(score) from stuscore where sname = '张三';
-- 3.将学生信息按照 分数倒序
select * from stuscore order by score desc;
-- 4.分别获取学生信息中 分数最低的学生姓名和分数最高的学生姓名
select sname from stuscore where score = (select max(score) from stuscore);
select sname from stuscore where score = (select min(score) from stuscore);

select * from stuscore order by score desc limit 1;
select * from stuscore order by score limit 1;


-- 5.查询两门及两门以上不及格的学生姓名
select sname  from stuscore group by sname having sum(score < 60) >= 2;
select sname  from stuscore where score < 60 group by sname having count(*) >= 2;




-- 参照t_employees表完成一下练习
-- 1. 查询员工表所有数据
-- 2. 查询 email 以 "N " 结尾的员工信息
-- 3. 查询公司里所有的 manager_id(去除重复数据)
-- 4. 按照入职日期由新到旧排列员工信息
-- 5. 按照工资由高到低的顺序显示员工信息
-- 6. 查询职位(JOB_ID)为'ST_CLERK'的员工的工资
-- 7. 查询 50 号部门的员工姓名以及全年工资
-- 8. 查询 80 号部门工资大于 7000 的员工的信息
-- 9. 查询工资高于 7000 但是没有提成的所有员工
-- 10. 查询入职日期在 1992-1-1 到 2012-12-31 之间的所有员工信息  
-- 11. 显示first_name中没有'L'字的员工的详细信息
-- 12. 查询电话号码以 6 开头的所有员工信息
-- 13. 查询 80 号部门中 last_name 以 n 结尾的所有员工信息
-- 14. 查询工资大于4000小于8000的员工信息
-- 15. 查询 first_name 中包含"na"的员工信息.
-- 16. 显示公司里所有员工的工资级别 
-- 级别 工资
-- A <5000
-- B >=5001 and <=8000
-- C >=8001 and <=15000
-- D >15000
-- 17. 根据入职时间打印出员工级别
-- 员工级别 入职时间
-- 资深员工 2000 前（包含 2000）
-- 普通员工 2001~2010（包含 2010）
-- 新员工 2010 年后
-- 18. 请打印出 1992 年入职的员工
-- 19. 把 hire_date 列看做是员工的生日,求本月过生日的员工（可能没有结果）
-- 20. 查询出员工表中最高工资，最低工资，和平均工资


-- 1、根据emp表中的数据完成以下题目
-- 分页查询练习
-- 1、查询工资最高的部门
-- 2、查询工资前五的员工信息
select deptno,sum(sal) from emp group by deptno order by sum(sal) desc limit 1;
select * from emp order by sal desc limit 0,5;


-- 分组查询练习
-- 1、查询每个部门的名称、人数、平均工资
-- 2、查询平均工资高于2000的职位名称以及平均工资
select deptno,count(*),avg(sal) from emp group by deptno;
select avg(sal),job from emp group by job having avg(sal) > 2000;


-- 子查询练习
-- 1、低于平均工资的员工信息
select * from emp where sal < (select avg(sal) from emp);
-- 2、查询公司最早的员工
select * from emp where hiredate = (select min(hiredate) from emp );
-- 3、查询与WARD部门相同，工资相等的员工信息
select sal from emp where ename = 'ward';
select deptno from emp where ename = 'ward';
 
select * from emp where sal = (select sal from emp where ename = 'ward') 
and deptno = (select deptno from emp where ename = 'ward') and ename != 'ward';



-- 子查询中in any all练习
-- 1、查询工资与经理相同的员工信息
select sal from emp where job = 'manager';
select * from emp where sal in (select sal from emp where job = 'manager') and job != 'manager';
-- 2、查询工资比经理高的员工信息
select * from emp where sal >all(select sal from emp where job = 'manager');
select * from emp where sal >any(select sal from emp where job = 'manager');
-- 3、查询工资比经理底的员工信息
select * from emp where sal <all(select sal from emp where job = 'manager');
select * from emp where sal <any(select sal from emp where job = 'manager');













