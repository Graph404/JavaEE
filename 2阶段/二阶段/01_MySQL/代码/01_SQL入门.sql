-- mysql注释
/*
	mysql多行注释
*/

-- 连接mysql数据库
-- 语法：   mysql  -uroot -p123456
mysql  -uroot -p123456

-- 断开连接
quit;

-- 创建数据库
-- create database 数据库名;
create database mydb001;
-- create database 数据库名 character set 编码格式
create database mydb002 character set 'gbk';
-- create database if not exists 数据库名;
create database if not exists mydb001;

-- 查看数据库
show databases;


-- 查看数据库的创建信息
-- show create database 数据库名;
show create database mydb001;

-- 修改数据库的编码格式
-- alter database 数据名 character set 编码格式;
alter database mydb002 character set 'utf8';


-- 删除数据库
-- drop database if exists 数据库名;
drop database mydb001;
drop database if exists mydb002;


-- 查看当前数据库
select database();


-- 选择数据库(以后再数据库中操作，一定要先选择数据库)
-- use 数据库名;



mysql的可视化工具
	navicat
	sqlyog







