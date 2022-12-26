-- 约束：为了保证数据的有效性
/*
	 实体完整性约束
			主键约束
				主键：在表中表示一行数据的唯一标识的列
						自然主键：主键字段表示表的属性
						代理主键：使用一个与表无关字段来代表主键
				语法：字段名  字段类型  primary key 
        特点：非空+唯一
					
      唯一约束
				唯一：唯一字段在表中的数据是唯一的
				语法：字段名  字段类型 unique
					
      自增长
					自增长:配置整数型主键一起使用，没添加一条数据，就在主键上+1
					语法：字段名  字段类型   primary key  auto_increment
					
      联合主键
					联合主键:一般用于中间表

   域完整性约束
			数据类型约束(必须要的)
			非空约束
				非空约束：字段的值不能为null
				语法：字段名  字段类型  not null

			默认值约束：
				默认值约束：当字段没有值的时候，默认的值
				语法：字段名  字段类型  default 默认的值


   引用完整性约束
			外键约束：多表之间数据的完整性
			主表(dept:主键)     从表(emp：外键)

			外键约束特点：
					1、主表中没有的从表中不能有(不能添加或者修改成主表没有的数据)
					2、删除主表中的数据要保证从表中没有关联
          3、主表中有的从表中可以没有
			
			在实际开发中，如有没有严格要求，可以不要添加外键约束。可以通过逻辑代码避免无效数据，表中使用逻辑外键就可以了

*/
drop table if exists user;
create table user(
	id int primary key,
  name varchar(30),
	age int
);

insert into user values(1,'jack',20);
-- insert into user values(1,'rose',22);  错误示范：主键唯一
-- insert into user (name,age) values ('rose',22); 错误示范：主键非空
-- insert into user (id,name,age) values (null,'rose',22);  错误示范：主键非空

drop table if exists user;
create table user(
	id int primary key,
  name varchar(30) unique,
	age int
);
insert into user values(1,'jack',20);
-- insert into user values(2,'jack',22);错误示范：唯一约束
insert into user values (2,null,22);
insert into user values (3,null,33);

select * from user;



drop table if exists user;
create table user(
	id int primary key auto_increment,
  name varchar(30),
	age int
);

insert into user (name,age)values('jack',22);
insert into user values(null,'rose',30);

drop table if exists user;
create table user(
	id int primary key auto_increment,
  name varchar(30) not null,
	age int
);
insert into user values(null,'rose',30);
insert into user values(null,null,30); -- 错误示范：违反了非空约束
insert into user (id,age) values(null,30); -- 错误示范：违反了非空约束

drop table if exists user;
create table user(
	id int primary key auto_increment,
  name varchar(30) default 'cxk',
	age int
);
insert into user (id,age) values(null,30);
insert into user (id,age) values(null,30);
insert into user (id,name,age) values(null,'rose',30);

select * from user;





drop table if exists tb_dept;
create table tb_dept(
	deptno int primary key,
	dname varchar(20),
  location varchar(20)
);
drop table if exists tb_emp;
create table tb_emp(
	empno int primary key,
	ename varchar(20),
  job varchar(20),
  dno int,
	constraint fk_dno foreign key(dno) references tb_dept(deptno)
);
insert into tb_dept values(30,'开发部','武汉');

insert into tb_emp values(1,'jack','java',30);
insert into tb_emp values(2,'rose','php',40);   -- 违反了外键约束
update tb_emp set dno = 20 where empno = 1;     -- 违反了外键约束

delete from tb_dept where deptno = 30;



select * from tb_emp;
