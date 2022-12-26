### 一、引言

#### 1.1 现有的数据存储方式有哪些？

> * Java程序存储数据（变量、对象、数组、集合），数据保存在内存中，属于瞬时状态存储。
>
> * 文件（File）存储数据，保存在硬盘上，属于持久状态存储。

#### 1.2 以上存储方式存在哪些缺点？

> * 没有数据类型的区分。
>
> * 存储数据量级较小。
>
> * 没有访问安全限制。
>
> * 没有备份、恢复机制。



### 二、数据库【了解】

#### 2.1 概念

> 数据库是“按照数据结构来组织、[存储和管理数据的仓库]()。是一个长期存储在计算机内的、有组织的、有共享的、统一管理的数据集合。

#### 2.2 数据库分类

> * 网状结构数据库：美国通用电气公司IDS（Integrated Data Store），以节点形式存储和访问。
> * 层次结构数据库：IBM公司IMS（Information Management System）定向有序的树状结构实现存储和访问。
> * 关系结构数据库：Oracle、DB2、MySQL、SQL Server，以表格（Table）存储，多表间建立关联关系，通过分类、合并、连接、选取等运算实现访问。
> * 非关系型数据库：ElastecSearch、MongoDB、Redis，多数使用哈希表，表中以键值（key-value）的方式实现特定的键和一个指针指向的特定数据。



### 三、数据库管理系统【了解】

#### 3.1 概念

> ​	[数据库管理系统]()（DataBase Management System，DBMS）：指一种操作和管理数据库的大型软件，用于建立、使用和维护数据库，对数据库进行统一管理和控制，以保证数据库的安全性和完整性。用户通过数据库管理系统访问数据库中的数据。

#### 3.2 常见的数据库系统

> * Oracle：被认为是业界目前比较成功的关系型数据库管理系统。Oracle数据库可以运行在UNIX、Windows等主流操作系统平台，完全支持所有的工业标准，并获得最高级别的ISO标准安全性认证。
> * DB2：IBM公司的产品，DB2数据库系统采用多进程多线索体系结构，其功能足以满足大中公司的需要，并可灵活地服务于中小型电子商务解决方案。
> * SQL Server：Microsoft 公司推出的关系型数据库管理系统。具有使用方便可伸缩性好与相关软件集成程度高等优点。
> * SQLLite:应用在手机端的数据库。



### 四、MySQL【了解】

#### 4.1  简介

> ​	MySQL是一个[关系型数据库管理系统]()，由瑞典MySQL AB 公司开发，属于 Oracle 旗下产品。MySQL 是最流行的关系型数据库管理系统之一，在 WEB 应用方面，MySQL是最好的 RDBMS(Relational Database Management System，关系数据库管理系统) 应用软件之一。

#### 4.2 下载与安装【重要】

> 官方网站：https://www.mysql.com/
>
> 下载地址：https://dev.mysql.com/downloads/mysql/

> 安装详看安装文档

#### 4.3 配置环境变量【重要】



### 五、SQL语言

#### 5.1 概念

> ​	SQL（Structured Query Language）结构化查询语言，用于存取数据、更新、查询和管理关系数据库系统的程序设计语言。
>
> [经验：通常执行对数据库的“增删改查”，简称C（Create）R（Read）U（Update）D（Delete）。]()

#### 5.2 数据库操作命令【了解】

```mysql
-- 单行注释
# 单行注释
/*
	多行注释
*/
-- 数据操作命令

-- 连接数据库
-- mysql -u用户名 -p用户密码 -h主机ip地址
mysql -uroot -p123456

-- 断开连接
quit;

-- 查看所有数据库
show databases;

-- 创键数据库
-- create database 数据库名
create database db001;
-- create database 数据库名 character set 编码名称
create database db002 character set gbk;
-- create database if not exists 数据库名
create database if not exists db001;


-- 查看数据库的创建信息
-- show create database 数据库名
show create database db001;


-- 删除数据库
-- drop database 数据库名;
drop database db001;
-- drop database if exists 数据库名
drop database if exists db001;

-- 修改数据库
-- alter database 数据库名 character set 新的编码
alter database db002 character set utf8; 


-- 查看当前使用的数据库
select database();

-- 使用数据库
-- use 数据库名
use db002;
```



### 六、客户端工具

#### 6.1 Navicat

> [Navicat是一套快速、可靠并价格相宜的数据库管理工具，专为简化数据库的管理及降低系统管理成本而设。]()它的设计符合数据库管理员、开发人员及中小企业的需要。Navicat 是以直觉化的图形用户界面而建的，让你可以以安全并且简单的方式创建、组织、访问并共用信息。

#### 6.2 SQLYog

> [MySQL可能是世界上最流行的开源数据库引擎，但是使用基于文本的工具和配置文件可能很难进行管理。]()SQLyog提供了完整的图形界面，即使初学者也可以轻松使用MySQL的强大功能。其拥有广泛的预定义工具和查询、友好的视觉界面、类似 Excel 的查询结果编辑界面等优点。

#### 6.3 Navicat的安装和使用

> 参考文档



### 七、数据查询【重要】

#### 7.1 数据库表的基本结构

