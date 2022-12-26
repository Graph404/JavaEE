-- 子查询：在一个查询语句中嵌套另一个查询语句
-- 语法1：select 字段名,.... from 表名 where 字段名 (子查询);    居多
-- 语法2：select 字段名,.... from (子查询);     一般都是用于多表查询的时候

-- 1、查询工资大于bruce的员工信息(单行单列)
-- 第一步：查询bruce的工资
select salary from t_employees where first_name = 'bruce';
-- 第二步：查询工资大于6000的员工信息
select * from t_employees where salary > 6000;

-- 子查询实现
select * from t_employees where salary > (select salary from t_employees where first_name = 'bruce');

-- 2、查询与bruce在同一个部门的员工信息(单行单列)
-- 第一步：查询bruce的部门
select DEPARTMENT_ID from t_employees where first_name = 'bruce';
-- 第二步：查询60的部门的员工信息
select * from t_employees where DEPARTMENT_ID = 60;

-- 子查询实现
select * from t_employees where DEPARTMENT_ID = (select DEPARTMENT_ID from t_employees where first_name = 'bruce');




-- 3、查询与King在同一部门的员工信息(多行单例)
-- 第一步：查询King所在的部门
select DEPARTMENT_ID  from t_employees  where last_name = 'king';

-- 子查询实现
select * from t_employees where DEPARTMENT_ID in (select DEPARTMENT_ID  from t_employees  where last_name = 'king');


-- 4、查询工资高于60部门员工工资的员工信息(多行单例)
select salary from t_employees where DEPARTMENT_ID = 60;

-- 高于最高的
select * from t_employees where salary >all (select salary from t_employees where DEPARTMENT_ID = 60);

-- 低于最低的
select * from t_employees where salary <all (select salary from t_employees where DEPARTMENT_ID = 60);

-- 高于最低的
select * from t_employees where salary >any (select salary from t_employees where DEPARTMENT_ID = 60);

-- 低于最高的
select * from t_employees where salary <any (select salary from t_employees where DEPARTMENT_ID = 60);


-- 在where从句后面使用子查询的时候：如果是单行单列那么直接可以直接判断，如果是多行单列的那么要使用in、>all <all >any <any 判断
-- 在from从句后面使用子查询的时候：必须要给子查询取个别名，通常from从句的子查询都是多行多列


-- 查询工资前五员工信息
select * from t_employees order by salary desc limit 0,5;


-- 查询工资前五员工信息(多行多列)
select * from (SELECT * from t_employees order by salary desc) temp limit 0,5



