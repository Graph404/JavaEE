### 一、HTML简介



#### 1.1 什么是HTML

> HTML全称：Hyper Text Markup Language(超文本标记语言)
>
> - 超文本:页面内可以包含图片、链接，甚至音乐、程序等非文字元素
> - 标记:标签，不同的标签实现不同的功能
> - 语言:人与计算机的交互工具  



#### 1.2 HTML能做什么

> HTML使用标记标签来描述网页,展示信息给用户



#### 1.3 HTML书写规范

> - HTML标签是以尖括号包围的关键字
> - HTML标签通常是成对出现的，有开始就有结束 
> - HTML通常都有属性，格式:属性＝‘属性值’(多个属性之间空格隔开) 
> - HTML标签不区分大小写,建议全小写



### 二、HTML基本标签



#### 2.1 结构标签

```html
<html>:根标签       
    <head>：网页头标签
   		<title></title>:页面的标题      
    </head>      
    <body></body>：网页正文
</html>
```

|   属性名   |                代码                |             描述             |
| :--------: | :--------------------------------: | :--------------------------: |
|    text    |    < body text="#f00"></ body>     | 设置网页正文中所有文字的颜色 |
|  bgcolor   |   < body bgcolor="#00f"></ body>   |       设置网页的背景色       |
| background | < body background="1.png"></ body> |       设置网页的背景图       |

> 颜色的表示方式：                        
>
> - 第一种方式：用表示颜色的英文单词，例，red green blue                 
>
> - 第二种方式：用16进制表示颜色，例，#000000  #ffffff  #325687   #377405



#### 2.2 排版标签	

> - 可用于实现简单的页面布局
>
>
> - 注释标签：<!--注释-->                
> - 换行标签：< br>
> - 段落标签：< p>文本文字</ p>   
>   - 特点：段与段之间有空行                       
>   - 属性：align对齐方式(left、center、right)          
> - 水平线标签:< hr/>                      
>   - 属性:   
>     - ​    width：水平线的长度(两种:第一种:像素表示；第二种，百分比表示) 
>     - ​    size: 水平线的粗细 (像素表示，例如：10px)                             
>     - ​    color:水平线的颜色                                  
>     - ​    align:水平线的对齐方式



#### 2.3 块标签

> 使用CSS+DIV是现下流行的一种布局方式

| 标签 |      代码       |              描述              |
| :--: | :-------------: | :----------------------------: |
| div  |  < div></ div>  |   行级块标签，独占一行，换行   |
| span | < span></ span> | 行内块标签，所有内容都在同一行 |



#### 2.4 基本文字标签

>  font标签处理网页中文字的显示方式

| 属性名 |             代码             |                 描述                 |
| :----: | :--------------------------: | :----------------------------------: |
|  size  |   < font size="7"></ font>   | 用于设置字体的大小，最小1号，最大7号 |
| color  | < font color="#f00"></ font> |          用于设置字体的颜色          |
|  face  | < font face="宋体"></ font>  |          用于设置字体的样式          |



#### 2.5 文本格式化标签

> 使用标签实现标签的样式处理

|  标签  |        代码         |   描述   |
| :----: | :-----------------: | :------: |
|   b    |      < b></ b>      | 粗体标签 |
| strong | < strong></ strong> |   加粗   |
|   em   |     < em></ em>     | 强调字体 |
|   i    |      < i></ i>      |   斜体   |
| small  |  < small></ small>  | 小号字体 |
|  big   |    < big></ big>    | 大号字体 |
|  sub   |    < sub></ sub>    | 上标标签 |
|  sup   |    < sup></ sup>    | 下标标签 |
|  del   |    < del></ del>    |  删除线  |



#### 	2.6 标题标签

> 随着数字增大文字逐渐变小，字体是加粗的，内置字号，默认占据一行

| 标签 |    代码     |       描述        |
| :--: | :---------: | :---------------: |
|  h1  | < h1></ h1> | 1号标题，最大字号 |
|  h2  | < h2></ h2> |      2号标题      |
|  h3  | < h3></ h3> |      3号标题      |
|  h4  | < h4></ h4> |      4号标题      |
|  h5  | < h5></ h5> |      5号标题      |
|  h6  | < h6></ h6> | 6号标题，最小字号 |