> 关系结构数据库是以表格（Table）进行数据存储，表格由“行”和“列”组成
>
> [经验：执行查询语句返回的结果集是一张虚拟表]()。

#### 7.2 基本查询

> 语法：[SELECT  列名 FROM 表名]()

```sql
-- 基本查询

-- 查询 select 列名,...| * from 表名

-- 1、查询员工姓名和工资
select last_name,salary from t_employees;
-- 2、查询员工的所有信息    *表示所有的列(在实际开发中不能使用*)
select * from t_employees;


-- 在基本查询中可以进行四则运算
-- 1、查询所有员工的年薪(月薪*12)
select last_name,salary*12 from t_employees;
-- 2、查询所有员工的月薪(扣除社保-800)
select last_name,salary-800 from t_employees
-- 3、查询所有员工的月薪(扣除社保-800+绩效)
-- ifnull(判断的字段值,如果为null的结果)
select last_name,salary*IFNULL(commission_pct,0)+salary-800 from t_employees
-- 4、查询所有的员工的时薪
select last_name,salary/22/8 from t_employees;

-- 注意：mysql中%有别的含义，不能在四则中使用
```

#### 7.3 别名查询

```mysql
-- 别名查询    
-- 一般用于列名和表名。1、当列名过长或者多表的字段名重复  2、表名使用别名进行区分
-- 语法： select 列名 as 别名,..... from 表名;   as是可以省略不写
select first_name as '名',last_name as '姓' from t_employees;
select first_name fn,last_name ln from t_employees;

select last_name,salary*IFNULL(commission_pct,0)+salary-800 salary from t_employees

select * from t_employees emp;
```

#### 7.4 去重查询

```sql
-- 去重查询
-- 语法：select distinct 去重字段 from 表名
-- 查询所有的部门   （按照一个字段进行去重）

select distinct department_id from t_employees; 
-- 按照工资、部门、职位 （按照多个字段进行去重）

select DISTINCT salary,department_id,job_id  from t_employees; 
```

#### 7.5 排序查询

```mysql

-- 排序查询
-- 语法：select 列名,....|* from 表名 order by 排序字段 排序的规则
-- 语法：select 列名,....|* from 表名 order by 排序字段 排序的规则,排序字段 排序的规则,...
-- 排序规则： asc 升序(默认) desc 降序

-- 1、按照员工工资进行降序排序
select last_name,salary from t_employees order by salary desc;
select last_name,salary from t_employees order by salary;


-- 2、按照员工工资进行降序排序,如果工资相等按照入职日期升序排序
select last_name,salary,hire_date from t_employees order by salary desc, hire_date;
```

#### 7.6 条件查询

> [语法： select * from  表名  where   查询条件]()

```mysql
-- 条件查询
-- 语法： select 列名,...|* from 表名 where 过滤条件
/*
	关系条件：
		> < >= <= = != <>
  逻辑条件：
		and or not
  区间条件：  （包含起始值和结束值）
	   between  起始值  and   结束值
  枚举条件
		 in(值1,值2,...)
		 not in(值1,值2,...)
   
	非空条件  （sql中null的不能使用=或者!=进行判断）
		 is null      is not null

  模糊条件
     like       not like
		 占位符：
					%: 表示0个或者多个字符  
					_：表示一个字符
*/
```

```sql
-- 1、查询工资大于10000的员工信息
select * from t_employees where salary > 10000
-- 2、查询不是销售的员工信息
select * from t_employees where job_id <> "sa_man"
-- 3、查询steven的员工信息
select * from t_employees where first_name = 'steven';


-- 4、查询1998年以后入职，且工资大于8000的员工信息
select * from t_employees where hire_date > '1998-01-01' and salary > 8000;

-- 5、查询不是30部门的员工信息
select * from t_employees where not department_id = 30

-- 6、查询50、60、90部门的员工信息
select * from t_employees where department_id = 50 or department_id = 60 or department_id = 90


-- 7、查询工资在8000到12000的员工信息
select * from t_employees where salary between 8000 and 12000;
select * from t_employees where salary >= 8000 and salary <= 12000;


-- 8、查询30、40、70部门的员工信息
select * from t_employees where department_id in(30,40,70)


-- 9、查询没有绩效的员工信息
select * from t_employees where commission_pct = null;
select * from t_employees where commission_pct is null;

select * from t_employees where not commission_pct is not null;

-- 10、查询有绩效的员工信息
select * from t_employees where commission_pct is not null;

-- 11、查询last_name名字中带'en'的员工
select * from t_employees where last_name like '%en%'

-- 12、查询last_name中以'La'的员工信息
select * from t_employees where last_name like 'la%'

-- 13、查询last_name中第二个和第三个字符为'in'的员工信息
select * from t_employees where last_name like '_in%'


-- 14、查询last_name中带's'且名称长度大于6
select * from t_employees where last_name like '%s%' and last_name like '%_______%'
```

#### 7.7 分支查询

```sql
-- 分支结构查询
/*
	case
		when 条件1 then 结果1
		when 条件2 then 结果2
		when 条件3 then 结果3
		else 结果4	
	end
*/
-- 15、查询员工工资，按照工资分等级，A、B、C、D、E
select 
		salary,
		case 
			when salary > 12000 then 'A类'
			when salary > 8000  then 'B类'
			when salary > 5000  then 'C类'
			when salary > 3000  then 'D类'
			else 'E类'	
    end
from t_employees
```

