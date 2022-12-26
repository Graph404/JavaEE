-- 视图：也是一张表，只不过是一张虚拟的表
-- 为什么要用视图呢?

-- 创建视图
-- 语法：create view 视图名称 as (查询语句结果)
create view myemp as (select empno,ename,job,hiredate,deptno from emp);

-- 查询视图
select * from myemp;


-- 修改视图
-- 语法1：create or replace viwe 视图名称 as (查询语句结果)
-- 语法2：alter view 视图名称 as (查询语句结果)

alter view myemp as (select empno,ename,job,mgr,hiredate,deptno from emp);

-- 删除视图
-- 语法：drop view 视图名称
drop view if exists  myemp;

delete from myemp where empno = 7777;

select * from emp;
delete from emp where empno = 7654

select * from myemp;
/*
	视图的使用场景：
			1、当指向给你看到部分数据的时候
			2、当查询比较麻烦的时候，可以将查询的结果查询到视图中。


	视图缺点：
			1、视图不能进行优化
			2、如果使用聚合函数、分组查询、合并查询等得到视图，视图是不能更新(增删改)

*/


