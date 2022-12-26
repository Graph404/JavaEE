/*
	1、mysql概述(了解)
  2、mysql安装与配置(重要)
  3、mysql的基本查询(重要)
         1)简单查询  select 字段1,... from 表名;
         2)别名查询  select 字段 as 别名 from 表名;
				 3)去重查询  select distinct 去重字段  from 表名;
         4)排序查询  select 字段1,... from 表名 order by 排序字段1 排序规则,....
         5)条件查询  select 字段1,... from 表名 where 过滤条件
							a、关系条件
              b、逻辑条件
              c、区间条件
              d、枚举条件
              e、null值条件
              f、模糊条件   % _
         6)分支查询  select case  when 条件1  then 结果1  when 条件1  then 结果1 ... else  end  from 表名
         7)常用函数
               日期函数(了解)
               字符串函数(了解)
               聚合函数
         8)分组查询  select 字段1,... from 表名 group by 分组字段  having 分组过滤条件
         9)分页查询  select 字段1,... from 表名 limit n,m
								页码：pageNum    每页条数：pageSize
                (pageNum-1)*pageSize,pageSize
        10)总结：SQL的编写顺序和执行顺序

		4、mysql子查询
				 语法1：select 字段1,... from 表名 where 字段名 = (子查询);
						在where从句后面使用子查询
								单行单列：直接判断  = !=  <   >
                多行单列：in   >all  >any

				 语法2：select 字段1,... from (子查询);
					  在from从句后面使用子查询
								多行多列            
*/