#### 7.8 时间函数

> 语法：SELECT [时间函数([参数列表]) ]()
>
> [经验：执行时间函数查询，会自动生成一张虚表（一行一列）]()

| 时间函数              | 描述                                   |
| --------------------- | :------------------------------------- |
| SYSDATE()             | 当前系统时间（日、月、年、时、分、秒） |
| CURDATE()             | 获取当前日期                           |
| CURTIME()             | 获取当前时间                           |
| WEEK(DATE)            | 获取指定日期为一年中的第几周           |
| YEAR(DATE)            | 获取指定日期的年份                     |
| HOUR(TIME)            | 获取指定时间的小时值                   |
| MINUTE(TIME)          | 获取时间的分钟值                       |
| DATEDIFF(DATE1,DATE2) | 获取DATE1 和 DATE2 之间相隔的天数      |
| ADDDATE(DATE,N)       | 计算DATE 加上 N 天后的日期             |

```mysql
-- 日期函数
-- 获取系统当前日期
select sysdate();
-- 获取系统当前日期
select now();

-- 获取系统当前日期(不包含时间)
select curdate();
-- 获取系统当前时间
select curtime();

-- 获取指定日期中的年份
select year('2021-09-15');

-- 计算两个日期相隔天数
select datediff('2021-09-15','2021-06-10');

-- 在指定的日期基础上添加指定的天数
select ADDDATE(now(),10);
```

#### 7.9 字符串函数

> 语法： SELECT [字符串函数 ([参数列表])]()

| 字符串函数                 | 说明                                                  |
| -------------------------- | ----------------------------------------------------- |
| CONCAT(str1,str2,str....)  | 将 多个字符串连接                                     |
| INSERT(str,pos,len,newStr) | 将str 中指定 pos 位置开始 len 长度的内容替换为 newStr |
| LOWER(str)                 | 将指定字符串转换为小写                                |
| UPPER(str)                 | 将指定字符串转换为大写                                |
| SUBSTRING(str,num,len)     | 将str 字符串指定num位置开始截取 len 个内容            |


```mysql
-- 字符串函数
select 'hello' + 'world'; -- 错误
-- concat 函数拼接字符串
select concat('hello','world');
select concat('%','手机','%');

-- 字符串替换函数 参数1：原始字符串  参数2：起始位置(从1开始) 参数3：替换的长度 参数4：替换的内容
select insert('helloworld',6,5,'mysql')

select lower('HELLO');
select upper('hello');
 
-- 字符串截取函数   参数1：原始字符串，参数2：起始位置 参数3：截取的长度
select substring('hello,java123',7,4);

```

#### 7.10 聚合函数

> 语法：SELECT [聚合函数(列名)]() FROM 表名;
>
> [经验：对多条数据的单列进行统计，返回统计后的一行结果。]()


| 聚合函数 | 说明                     |
| -------- | ------------------------ |
| SUM()    | 求所有行中单列结果的总和 |
| AVG()    | 平均值                   |
| MAX()    | 最大值                   |
| MIN()    | 最小值                   |
| COUNT()  | 求总行数                 |

```mysql
-- 聚合函数
-- sum函数求和
select sum(salary+salary*ifnull(commission_pct,0)) from t_employees;
-- max函数求最大值
select max(salary) from t_employees;
-- min函数求最小值
select min(salary) from t_employees;
-- avg函数求平均值
select avg(salary) from t_employees;
-- count函数求个数  *表示所有列  count函数只会统计不为null的数据
select count(*) from t_employees;
select count(1) from t_employees;
select count(commission_pct) from t_employees;
```

#### 7.11 分组查询

> [语法：SELECT 列名 FROM 表名 WHERE 条件  GROUP BY 分组字段 [having 分组过滤条件];]()

```mysql
-- 分组查询
-- 语法：select 列名,..|* from 表名  group by 分组字段
-- 语法：select 列名,..|* from 表名  group by 分组字段 having 分组过滤条件

-- 分组查询之后只能查询分组字符和使用聚合函数，即不能查询分组字段之外的字段

-- 1、查询每个部门的平均工资
select department_id,avg(salary) from t_employees group by department_id;

-- 2、查询平均工资大于9000的部门信息
-- select department_id,avg(salary) from t_employees where avg(salary) >9000 group by department_id;


select department_id,avg(salary) from t_employees group by department_id having avg(salary) >9000;

-- 3、查询工资大于9000的员工部门的平均工资
select department_id,avg(salary) from t_employees where salary >9000 group by department_id;
```

> [注意：分组查询之后只能查询分组字符和使用聚合函数，即:不能查询分组字段之外的字段(没有意义)]()

> [where 和 having 的区别]()
>
> - [都是用于条件过滤]()
> - [1、where中不能使用聚合函数，而having中可以]()
> - [2、where是在分组之前过滤，而having分组之后过滤]()
> - [3、where可以单独使用，having必须要在分组从句中使用]()

#### 7.12 分页查询

> [SELECT 列名 FROM 表名 LIMIT 起始行，查询行数]()

