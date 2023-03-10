/*
	mysql 数据类型

			数值类型：
					整数类型
							int  long

					浮点类型
							float double

							double(n,m)   n:表示总位数   m:表示小数点位数
									例：double(7,2)   最大值99999.99
							decimal(n,m)
			
			字符串类型：
					char(长度)
							固定长度的字符串。char(10) 表示最多10个字符，如果不满10个字符，占据10个字符的空间
							取值范围：0~255个字符
					varchar(长度)
							可变长的字符串。varchar(10) 表示最多10个字符，如果不满10个字符，是几个字符就占据几个字符的空间
							取值范围：0~65535个字节(如果是中文汉字最多可以保存65536/3个字符)
          text
							大文本类型
							取值范围：0~65535个字节
					blob
						  以二进制存储数据，取值范围：0~65535个字节
	
						数据库中只保存文件(视频、音频、图片)的地址


      日期类型：
					date:表示日期
					time:表示时间
					datetime:表示日期时间
					timestamp:表示日期时间

					'yyyy-MM-dd HH:mm:ss'

				'1' + 1  = 2

	


*/