#### 2.7 列表标签(清单标签)

> 无序列表：使用一组无序的符号定义， < ul>< /ul>

```html
<ul type="circle">
    <li></li>
</ul>
```

| 属性值 |   描述   |         用法举例          |
| :----: | :------: | :-----------------------: |
| circle |  空心圆  | < ul type="circle">< /ul> |
|  disc  |  实心圆  |  < ul type="disc">< /ul>  |
| square | 黑色方块 | < ul type="square">< /ul> |

> 有序列表：使用一组有序的符号定义，  < ol>< /ol>

```html
<ol type="a" start="1">
    <li></li>
</ol>
```

| 属性值 |     描述     |       用法举例        |
| :----: | :----------: | :-------------------: |
|   1    |   数字类型   | < ul type="1">< /ul>  |
|   A    | 大写字母类型 | < ul type="A" >< /ul> |
|   a    | 小写字母类型 | < ul type="a">< /ul>  |
|   I    |  大写古罗马  | < ul type="I">< /ul>  |
|   i    |  小写古罗马  | < ul type="i">< /ul>  |

> 列表嵌套：无序列表与有序列表相互嵌套使用

```html
代码举例：
	<ol>
		<li></li>
        <li></li>
        <li>
        	<ul>
                <li></li>
            </ul>
        </li>
	</ol>
```



#### 2.8 图片标签

> 在页面指定位置处中引入一幅图片， < img />

|  属性名   |           描述           |
| :-------: | :----------------------: |
| src(必填) |      引入图片的地址      |
|   width   |        图片的宽度        |
|  height   |        图片的高度        |
|  border   |        图片的边框        |
|   align   |    与图片对齐显示方式    |
|    alt    |         提示信息         |
|   title   | 鼠标移到图片上显示的文字 |



#### 2.9 链接标签

> - 在页面中使用链接标签跳转到另一页面
>
>   - 标签： < a href="">< /a>
>
>   - 属性：href:跳转页面的地址(跳转到外网需要添加协议)   
> - 设置跳转页面时的页面打开方式，target属性
>   - _blank在新窗口中打开
>   - _self在原空口中打开

> - 指向同一页面中指定位置
>   - 定义位置： < a name="名称">< /a>
>   - 指向： < a href="#名称">< /a>



#### 2.10 表格标签

> 普通表格(table,tr,td)

```
<table>
	<tr>
		<td></td>
	</tr>
</table>
```

> 表格的列标签(th)：内容有加粗和居中效果

```html
<table>
	<tr>
		<th></th>
	</tr>
</table>
```

> 表格的列合并属性(colspan)：在同一行内同时合并多个列

```
<table>
	<tr>
		<td colspan=""></td>
	</tr>
</table>
```

> 表格的行合并属性(rowspan)：在同一列跨多行合并

```html
<table>
	<tr rowspan="">
		<td></td>
	</tr>
</table>
```



### 三、HTML表单标签	



> html表单用于收集不同类型的用户输入数据

#### 3.1 form元素常用属性

> - form：表单，用于收集数据并提交到服务器
>   - 属性：
>     - action   : 表单提交的服务器地址
>     - method   : get方法和post方法
>     - enctype  : 表单的提交形式
>       - application/x-www-form-urlencoded（默认的，以字符串的形式(key-value)提交）
>       - multipart/form-data(以二进制的流的形式提交表单) )			



#### 	3.2 input元素

> 作为表单中的重要元素，可根据不同type值呈现为不同状态