```mysql
-- 限定查询
-- 语法：select 列名,..|* from 表名 limit m       m:表示查询的条数(默认从第一条数据开始)
-- 语法：select 列名,..|* from 表名 limit n,m     n:表示起始位置(从0开始)       m:表示查询的条数 

-- 查询前5条数据
select * from t_employees limit 5;
select * from t_employees limit 0,5;  -- 1

-- 查询6~10条数据
select * from t_employees limit 5,5;  -- 2

-- 查询11~15条数据
select * from t_employees limit 10,5; -- 3

```

> [分页公式：当前页 curPage   每页条数  pageSize]()
>
> [分页公式：select * from 表名 limit (curPage-1)*pageSize,pageSize;]()

#### 7.13 基础查询总结

```sql
/*
	基本查询总结：
    	SQL编写顺序            	SQL执行顺序
		select                  ⑤select
    	from                    ①from
    	where                   ②where
		group by              	③group by
    	hvaing                  ④hvaing
    	order by                ⑥order by
    	limit                   ⑦limit
*/
```

> [注意：]()
>
> - [mysql中不区分大小写。不区分单双引号]()
> - [在mysql中任何数据与null计算得到的结果是null]()
> - [在mysql中空值判断只能使用is null 或者是 is not null判断]()
> - [mysql日期类型可以使用'yyyy-MM-dd'表示]()
> - [mysql数值类型和字符串类型是可以自动转换]()



### 八、子查询【重要】

> - 子查询将查询结果放在where 从句 和  from 从句后使用

#### 8.1 子查询作为where条件

> SELECT 列名 FROM 表名  [Where 条件 (子查询结果)]()

```mysql
-- 1、查询工资大于bruce的员工信息
-- 第一步：查询bruce的工资
select salary from t_employees where first_name = 'bruce';
-- 第二步：查询大于上面结果的员工信息
select * from t_employees where salary > 6000;
-- 子查询写法
select * from t_employees where salary > ( select salary from t_employees where first_name = 'bruce')

-- 2、查询与bruce同一个部门的员工信息(单个)

-- 3、查询与king同一个部门的员工信息(多个)
-- 第一步：查询king所在的部门
select department_id from t_employees where last_name = 'king';
-- 第二步：查询80、90部门的员工信息
select * from t_employees where department_id in (80,90)
-- 子查询写法
select * from t_employees where department_id in (select department_id from t_employees where last_name = 'king')

-- 4、查询工资高于60部门所有员工的员工信息(高于最高)
select salary from t_employees where department_id = 60
select * from t_employees where salary >all (select salary from t_employees where department_id = 60)

-- 5、查询工资高于60部门员工的员工信息(高于最低)
select * from t_employees where salary >any (select salary from t_employees where department_id = 60)
```

#### 8.2 子查询作为from查询

> SELECT 列名 FROM[（子查询的结果集）]()WHERE 条件;

```mysql
-- 6、查询工资前五的员工信息
select * from t_employees order by salary desc
-- 子查询写法
select * from (select * from t_employees order by salary desc) temp limit 0,5
```

> 总结：
>
> - 子查询可用在from从句或者where从句后面使用
>   - 单行单列结果：一般用于where后面，直接做判断
>   - 多行单列结果：一般用于where后面，in、>all、>any
>   - 多行多列结果：一般用于from后面       [ 注意：必须要给子查询取别名]()



### 九、 连接查询【重要】

> [当需要查询的字段在不同的表中，那么需要进行连接查询]()
>
> - 连接查询分类：	
>   - 内连接
>   - 外连接
>   - 全连接(mysql不支持)
>
> [注意：如果对表直接进行连接查询，会产生笛卡尔积]()

```mysql
/*
   当查询数据不在同一张表中，那么需要使用连表查询
		1、确定关联表
		2、确定表的关系(消除笛卡尔积)
  注意：多表连接查询的时候，会产生笛卡尔积(多张表的数据的乘积)

 等值连接
  连表查询
	 内连接
		 只有左表和右表中的数据之间互相的关联的数据才会被查询出来
		 语法1： select 列名,..... from 左表,右表  where 左表.关联字段 = 右表.关联字段
		 语法2： select 列名,..... from 左表 [inner] join 右表 on  左表.关联字段 = 右表.关联字段
	 外连接
		 左外连接
			 左表中所有的数据都会被查询出来
			 左表如果没有与右表与之关联，也会被查询出来，右表的数据使用null填充
			 语法：select 列名,..... from 左表 left join 右表 on 左表.关联字段 = 右表.关联字段
        右外连接
			 右表中所有的数据都会被查询出来
			 右表如果没有与左表与之关联，也会被查询出来，左表的数据使用null填充
			 语法：select 列名,..... from 左表 right join 右表 on 左表.关联字段 = 右表.关联字段

    全连接(mysql不支持)
		合并查询：
		   union：将多个查询结果进行合并，并且去重
		   union all：将多个查询结果进行合并
             使用合并查询注意的地方:
					1、两个结果集合并，要保证列数一致
					2、两个结果集合并，类型要兼容
    非等值连接
    自连接	
*/
```

#### 9.1 内连接

