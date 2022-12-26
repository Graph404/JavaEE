-- 表的操作

-- 1、查看当前数据库下的所有表
show tables;

-- 2、查看表的结构
-- desc 表名
desc user;

-- 3、创建表

/*
create table 表名(
		字段名1 字段类型 [约束],
		字段名2 字段类型 [约束],
		...
)
*/

-- 3、创建表（重要）
create table user(
	username varchar(20),
	password varchar(20),
	age int,
	phoneNum varchar(20),
	brithday date,
	money double
)

-- 4、删除表
-- drop table 表名;
drop table student;

-- 5、修改表

-- 添加一列
alter table user add address varchar(20);

-- 删除一列
alter table user drop aaa;

-- 修改列名
alter table user change phoneNum num varchar(20);

-- 修改列类型
alter table user modify brithday datetime;