|     属性值     |     描述     |              代码               |
| :------------: | :----------: | :-----------------------------: |
|      text      |  单行文体框  |      < input type="text"/>      |
|    password    |    密码框    |    < input type="password"/>    |
|     radio      |   单选按钮   |     < input type="radio"/>      |
|    checkbox    |    复选框    |    < input type="checkbox"/>    |
|      date      |    日期框    |      < input type="date"/>      |
|      time      |    时间框    |      < input type="time"/>      |
| datetime-local | 日期和时间框 | < input type="datetime-local"/> |
|     email      | 电子邮件输入 |     < input type="email"/>      |
|     number     |   数值输入   |     < input type="number"/>     |
|      file      |   文件上传   |      < input type="file"/>      |
|     hidden     |    隐藏域    |     < input type="hidden"/>     |
|     submit     | 表单提交按钮 |     < input type="submit"/>     |
|     button     |   普通按钮   |     < input type="button"/>     |
|     reset      |   重置按钮   |     < input type="reset"/>      |
|     image      | 图片提交按钮 |     < input type="image"/>      |



#### 	3.3  select 元素(下拉列表)

> - 单选下拉列表：< select>< /select>
>
> - 默认选中属性：selected="selected"

```html
<select>
    <option selected="selected">内容</option>
    ...
    <option></option>
</select>
```



#### 	3.4  textarea元素(文本域)

> 多行文本框： < textarea cols="列" rows="行">< /textarea>



### 四、HTML框架标签

------

> - 通过使用框架，你可以在同一个浏览器窗口中显示不止一个页面。每份HTML文档称为一个框架，并且每个框架都独立于其他的框架。
> - 使用框架的缺点：
>   - 开发人员必须同时跟踪更多的HTML文档
>   - 很难打印整张页面



#### 4.1 框架结构标签frameset

> - 框架结构标签（ < frameset>< /frameset>）用于定义如何将窗口分割为框架
> - 每个 frameset 定义了一系列行或列 
> - rows/columns 的值规定了每行或每列占据屏幕的面积
>   - \<frameset rows="">< /frameset>
>   - \<frameset cols="">< /frameset>



#### 4.2 框架标签frame	

> 每个frame引入一个html页面

```html
<frameset cols="*,*">
    <frame src="info1.html" />
    <frame src="info2.html" />
</frameset>
```



#### 4.3 基本的注意事项

> - 不能将  < body>< /body> 标签与  < frameset>< /frameset> 标签同时使用
> - 假如一个框架有可见边框，用户可以拖动边框来改变它的大小。为了避免这种情况发生，可以在< frame>标签中加入：noresize="noresize"。



#### 4.4 综合案例

> 主页面

```html
<!-- frameset标签：(不能与body标签一起使用) -->
<frameset rows="20%,80%">
    <frame src="top.html" noresize/>
    <frameset cols="15%,*">
        <frame src="left.html" noresize/>
        <frame src="content.html" noresize name="content"/>
    </frameset>
</frameset>
```

> top页面

```html
<body>
    <h1>这是页面的头部</h1>
</body>
```

> left页面
>
> - 员工管理
> - 部门管理
> - 用户管理

```html
<body>
    <ul>
        <li><a href="http://www.baidu.com" target="content">员工管理</a></li>
        <li><a href="http://www.taobao.com" target="content">部门管理</a></li>
        <li><a href="http://www.jd.com" target="content">用户管理</a></li>
        <li><a href="http://www.sina.com" target="content">订单管理</a></li>
    </ul>
</body>
```

> content页面
>

```html
<body>
    <h1>这是页面的中间</h1>
</body>
```



#### 4.5 iframe

> iframe 元素会创建包含另外一个文档的内联框架（即行内框架）

```html
<!-- iframe标签 -->
<ul>
    <li><a href="08_超链接标签.html" target="content">员工管理</a></li>
    <li><a href="09_表格标签.html"  target="content">部门管理</a></li>
    <li><a href="10_表格跨行跨列.html"  target="content">用户管理</a></li>
    <li><a href="11_表单标签.html"  target="content">订单管理</a></li>
</ul>
<div>
    <iframe src="08_超链接标签.html" width="600px" height="600px" name="content"></iframe>
</div>
```



### 五、特殊字符标签

| 特殊字符 | 描述   |
| -------- | ------ |
| &nbsp ;  | 空格   |
| &gt ;    | 大于号 |
| &lt ;    | 小于号 |
| &reg ;   | 商标   |
| &copy ;  | 版权   |
| &quot ;  | 双引号 |
| &amp ;   | &符号  |