```mysql
-- 查询员工的姓名、工资、入职日期、部门名称、部门位置、
-- 内连接查询
select ename,sal,hiredate,dname,location from emp,dept where emp.deptno = dept.dept	no
select ename,sal,hiredate,dname,location from emp join dept on emp.deptno = dept.deptno
```

#### 9.2 左外连接

```mysql
-- 左外连接查询
select ename,sal,hiredate,dname,location from emp left join dept on emp.deptno = dept.deptno
```

#### 9.3 右外连接

```mysql
-- 右外连接查询
select ename,sal,hiredate,dname,location from emp right join dept on emp.deptno = dept.deptno
```

#### 9.4 全连接(不支持)

#### 9.5 合并查询

```mysql
-- 合并查询
select ename,sal,hiredate,dname,location from emp left join dept on emp.deptno = dept.deptno
union 
select ename,sal,hiredate,dname,location from emp right join dept on emp.deptno = dept.deptno
```

> - Union作用
>   - union 合并两个查询子集，且会去重
>   - union all   合并两个查询子集，不会去重
> - [注意：合并的要保证列数相同，类型兼容]()

#### 9.6 非等值连接

```mysql
-- 非等值连接
-- 查询员工姓名、职位、工资等级 
select ename,job,grade from emp left join salgrade on sal >= losal and sal <= hisal
```

#### 9.7 表的自连接

```mysql
-- 自连接
-- 查询员工姓名，以及经理的姓名
select e1.ename,e2.ename from emp e1 left join emp e2 on e1.mgr = e2.empno
```



### 十、DML 操作【重要】

#### 10.1 新增

> - [语法1：insert into 表名 (字段名1,...) values (值1,...)]()
> - [语法2：insert into 表名 values(值1,值2,...);]()
>   - [`要求：每一个字段都必须给值，且顺序要与表中的顺序一致`]()
> - [语法3：insert into 表名 (字段名1,...) values (值1,...),(值1,...),(值1,...),....]()

```mysql
-- 增加
-- 语法1：insert into 表名 (字段名1,...) values (值1,...)
-- 增加一个员工
insert into emp (empno,ename,job,sal) values (7778,'尼古拉斯','php开发',10000);
-- 语法2：insert into 表名 values(值1,...)   
-- 要求：每一个字段都必须给值，且顺序要与表中的顺序一致
-- 增加一个员工
insert into emp values (7779,'尼古拉斯','php开发',7777,now(),10000,200,20);
-- 语法3：insert into 表名 (字段名1,...) values (值1,...),(值1,...),(值1,...),....
-- 添加3个员工
insert into emp (empno,ename,job,sal) values 
(8881,'李雷','英语',8000),(8882,'韩梅梅','数学',8000),(8883,'马冬梅','体育',6000)
```

#### 10.2 修改

> - [语法：update 表名 set 要修改的字段1=修改的值1,要修改的字段2=修改的值2,.. [where 过滤条件]]()
>   - [`注意：如果不写where条件那么就是全表更新(谨慎操作！！！)`]()

```mysql
-- 修改
-- 语法：update 表名 set 要修改的字段1=修改的值1,要修改的字段2=修改的值2,.. [where 过滤条件]
-- 注意：如果不写where条件那么就是全表更新(谨慎操作！！！)

-- 修改编号为8883员工姓名为马什么梅,工资改为7000,入职日期改为今天
update emp set ename='马什么梅',sal = 7000,hiredate = now() where empno = 8883
update emp set ename='马什么梅',sal = 7000,hiredate = now()
-- 将公司的每一个员工的工资上调100元 
update emp set sal = sal +100
```

#### 10.3 删除

> - [语法：delete from 表名 [where 过滤条件]]()
>   - [`注意：如果不写where条件那么就是全表删除(谨慎操作！！！)`]()

```mysql
-- 删除(逻辑删除)
-- 语法：delete from 表名 [where 过滤条件]
-- 注意：如果不写where条件那么就是全表删除(谨慎操作！！！)
-- 删除编号为7778的员工信息
delete from emp where empno = 7778;

-- 批量删除8881 8882 8883 8884
delete from emp where empno in(8881,8882,8883,8884);

delete from emp -- 跑，别回头

```



### 十一、数据类型 【了解】

#### 11.1 数据类型 

##### 11.1.1 数值类型

| 类型             | 大小                              | 范围（有符号）                                  | 范围（无符号）              | 用途           |
| ---------------- | --------------------------------- | ----------------------------------------------- | --------------------------- | -------------- |
| [INT]()          | 4 字节                            | (-2 147 483 648，2 147 483 647)                 | (0，4 294 967 295)          | 大整数值       |
| DOUBLE           | 8 字节                            | （-1.797E+308,-2.22E-308）                      | (0,2.22E-308,1.797E+308)    | 双精度浮点数值 |
| [DOUBLE(M,D)]()  | 8个字节，M表示长度，D表示小数位数 | 同上，受M和D的约束   DOUBLE(5,2) -999.99-999.99 | 同上，受M和D的约束          | 双精度浮点数值 |
| [DECIMAL(M,D)]() | DECIMAL(M,D)                      | 依赖于M和D的值，M最大值为65                     | 依赖于M和D的值，M最大值为65 | 小数值         |

##### 11.1.2 日期类型

