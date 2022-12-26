-- 一、基本查询
-- 语法：select 字段名1,字段名2,... from 表名;
-- 语法：select * from 表名;    *表示所有列

-- 1、查询所有的人的姓名和工资
select first_name,last_name,salary from t_employees;
-- 2、查询所有员工的信息
select * from t_employees;

-- 在查询的过程中可以进行四则运算
-- 1、查询所有员工的年薪
select last_name,first_name,salary*12 from t_employees;
-- 2、计算员工的月薪(考虑绩效)
-- ifnull(判断的值,如果值为null返回结果)
select last_name,first_name,salary + salary * ifnull(commission_pct,0) from t_employees;
-- 3、查询员工的日薪
select last_name,first_name,salary/22 from t_employees;
-- 4、查询员工的月薪(社保800)
select last_name,first_name,salary - 800 from t_employees;




-- 二、别名查询
-- 应用场景：1、当字段名或者表名过长  2、当多表中有重复字段名        别名用于字段名和表名
-- 语法：select 字段名 as 别名,....字段名 as 别名,.... from 表名
-- as关键字可以省略不写

-- select last_name as  lastName,first_name as firstName,salary + salary * ifnull(commission_pct,0) as sal  from t_employees;
select last_name lastName,first_name firstName,salary + salary * ifnull(commission_pct,0) sal  from t_employees;


select * from t_employees as emp;


-- 三、去重查询
-- 语法1： select distinct 去重字段 form 表名
-- 语法2： select distinct 去重字段1,去重字段2,.. form 表名

-- 1、查询所有的部门
select distinct department_id from t_employees;

-- 2、按照工资、部门、职业去重查询
select distinct salary,department_id,job_id from t_employees;



-- 四、排序查询
-- 语法1：select 字段名1,... from 表名 order by 排序的字段 排序规则
-- 语法2：select 字段名1,... from 表名 order by 排序的字段1 排序规则,排序的字段2 排序规则,...

-- 排序规则：升序：asc(默认)   降序：desc

-- 1、查询所有的员工,按照工资降序查询
select * from t_employees order by salary desc;

-- 2、查询所有的员工,按照工资降序查询，如果工资一样，按照入职排序升序
select * from t_employees order by salary desc,hire_date;



-- 五、条件查询
-- 语法： select 字段1,... from 表名  where 过滤条件
/*
  1、关系条件 
	    >    <   >=    <=    =   !=   <>
  2、逻辑条件
      and  or  not  
  3、区间条件     
      between 起始值  and  结束值       包括起始值和结束值
  4、枚举条件
			in(值1,值2,...)   not in(值1,值2,...)
  5、null值条件
			is null     is not null
  6、模糊条件
			like      not like

		  通配符：
				%：表示0个或多个任意字符  
        _：表示1个任意字符

*/
-- 1、查询工资大于12000的员工信息
select * from t_employees where salary >= 12000;
-- 2、查询1998年10月份之前入职的员工
select * from t_employees where hire_date < '1998-10-01';
-- 3、查询不是50部门的员工信息
select * from t_employees where department_id != 50;
select * from t_employees where department_id <> 50;


-- 4、查询工资在8000到12000之间的员工信息
select * from t_employees where salary >= 8000 and salary <= 12000;
-- 5、查询50、70、110部门的员工信息
select * from t_employees where department_id = 50 or department_id = 70 or department_id = 110;
-- 6、查询不是50部门的员工信息
select * from t_employees where not department_id = 50;


-- 7、查询工资在8000到12000之间的员工信息
select * from t_employees where salary  between 8000 and 12000;
-- 8、查询在1993年到1995年之间入职的员工信息
select * from t_employees where hire_date between '1993' and '1995';


-- 9、查询50、70、110部门的员工信息
select * from t_employees where department_id in (50,70,110);
-- 10、查询不是50、70、110部门的员工信息
select * from t_employees where not department_id in (50,70,110);
select * from t_employees where department_id not in (50,70,110);



-- 11、查询没有绩效的员工信息
-- select * from t_employees where commission_pct = null;   -- 错误示范
select * from t_employees where commission_pct is null;
-- 12、查询有绩效的员工信息
select * from t_employees where commission_pct is not null;


-- 13、查询last_name中带m的员工信息
select * from t_employees where last_name like '%m%'; 
-- 14、查询last_name中第二个字母为a的员工信息
select * from t_employees where last_name like '_a%';

-- 15、查询last_name中带'm'且姓名长度大于7的员工信息
select * from t_employees where last_name like '%m%' and last_name like '%_______%'; 


