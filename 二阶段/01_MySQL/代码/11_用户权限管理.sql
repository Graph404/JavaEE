-- 创建用户
-- 语法：create user 用户名 identified by 用户密码;
create user 'cxk' IDENTIFIED by '123456';
-- 用户授权  all:表示所有权限    *.*：表示所有库所有表
-- 语法：grant 权限(select、update、insert、delete、create、drop、alter、...) all on 数据库.数据表 to 用户
grant select on *.* to cxk;
grant select,insert on *.* to cxk;

-- 回收权限
-- 语法：revoke 权限 on 数据库.数据表 from 用户
revoke all on *.* from cxk;

-- 删除用户
-- 语法：drop user 用户名
drop user if exists cxk;