| 类型         | 大小 | 范围                                                         | 格式                | 用途                     |
| ------------ | :--- | ------------------------------------------------------------ | ------------------- | ------------------------ |
| [DATE]()     | 3    | 1000-01-01/9999-12-31                                        | YYYY-MM-DD          | 日期值                   |
| TIME         | 3    | '-838:59:59'/'838:59:59'                                     | HH:MM:SS            | 时间值或持续时间         |
| YEAR         | 1    | 1901/2155                                                    | YYYY                | 年份值                   |
| [DATETIME]() | 8    | 1000-01-01 00:00:00/9999-12-31 23:59:59                      | YYYY-MM-DD HH:MM:SS | 混合日期和时间值         |
| TIMESTAMP    | 4    | 1970-01-01 00:00:00/2038 结束时间是第 **2147483647** 秒北京时间 **2038-1-19 11:14:07**，格林尼治时间 2038年1月19日 凌晨 03:14:07 | YYYYMMDD HHMMSS     | 混合日期和时间值，时间戳 |

##### 11.1.3 字符串类型

| 类型                        | 大小         | 用途                              |
| --------------------------- | ------------ | --------------------------------- |
| [CHAR]()                    | 0-255字符    | 定长字符串  char(10) 10个字符     |
| [VARCHAR]()                 | 0-65535 字节 | 变长字符串  varchar(10)  10个字符 |
| BLOB（binary large object） | 0-65535字节  | 二进制形式的长文本数据            |
| [TEXT]()                    | 0-65535字节  | 长文本数据                        |

```mysql
/*
	数值类型
		整数型
			 int  long
        浮点型
			 float double

			 double(n,m) 可以表示数字的位数
					 n：表示总位数(整数位数+小数位数)
                     m：表示小数位数
			 举例：double(7,2)
       		dicmal(n,m)

  字符串类型
		 char   
					定长字符串  char(5) 最大只能储存5个字符，不满5个字符占5个字节空间
					最大范围：0~255个字符
         varchar
					可变长字符串  varchar(10) 最大只能储存10个字符,不满10个字符占实际字节数的空间
					最大范围：0~65535个字节(如果是中文最多是21845个字符)
		 text
					大型文本，最大范围：0~65535个字节
         blob
				  以二进制的形式存储  最大范围：0~65535个字节
		 在以后的开发：视频、音频、图片 只在数据库存地址
  日期时间类型
			date 
					表示日期
			time
					表示时间
			datetime
					表示日期时间
			timestamp
					表示日期时间(时间戳)
*/
```



### 十二、表的操作

#### 12.1 查看表

```sql
-- 查看当前数据库下所有的表
show tables;
```

#### 12.2 查看表结构

```sql
-- 查看表结构
-- desc 表名
desc emp
```

#### 12.3 表的创建 【重要】

> [CREATE TABLE 表名(]()
>
> ​	[列名 数据类型 [约束] ,]()
>
> ​	[列名 数据类型 [约束] ,]()
>
> ​	....
>
> ​	[列名 数据类型 [约束]]()        
>
> [);]()

```mysql
-- 建表
create table user(
    username varchar(50),
    password varchar(50),
    age int,
    phone_num varchar(20),
    birthday date,
    money double
)
```

#### 12.4 删除表

> [drop table 表名;删除表]() 

```sql
-- 删除表
-- drop table 表名;
-- drop table if exists 表名;
drop table if exists user;
```

#### 12.5 修改表【了解】

> [添加列]()
>
> - alter table 表名  add  添加的字段  数据类型;

```mysql
-- 在user表中添加一个address字段
alter table user add address varchar(100);
```

> [修改列的数据类型]()
>
> - alter table 表名 modify 修改的字段 数据类型;

```mysql
-- 在user表中修改birthday字段的类型为datetime类型
alter table user modify birthday datetime;
```

> [删除列]()
>
> - alter table 表名 drop 字段名;

```mysql
-- 在user表中删除一个phone_num字段
alter table user drop phone_num;
```

> [修改列名]()
>
> - alter table 表名 change 旧列名 新列名 数据类型;

```mysql
-- 在user表中将username改为name
alter table user change username name varchar(50)
```



### 十三、表的约束【理解】

#### 13.1 约束

> 约束：
>
> - 用于限制加入到表中的数据的类型和规范

#### 13.2 约束的分类

> - 实体完整性
> - 域完整性
> - 引用完整性

#### 13.3 实体完整性

```mysql
/*
	约束：
		实体完整性约束
			主键约束
				主键：指的是一行数据唯一标识的那一列
					自然主键：主键字段就是这个表的某个属性
					代理主键：使用一个与表无关字段来作为表的主键
				主键的特点：非空+唯一
                主键的语法：字段名 数据类型 primary key

            唯一约束
				 唯一特点：某个字段在一列数据中是唯一的
                  唯一语法：字段名 数据类型 unique

            自增长约束
				 自增长特点：一般与主键一起使用，每添加一条数据，主键自动生成，在原有的基础上加1		
				 自增长语法： 字段名 数据类型 primary key auto_increment

             联合主键约束
				联合主键特点：与主键的作用含义一样，只不过由多个字段一起组成主键
                应用场景：中间表
				自增长语法： primary key(字段1,字段2)
*/
```

