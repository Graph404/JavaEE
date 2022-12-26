/*
	连表查询：当要查询的结果不在同一张表中
			连表查询的步骤：
				1、确定关联的表
				2、确定关联的关系(消除笛卡尔积)
			在多表查询的时候，字段需要加上表名.字段名。但是如果多张表之间没有重复字段则可以省略
	    再多表查询的时候，会差生笛卡尔积(多找表的数据的乘积)


	等值连接：

  连表查询分类：
			内连接
				 语法1: select 字段名,.... from  左表,右表  where 左表.关联字段 = 右表.关联字段
         语法2：select 字段名,.... from  左表 [inner] join 右表 on 左表.关联字段 = 右表.关联字段 
         
         特点：内连接要求左表与右表的数据互相关联才会被查询出来					
      
      外连接
				 左外连接
            语法：select 字段名,.... from 左表 left join 右表 on 左表.关联字段 = 右表.关联字段 

					特点：左表中的数据都会被查询出来,与之对应的右表的数据用null表示
				 右外连接	
						语法：select 字段名,.... from 左表 right join 右表 on 左表.关联字段 = 右表.关联字段 
					特点：右表中的数据都会被查询出来,与之对应的左表的数据用null表示
 
      全连接(mysql不支持)
				 合并查询：
						union:将多个查询结果进行合并，并去重
						union all:将多个查询结果进行合并,但不去重

					使用合并查询的时候需要注意:
						1、两个查询的结果的数量要一致
						2、两个查询的结果的数据类型要兼容
						
		非等值连接：

		
		表的自连接：
*/

-- 查询员工的姓名、工资、职位、部门名称、部门位置

-- 内连接
select ename, sal, job, dname,location,emp.deptno from emp,dept where emp.deptno = dept.deptno;
select ename,sal,job,dname,location,e.deptno from emp e join dept d on e.deptno = d.deptno;

-- 左外连接
select ename,sal,job,dname,location,e.deptno from emp e left join dept d on e.deptno = d.deptno;

-- 右外连接
select ename,sal,job,dname,location,d.deptno from emp e right join dept d on e.deptno = d.deptno;

-- 模拟全连接
select ename,sal,job,dname,location,e.deptno from emp e left join dept d on e.deptno = d.deptno
union
select ename,sal,job,dname,location,d.deptno from emp e right join dept d on e.deptno = d.deptno;



-- 非等值连接
-- 查询员工的姓名、工资、职位、工资等级
select ename,sal,job,grade from emp e left join salgrade s on e.sal >= s.losal and e.sal <= s.hisal;



-- 查询员工的姓名、工资、职位、部门名称、部门位置、工资等级
select ename,sal,job,dname,location,grade 
		from emp e 
		left join dept d on e.deptno = d.deptno
		left join salgrade s on e.sal between s.losal and s.hisal;
																												
-- 表的自关联
-- 查询员工的姓名、工资、及其经理的姓名和工资

select e1.ename,e1.sal,e2.ename,e2.sal
		from emp e1
		left join emp e2 on e1.mgr = e2.empno
	


select e1.ename,e1.sal,e2.ename,e2.sal
		from emp e1
		left join emp e2 on e1.mgr = e2.empno;