-- 六、分支查询
/*
	case 
		when 条件1 then 结果1
		when 条件2 then 结果2
		when 条件3 then 结果3
		when 条件4 then 结果4
    else 结果5
	end 

*/

-- 16、查询所有的额员工工资，按照工资分等级A类、B类、...
select salary,
          case 
						when salary > 12000 then 'A类'
						when salary > 8000 then 'B类'
						when salary > 5000 then 'C类'
						when salary > 3000 then 'D类'
						else 'E类'
					end
from t_employees;




-- MySQL函数
-- 时间函数

-- 获取系统当前日期+时间
select sysdate() from dual;
select now();

-- 获取当前日期
select curdate();

-- 获取当前时间
select curtime();

-- 获取指定日期的年份
select year(hire_date) from t_employees;
select year(sysdate());


-- 计算两个日期之间的天数
select datediff(now(),'2020-01-20');

-- 在指定日期上添加或减少天数
select adddate(sysdate(),11);
select adddate(sysdate(),-10);


-- 字符串函数(了解)
-- 字符串拼接函数
-- select 'hello' + "world";  -- 错误示范
select concat('hello','world');
select concat('hello','world',"你好","世界");
select concat("%",'java',"%");

-- 聚合函数
-- sum()函数   求和
-- 1、查询公司一个月要支出多少钱
select sum(salary + ifnull(commission_pct,0)*salary) from t_employees;
-- max()函数   求最大
-- 2、查询公司最高工资
select max(salary) from t_employees;
-- min()函数   求最小
-- 3、查询公司最低工资
select min(salary) from t_employees;
-- avg()函数   求平均
-- 4、查询公司平均工资
select avg(salary) from t_employees;

-- count()函数 求个数
-- count(*)函数不会统计所有列都为null的员工信息
-- count(1)函数不会统计所有列都为null的员工信息
-- count(department_id)函数不会统计department_id列为null的员工信息

-- 5、查询公司总人数
select count(*)  from t_employees;
select count(1)  from t_employees;
-- 6、查询有绩效的员工个数
select count(commission_pct) from t_employees;



-- 七、分组查询
-- 语法1：select 字段1,... from 表名 group by 分组字段
-- 语法2：select 字段1,... from 表名 group by 分组字段 having 分组过滤条件


-- 1、查询每一个部门的平均工资
select department_id,avg(salary)  from t_employees group by department_id;

-- 2、查询每一个部门的员工人数
select department_id,count(*) from t_employees group by department_id;

-- 3、查询平均工资大于9000的部门的平均工资
-- select department_id,avg(salary) from t_employees where avg(salary) > 9000  group by department_id; -- 错误示范

select department_id,avg(salary) from t_employees group by department_id having avg(salary) > 9000;


-- 4、查询工资大于9000的员工的部门的平均工资
select department_id,avg(salary) from t_employees where salary > 9000 group by department_id;


/*
	where和having的区别(都是用于过滤条件)
    1、where中不能使用聚合函数，having中可以
    2、where是在分组之前过滤，having是在分组之后过滤
		3、where可以单独使用。having必须要与group by一起使用
*/


-- 八、分页查询(限定查询)
-- 语法1： select 字段名1,.. from 表名 limit m;       m：表示查询的条数(默认从0开始)
-- 语法2： select 字段名1,.. from 表名 limit n,m;     n：表示查询的起始位置(从0开始)  m：表示查询的条数

-- 1、查询前五条数据（第一页）
select * from t_employees limit 5;
select * from t_employees limit 0,5;

-- 2、查询6~10条数据（第二页）
select * from t_employees limit 5,5;

-- 2、查询11~15条数据（第三页）
select * from t_employees limit 10,5;

/*
	 分页公式：   页码pageNum   每一页的条数pageSize 5
			
			select * from 表名 limit (pageNum-1)*pageSize,pageSize


*/



-- 九、单表查询总结
/*
	   SQL查询语句：
				编写顺序             执行顺序
					select              ⑤select             
          from                ①from
          where               ②where
          group by            ③group by
          having              ④having
          order by            ⑥order by
          limit               ⑦limit
*/











-- 注意1：mysql数据库不区分大小写,也不区分单双引号
-- 注意2：mysql中，任何数据与null计算的结果为null 
-- 注意3：mysql中，不能直接使用%做取余运算，因为%有别的含义
-- 注意4：mysql中，日期类型可以使用'yyyy-MM-dd'格式的字符串表示
-- 注意5：mysql中，null值不能使用=和!=来判断，而应该使用is null和is not null来判断
-- 注意6：mysql中，使用聚合函数查询，就不要再查询聚合函数以外的字段了，因为没有意义
-- 注意7：mysql中，聚合函数不能是where从句后面使用