```mysql
drop table if exists user;
create table user(
  id int primary key,
  name varchar(20),
  age int
)
insert into user values(1,'jack',30); 

insert into user (name,age) values('jack',30); -- 错误，违反主键约束
insert into user values(null,'jack',30); -- 错误，违反主键约束(非空)
insert into user values(1,'rose',30); -- 错误，违反主键约束(唯一)


drop table if exists user;
create table user(
  id int primary key,
  name varchar(20) unique,
  age int
)
insert into user values(1,'jack',30);


insert into user values(2,'jack',31);  -- 错误，违反唯一约束
insert into user values(3,null,33); 
insert into user values(4,null,34); 



drop table if exists user;
create table user(
  id int primary key auto_increment,
  name varchar(20) unique,
  age int
)


insert into user (name,age) values ('jack',33);
insert into user (name,age) values ('rose',33);
insert into user  values (null,'马冬梅',34);



drop table if exists user;
create table user(
  name varchar(20),
  age int,
	primary key(name,age)
)
insert into user values('jack',30);
insert into user values('jack',31);
insert into user values('rose',31);
insert into user values('jack',30); -- 错误，违反联合主键约束
```

#### 13.4 域完整性

```mysql
/*
    域完整性约束
			数据类型约束(必填)

			非空约束
				 非空特点：添加数据的时候，不能为null
				 非空语法：字段名 数据类型 not null

			默认值约束
				 默认值特点：这一列数据如果不添加，则默认值生效
				 默认值语法： 字段名 数据类型 default '默认值'

*/
```

```mysql
drop table if exists user;
create table user(
	id int primary key auto_increment,
  name varchar(20) not null,
  age int
)
insert into user (name,age) values (null,33); -- 错误，违反非空约束
drop table if exists user;
create table user(
	id int primary key auto_increment,
  name varchar(20) default '宋小宝',
  age int
) 
insert into user (name,age) values (null,33); -- 注意：默认值不生效
insert into user (age) values (33); -- 默认值生效
```

#### 13.5 引用完整性

```mysql
/*
	引用完整性约束(在实际开发，如果能够不使用外键约束就不使用，我们可以使用逻辑外键)
		引用完整性约束：指的是多张表之间的引用约束
		主表(dept:主键)    从表(emp：外键)
        外键约束
			 特点：
				 1、主表中有的从表中可以没有，但是主表没有的从表一定不能有
				 2、删除主表中的数据的时候，要保证从表没有与之关联的数据
				 3、修改从表中数据的时候。要保证主表中存在
						
            语法：
				constraint 外键约束的名称 foreign key(外键字段) references 关联表(关联字段)

*/
```

```mysql
drop table if exists tb_dept;
create table tb_dept(
	deptno int primary key,
  dname varchar(30),
  location varchar(30)
);

drop table if exists tb_emp;
create table tb_emp(
	empno int primary key,
  ename varchar(30),
  job varchar(30),
	deptno int,
  constraint fk_dept_emp foreign key(deptno) references tb_dept(deptno)
)
insert into tb_dept values(100,'开发部','金融港');
insert into tb_dept values(101,'人事部','光谷广场');
insert into tb_emp values(6666, 'jack','java开发',20000); -- 错误，违反了外键约束

insert into tb_emp values(6666, 'jack','java开发',100);
delete from tb_dept where deptno = 100; -- 错误，违反了外键约束
update tb_emp set deptno = 102 where empno = 6666;

```



### 十四、权限管理【了解】

```sql
-- 创建用户
create user 'cxk' identified by '123456';
-- 授权
-- grant all(select、delete、update、select、create、drop..) on *.* to 用户
grant select on java2108.emp to 'cxk'
-- 回收权限
-- revoke all on *.* from 用户
revoke select on java2108.emp from 'cxk';
-- 删除
-- drop user if exists 用户
drop user if exists 'cxk'

```



### 十五、视图【了解】

#### 15.1 概念

> 视图，虚拟表，从一个表或多个表中查询出来的表，作用和真实表一样，包含一系列带有行和列的数据。视图中，用户可以使用SELECT语句查询数据，也可以使用INSERT，UPDATE，DELETE修改记录，视图可以使用户操作方便，并保障数据库系统安全。

#### 15.2 视图特点

> - 优点
>   - 简单化，数据所见即所得。
>   - 安全性，用户只能查询或修改他们所能见到得到的数据。
>   - 逻辑独立性，可以屏蔽真实表结构变化带来的影响。
>
> - 缺点
>   - 性能相对较差，简单的查询也会变得稍显复杂。
>   - 修改不方便，特变是复杂的聚合视图基本无法修改。

#### 15.3 视图的创建

> 语法：[CREATE VIEW 视图名 AS]() 查询数据源表语句;

##### 15.3.1 创建视图

```MYSQL
-- 创建视图
create view myView as (select empno,ename,job,mgr,hiredate,deptno from emp)
```

##### 15.3.2 使用视图

```mysql
-- 查询视图
select * from myView;
```

#### 15.4 视图的修改

> - 方式一：[CREATE OR REPLACE VIEW]() 视图名 AS 查询语句
>
> - 方式二：[ALTER VIEW]() 视图名 AS 查询语句

##### 15.4.1 修改视图

