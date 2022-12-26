-- 增删改   更新

-- 增加：
-- 语法1：insert into 表名 (字段1,...) values (值1,...);
-- 语法2：insert into 表名 values (值1,...);
		-- 注意：添加的值与表的列数要一致，顺序要一致
-- 语法3：insert into 表名 values (值1,...),(值,...)...

-- 添加员工信息
insert into emp (empno,ename) values(8888,'李雷');
insert into emp values(9999,'马冬梅','java开发',8888,'2022-02-22',20000,2000,20);

-- 批量添加
insert into emp values
		(9990,'马冬梅2','java开发2',8888,'2022-02-22',20000,2000,20),
		(9991,'马冬梅3','java开发3',8888,'2022-02-22',20000,2000,20),
		(9994,'马冬梅3','java开发3',8888,'2022-02-22',20000,2000,20);



-- 修改：
-- 语法：update 表名 set 字段名=修改的值,... [where 过滤条件];
-- 注意：在修改的时候通常会写上过滤条件如果没有过滤条件则表示全表修改，谨慎操作!!

-- 如果没有添加条件则是全表修改
update emp set sal = sal + 100,comm = ifnull(comm,0) + 100;
update emp set sal = sal + 100,comm = ifnull(comm,0) + 100 where empno = 9999;


-- 修改cxk的名字为练习生，工资+200，入职日期改为今天
update emp set ename = '练习生',sal = sal + 200 , hiredate = sysdate() where empno = 7777;


-- 删除：
-- 语法：delete from 表名 [where 过滤条件]
-- 如果删除的时候，没有过滤条件则表示全表删除，谨慎操作！！！
-- 删除工资大于10000的员工信息
delete from emp where sal > 10000;

-- 批量删除  删除 7902,7294,8888
delete from emp where empno in(7902,7294,8888);


-- 全表删除   跑，别回头
delete from emp;