```MYSQL
-- 修改视图
-- 方式1：
create or replace view myView as((select empno,ename,job,hiredate,deptno from emp))
-- 方式2：
alter view myView as ((select empno,ename,hiredate,deptno from emp))
```

#### 15.5 视图的删除

> [DROP VIEW]()  视图名

##### 15.5.1 删除视图

```mysql
-- 删除视图
drop view if exists myView;
```

- [注意：删除视图不会影响原表]()

#### 15.6 视图的注意事项

> - 注意：
>   - 视图不会独立存储数据，原表发生改变，视图也发生改变。没有优化任何查询性能。
>   - 如果视图包含以下结构中的一种，则视图不可更新
>     - 聚合函数的结果
>     - DISTINCT 去重后的结果
>     - GROUP BY 分组后的结果
>     - HAVING 筛选过滤后的结果
>     - UNION、UNION ALL 联合后的结果



### 十六、事务【理解】

#### 16.1 事务的概念

> 事务是一个原子操作。是一个最小执行单元。可以由一个或多个SQL语句组成，在同一个事务当中，所有的SQL语句都成功执行时，整个事务成功，有一个SQL语句执行失败，整个事务都执行失败。

#### 16.2 事务的边界

> - 开始：连接到数据库，执行一条DML语句。 上一个事务结束后，又输入了一条DML语句，即事务的开始
>
>
> - 结束：
>
>   ​	1).	提交：
>
>   ​			a.	显示提交：[commit]();
>
>   ​			b.	隐式提交：一条创建、删除的语句，正常退出（客户端退出连接）;
>
>   ​	2).	回滚：
>
>   ​			a.	显示回滚：[rollback]();
>
>   ​			b.	隐式回滚：非正常退出（断电、宕机），执行了创建、删除的语句，但是失败了，会为这个无效的语句执行回滚。
>
> 

#### 16.3 事务的原理

> 数据库会为每一个客户端都维护一个空间独立的缓存区(回滚段)，一个事务中所有的增删改语句的执行结果都会缓存在回滚段中，只有当事务中所有SQL	语句均正常结束（commit），才会将回滚段中的数据同步到数据库。否则无论因为哪种原因失败，整个事务将回滚（rollback）。

#### 16.4 事务的特性

> - [Atomicity(原子性)]()
>
> 　　　　一个事务不可分割，要么一起执行成功，要么一起失败
>
> - [Consistency(一致性)]()
>
> 　　　　事务操作的前后要保证的数据的一致
>
> - [Isolation(隔离性)]()
>
> 　　　　一个事务的操作不能影响到另一个事务的执行
>
> - [Durability(持久性)]()
>
> 　　　　一个事务操作完成对数据库的影响是永久

#### 16.5 事务应用

> 应用环境：基于增删改语句的操作结果（均返回操作后受影响的行数），可通过程序逻辑手动控制事务提交或回滚
>
> - 事务完成转账

```mysql
#A 账户给 B 账户转账。
#1.开启事务
set autocommit=0;  #禁止自动提交 set autocommit=1;#开启自动提交
#2.事务内数据操作语句
UPDATE ACCOUNT SET MONEY = MONEY-1000 WHERE ID = 1;
UPDATE ACCOUNT SET MONEY = MONEY+1000 WHERE ID = 2;
#3.事务内语句都成功了，执行 COMMIT；
COMMIT;
#4.事务内如果出现错误，执行 ROLLBACK;
ROLLBACK;
```

- [注意：开启事务后，执行的语句均属于当前事务，成功再执行 COMIIT，失败要进行 ROLLBACK]()

#### 16.6 事务的并发问题

> - 1、脏读：事务A读到事务B没有提交的数据
> - 2、不可重复读：事务A在同一个事务中，因为事务B修改了数据并提交，造成两次读取到的数据不一致
> - 3、幻读：事务A在同一个事务中，因为事务B新增了数据并提交，如果事务A修改数据，会出现多修改了一条数据，出现幻觉

#### 16.7 如何解决事务并发问题

> 通过设置事务隔离级别可以解决以上问题

| 事务隔离级别                 | 脏读 | 不可重复读 | 幻读 |
| ---------------------------- | ---- | ---------- | ---- |
| 读未提交（read-uncommitted） | 会   | 会         | 会   |
| 读已提交（read-committed）   | 不会 | 会         | 会   |
| 可重复读（repeatable-read）  | 不会 | 不会       | 会   |
| 串行化（serializable）       | 不会 | 不会       | 不会 |

#### 16.8 演示问题

> - 查看当前数据库的隔离级别
>   - [select @@tx_isolation;]()
> - 修改当前数据库的隔离级别
>   - [set session transaction isolation level 【隔离级别】]()

### 十七、SQL语言的分类

#### 17.1 SQL语言分类

> - 数据查询语言DQL（Data Query Language）：select、where、order by、group by、having 。【重要】
>
> - 数据定义语言DDL（Data Definition Language）：create、alter、drop。
>
> - 数据操作语言DML（Data Manipulation Language）：insert、update、delete 。  【重要】
>
> - 事务处理语言TPL（Transaction Process Language）：commit、rollback 。  【重要】
>
> - 数据控制语言DCL（Data Control Language）：grant、revoke。