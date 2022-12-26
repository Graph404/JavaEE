### 一、JavaScript简介



#### 1.1 JavaScript简介

> + JavaScript一种解释性脚本语言，是一种动态类型、弱类型、基于原型继承的语言，内置支持类型。
> + 它的解释器被称为JavaScript引擎，作为浏览器的一部分，广泛用于客户端的脚本语言，用来给HTML网页增加动态功能。



#### 1.2 JavaScript组成部分

> + [ECMAScript语法]()
>
> + [文档对象模型（DOM Document Object Model）]()
>
> + [浏览器对象模型(BOM Browser Object Model)]()



#### 1.3 JavaScript发展史

> - 它是由Netscape公司的Brendan Eich用10天设计出来一门脚本语言，JavaScript是甲骨文公司的注册商标。完整的JavaScript实现包含三个部分：ECMAScript，文档对象模型，浏览器对象模型。
> - Netscape在最初将其脚本语言命名为LiveScript，后来Netscape在与Sun合作之后将其改名为JavaScript。JavaScript最初受Java启发而开始设计的，目的之一就是“看上去像Java”，因此语法上有类似之处，一些名称和命名规范也借自Java。但JavaScript的主要设计原则源自Self和Scheme。JavaScript与Java名称上的近似，是当时Netscape为了营销考虑与Sun微系统达成协议的结果。为了取得技术优势，微软推出了JScript来迎战JavaScript的脚本语言。两者都属于ECMAScript的实现，为了互用性，ECAM（欧洲计算机制造商协会）创建了ECMA-262标准（ECMAScript）。ECMAScript最新版本是2015发布的 ECMAScript 6（ES6）。



### 二、JavaScript基本语法



#### 2.1 JS的引入方式

> JS的两种引入方式
>
>    1、直接在页面中添加script标签(任意位置)，然后编写js代码
>
>    2、将js代码写到js文件中，然后再引入到当前页面中
>
> 注意：
>
> ​	1、js可以写在页面的任意位置，但是js是解释性语言，从上往下依次执行，建议将js代码写在末尾
>
> ​	2、导入外部的js需要单独一个script标签，即不能再导入js的标签中写代码，否则会不执行

```html
<!-- 
    JavaScript引入方式：
    1、内部引入
    在页面任意位置编写script标签，然后编写js代码

    注意：尽量让js标签在网页的下面

    2、外部引入
    在外部写一个*.js文件，然后编写js代码
    然后在需要使用的html页面中引入js文件

    注意：在引入外部的js文件的script标签中不要编写代码，不会执行。
-->
<script>
    //页面弹窗
    alert("hello，js");
</script>

<script src="js/test.js"></script>
```



#### 2.2 JS的输出方式

> - 1、alert("输出内容");           通过弹窗输出内容
> - 2、console.log("输出内容");     通过控制台输出内容
>
> - 3、document.write("输出内容")   将内容输出在页面上

```html
<!-- 
    1、alert("内容");   弹框输出数据
    2、console.log("内容");  控制台输出数据(多)   打开开发者工具(f12)
    3、document.write("内容"); 在页面上输出数据
-->
<script>
    //alert("通过弹框输出数据");
    //console.log("通过控制台输出数据")
    document.write("直接在页面上输出数据")
</script>
```



#### 2.3 JS定义变量

> js是弱类型语言。在编码期间数据无需定义类型。然后运行期间动态的识别类型
> 
>​				var 变量名 = 值;			  
> 
>注意：
> 
>1、js中var用来表示数据类型(字符串不区分单双引号)
> 
>2、var可以省略不写，建议不要省略	
> 
>3、变量的命名规则：与java一致	 

```html
<script>
    var a = 10;
    var b = "aa";
    var c = true;
    var d = 'cc';
    e = 20.2
    console.log(a)
    console.log(b)
    console.log(c)
    console.log(d)
    console.log(e)

</script>
```



#### 2.4 JS数据类型

> JS中的数据类型
>
> 基本类型：
>
> - Number、String、boolean、undefined、null
>
> 引用类型		
>
> - Object、数组、函数

```html
<script>

    //基本类型
    var a = 10;
    console.log(typeof a);
    var b = 10.2;
    console.log(typeof b);
    var c = "hello";
    console.log(typeof c);
    var d = 'world';
    console.log(typeof d);
    var e = true;
    console.log(typeof e);
    var f;
    console.log(typeof f); //undefined 未定义类型
    var g = null;
    console.log(typeof g); //null 

    //引用类型
    var date = new Date();
    console.log(date);
    console.log(typeof date);

    //
    /**
	  * json对象
	  *   简单格式：   {key:value,key:value,key:value,...}
	  *   复杂格式：   {key:value,key:value,key:{key:value,key:value,key:value,...}}
	  */

    var product = {name:"红米手机",price:20,num:10000}
    console.log(product.name);
    console.log(product.price);
    console.log(product.num);

    console.log(typeof product);

    var emp = {ename:"smith",job:"java开发",dept:{dname:"开发部",location:"武汉"}}
    console.log(emp.ename);
    console.log(emp.job);
    console.log(emp.dept.dname);
    console.log(emp.dept.location);

</script>
```

> 注意：
>
> - number类型的特殊值
>   - NaN 			not a number 不是数字
>   - Infinity        无穷大
>



#### 2.5 JS数据类型转换

> string
>
> ​		1、任何类型与String使用+运算的结果都是String类型
>
> ​		2、String类型进行除了+运算意外都会将转换成number类型
>
> ​		3、String类型要想进行+运算，那么需要将其转换成number类型
>
> number类型、string类型、undefind 、object、null都可以转成boolean类型
>
> ​		1、number类型     非0即真
>
> ​		2、string类型     非""即真
>
> ​		3、object类型     真的
>
> ​		4、undefined类型  假的
>
> ​		5、null类型       假的

```html
<script>
    var a = "123";
    console.log(a+1);
    console.log(parseInt(a)+1);
    console.log(a-1);
    console.log(a*2);

    //var b = "1";
    //var b = -1;
    //var b ;
    //var b = null;
    var b = new Date();
    if(b){
        console.log("真的");
    }else{
        console.log("假的");
    }
</script>
```



#### 2.6 JS运算符

> - 算术运算符
> - 关系运算符
> - 赋值运算符
> - 逻辑运算符
> - 位运算符
> - 三目运算符

```html
<!-- 
算术运算符
+  -  *  /  %  ++ --
关系运算符
> < >= <= == != ===
逻辑运算符
|| && !
赋值运算符
=  +=  -=  *=  /=  %=
位运算符
|  &  ^  ~ >> << >>>
|:  相同位上，同为0结果才是0
&:  相同位上，同过1结果才是1
~:  取相反数-1
^:  相同位上，相同为0，不同为1
有符号右移正数前面补0，负数前面补1
无符号右移，前面永远补0(4个字节32位)

三目运算符
表达式 ?  结果1: 结果2;
-->

<script>
    var a = 5;
    console.log(a/2);

    var b = "12";
    var c = 12;
    console.log(b == c); //true     比较内容是否相等
    console.log(b === c); //false   比较内容是否相等，同时比较类型是否相等


    console.log(~-10)
    console.log(-12 >> 2)

    console.log(-12 >>> 2) 
</script>
```



#### 2.7 JS控制流程语句

> - if分支
> - switch分支
> - for循环、while循环、do while循环				

```html
<script>
			// for(var i = 0 ; i < 10 ;i++){
			// 	console.log("hello"+i)
			// }
			
			// var arr = [1,2,3,4,5,6,7];
			// for(var i = 0 ; i < arr.length ; i++){
			// 	console.log(arr[i])
			// }
			
			// for(var index in arr){
			// 	console.log(index)
			// }
			
			//九九乘法表,输出在页面上
			document.write("<table>")
			for(var i = 1 ; i < 10 ; i++){
				document.write("<tr>")
				for(var j = 1 ; j <= i ; j++){
					document.write("<td>")
					document.write(j+"*"+i + "=" + i*j)
					document.write("</td>")
				}
				document.write("</tr>")
			}
			document.write("</table>")
		</script>
```



#### 2.8 JS数组

```html
<!-- 
js中的数组定义方式：
1、静态定义
var 数组名 = [值1,值2,...];
2、动态定义
var 数组名 = new Array(值1,值2,...);
var 数组名 = new Array(数组的长度);
js中的数组的特点：
1、数组的长度是可以改变的
如果数组的长度变长，那么后面的元素用undefined表示
如果数组的长度变短，那么后面的元素就被删除掉了
如果数组的长度为0，那么表示清空数组

2、数组中可以存储任意数据类型


for in循环和for循环的区别：
forin循环会默认过滤掉多余的undefined元素(扩容之后数组中的undefined元素)

数组常用的方法：
数组名.push(元素);  向数组的最后一个位置添加元素
数组名.pop();      从数组中移除最后一个元素

-->
```

```html
<script>
    // var arr = [1,2,3,4,5];
    // console.log(arr[2]);
    //var arr = new Array(1,2,3,4,5);
    //console.log(arr[0]);

    // var arr = new Array(3);
    // console.log(arr[0]);

    var arr = [1,'a',undefined,new Date,undefined,undefined];
    // for(var i in arr){
    // 	console.log(arr[i])
    // }
    //arr.length = 6;

    //arr.length = 3;

    //arr.length = 0;

    //console.log(arr);

    // for(var i = 0 ; i < arr.length; i++){
    // 	console.log(arr[i])
    // }

    arr.push(6);

    arr.pop();
    for(var i in arr){
        console.log(arr[i])
    }

</script>
```



#### 2.9 JS函数

```html
<!-- 
java中的方法定义：
访问修饰符  修饰符  返回值类型  方法名(参数列表){
方法体;
}

js中方法的定义：
命名函数
语法：
function 函数名(参数列表){
方法体;
}

匿名函数(在js中函数也是一个对象)
var 函数对象名 = function(参数列表){
方法体;
}
js中的函数调用：


js中函数的特点：
1、形参和实参可以不一致
2、如果实参的数量大于形参的数量，那么后面的实参就没有作用了
3、如果实参的数量小于形参的数量，那么后面的形参用undefined表示
4、js中将所有的参数封装到了arguments对象中(数组)
5、js中的函数不允许重载(后面的函数会覆盖前面的函数)

js函数的返回值
如果函数需要返回值，则直接在函数中，添加return 返回的值
如果要退出函数，那么也可以直接使用return
-->
```

```html
<script>
    function f1(){
        console.log("f1函数...")
    }
    //函数调用
    //f1();
    function f2(name,age){
        console.log(name);
        console.log(age);
    }
    //函数调用
    //f2("cxk",30);

    var f3 = function(){
        console.log("匿名函数...")
    }
    //函数调用
    //f3();

    var f4 = function(a,b){
        //console.log(a+"======"+b)
        console.log(arguments.length);

        var sum = 0;
        for(var i = 0 ;i < arguments.length ; i++){
            sum += arguments[i];
        }
        console.log(sum);
    }

    //f4(10,20,30);
    //f4(10);
    //f4(10,20,30,40,50);

    function f5(){
        console.log("js中的函数")
    }
    function f5(a,b){
        console.log("js中的函数（重载）")
    }
    //f5(10,20);


    function f6(a,b){
        return a+b;
    }

     var result = f6(10,20);
     console.log(result);

</script>
```



#### 2.10 JS内置函数

> - 弹窗
>   - 普通警告框
>     - 警告框，没有返回值
>   - 带有确认和取消的弹窗
>     - 返回值是boolean类型。可以通过判断boolean来做出不同的操作
>   - 带有输入框的弹窗
>     - 返回值是输入的内容。点击确定会获取到这个输入的值。点击取消返回null
> - 转换函数
>   - 将字符串类型的数字，转换成number类型
>   - parseInt()和parseFloat()
> - 判断这个变量是否是非数字
>   - isNaN()

```html
<!-- 
    1、弹框函数
    alert();   警告框函数
    confirm(提示内容);  确定取消弹框
    prompt(提示内容);   带输入的弹框
    2、转换函数
    parseInt :将字符串转换成number类型，默认取整
    parseFloat：将字符串转换成number类型，保留小数
    isNaN：判断是不是，不是一个数字
-->

<script>
    //alert("警告框");

    //var flag = confirm("确定要删除吗？")	;
    // if(confirm("确定要删除吗？")){
    // 	alert("执行删除操作");
    // }

    // var str = prompt("请输入内容");
    // console.log(str);

    //var a = "12";    //12
    //var a = "12.8";  //12 
    //var a = "13 345 cvndsjkfnjkds"; //13
    //console.log(parseInt(a));

    //var b = "22"; //22
    //var b = "22.2"; //22.2
    //console.log(parseFloat(b));


    //console.log(10/0); //Infinity  无穷大
    //console.log("a"*2); //NaN    not a number  
    var c = "a"*2;
    var d = 10 - 2;
    console.log(isNaN(c));	//true		
    console.log(isNaN(d));  //false
</script>
```



#### 2.11 JS事件

| 事件名称    | 描述                         |
| ----------- | ---------------------------- |
| onchange    | HTML 元素内容改变            |
| onclick     | 用户点击 HTML 元素           |
| onmouseover | 用户将鼠标移入一个HTML元素中 |
| onmousemove | 用户在一个HTML元素上移动鼠标 |
| onmouseout  | 用户从一个HTML元素上移开鼠标 |
| onkeyup     | 键盘按键按下后抬起           |
| onkeydown   | 用户按下键盘按键             |
| onload      | 浏览器已完成页面的加载       |
| onsubmit    | 表单提交                     |
| onblur      | 当输入框失去焦点             |
| oninput     | 输入框内容改变               |

```html
<!-- 
	事件：
		事件源
			事件的源头。可以是页面上任意一个元素，如：button、img等等、键盘、鼠标
		事件类型
			不同的事件类型。如：单击事件、双击事件、鼠标移入、鼠标移除、键盘按下、失去焦点、内容改表等等
		事件监听
			对事件类型进行监听
		事件回调
			当事件触发之后执行函数
 -->
```

```html
<script>
    //页面加载完成之后执行
    window.onload = function(){
        console.log(document.getElementById("username"))
    }
</script>

<button onclick="f1()">点击一下</button>
<button ondblclick="f2()">双击两下</button>

<input type="text" name="username" onblur="f3()" id="username"/><span id="uSpan"></span> 

<select onchange="f4()" id="sel">
    <option value="1">1</option>
    <option value="3">3</option>
    <option value="5">5</option>
</select>

<img src="images/8.jpg" width="200px" height="200px" onmouseover="f5()" onmouseout="f6()">

<input oninput="f7()" type="text" name="searchName" />

<!-- 事件冒泡   submit按钮本身就有提交表单的作用  阻止事件:return false -->
<form action="" method="get" onsubmit="return f3()">
    用户名：<input type="text" name="username" onblur="f3()" id="username"/><span id="uSpan"></span>
    <input type="submit" value="登录" />
</form>


<script>

    function f1(){
        alert("按钮被点击了...");
    }
    function f2(){
        alert("按钮被双击了...");
    }
    function f3(){
        //1、获取输入框中的内容 2、判断是否合法
        var username = document.getElementById("username").value;
        if(username.length >= 6){
            document.getElementById("uSpan").innerHTML = "用户名可用";
            document.getElementById("uSpan").style.color = 'green';
            return true;
        }else{
            document.getElementById("uSpan").innerHTML = "用户名不可用";
            document.getElementById("uSpan").style.color = 'red';
            return false;
        }

        //alert("失去了焦点...");
    }
    function f4(){
        alert("下拉框内容改变..."+document.getElementById("sel").value);
    }

    function f5(){
        console.log("进来了...");
    }

    function f6(){
        console.log("出去了...");
    }
    function f7(){
        console.log("改变了....")
    }

    window.onkeydown = function(e){
        //console.log("键盘按下....")
        if(e.keyCode == 13){
            console.log("执行登录操作....")
        }
        //console.log(e.keyCode)
    }
    function f8(){
        console.log("表单提交了....")
    }

</script>
```



### 三、DOM（Document Object Model）



#### 3.1 获取元素节点

> - 1、通过标签的id属性获取元素节点   单个
>   - document.getElementById("id名称")
>
> - 2、通过class样式名获取元素节点   多个
>   -  document.getElementsByClassName("class名称")
>
> - 3、通过标签名称获取元素节点      多个
>   - document.getElementsByTagName("元素节点")
>
> - 通过name属性获取元素节点      多个
>   - document.getElementsByName("name名称")

```html
<p id="p1">这是一个p标签</p>
<input type="text" id="in">
<button class="btn">这是一个按钮</button>
<button class="btn">这是另一个按钮</button>
<input type="checkbox" name="hobby" />篮球
<input type="checkbox" name="hobby" />足球
<input type="checkbox" name="hobby" />排球
<!-- 
    获取元素节点：
        通过标签的id属性获取元素节点   单个
        	1、document.getElementById("id名称")
        通过class样式名获取元素节点   多个
       	 	2、document.getElementsByClassName("class名称")
        通过标签名称获取元素节点      多个
       	 	3、document.getElementsByTagName("元素节点")
        通过name属性获取元素节点      多个
       	 	4、document.getElementsByName("name名称")
-->
<script>
    // var p = document.getElementById("p1");
    // alert(p);
    // var inp = document.getElementById("in");
    // alert(inp);
    // var btn = document.getElementsByClassName("btn");
    // alert(btn[0]);
    // var p = document.getElementsByTagName("p");
    // alert(p[0]);
    var inputs = document.getElementsByName("hobby");
    alert(inputs.length);
</script>
```



#### 3.2 操作文本节点

> - 元素节点.innerHTML   获取|设置元素的文本节点
> - 元素节点.innerText      获取|设置元素的文本节点（不包含元素标签）

```html
<p id="p1"><span>这是一个p标签</span></p>
<button onclick="f1()">获取文本内容</button>
<button onclick="f2()">设置文本内容</button>

<script>
	//1、获取元素节点
	var p = document.getElementById("p1");
	function f1(){
		//获取文本节点上的内容
		//alert(p.innerHTML);
		alert(p.innerText);
	}
	function f2(){
		//设置文本节点上的内容
		p.innerHTML = "这是设置上去的值";
	}
</script>
```



#### 3.3 操作属性节点

> 元素节点.属性名          设置|获取元素节点的属性值

```html
<img src="images/1.jpg" width="200px" height="200px">
<button onclick="f1()">切换图片</button>
<input type="text" name="username"> 
<button onclick="f2()">获取输入框中的内容</button>

<input type="checkbox" name="hobby"/>篮球
<input type="checkbox" name="hobby" />足球
<input type="checkbox" name="hobby" />排球

<button onclick="f3()" id="btn">全选</button>


<script>
	function f1(){
		//1、获取img这个元素节点
		var img = document.getElementsByTagName("img")[0];
		//2、修改src属性
		if(img.src == 'http://127.0.0.1:8848/03_JavaScript/images/8.jpg'){
			img.src = "images/1.jpg";
		}else{
			img.src = "images/8.jpg";
		}
	}
	function f2(){
		//1、获取input这个元素节点
		var input = document.getElementsByName("username")[0];
		alert(input.value);
	}
	
	function f3(){
		var btn = document.getElementById("btn");
		if(btn.innerHTML == '全选'){
			//1、获取所有的复选框
			var hobbys = document.getElementsByName("hobby");
			//2、改变checked
			for(var i = 0 ; i < hobbys.length ; i++){
				hobbys[i].checked = true;
			}
			//3、将按钮上的字改成全不选
			btn.innerHTML = '全不选';
		}else{
			//1、获取所有的复选框
			var hobbys = document.getElementsByName("hobby");
			//2、改变checked
			for(var i = 0 ; i < hobbys.length ; i++){
				hobbys[i].checked = false;
			}
			//3、将按钮上的字改成全不选
			btn.innerHTML = '全选';
		}
	}
</script>
```



#### 3.4  操作元素节点

> - 创建元素：document.createElement()
> - 追加元素：appendChild()
> - 删除当前元素的指定子元素
>   - removeChild()
> - 删除当前元素及其所有的子元素
>   - remove()

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<ul id="city">
			<li>北京</li>
			<li id="wh">武汉</li>
			<li>上海</li>
			<li>杭州</li>
		</ul>
		<input type="text" name="name" id="name" />
		<button id="btn1">点击添加(默认在最后)</button>
		
		<button id="btn2">点击添加(指定的位置之前)</button>
		
		<button onclick="f3()">点击删除</button>
		
		<a href="19_jsBOM对象.html">123</a>
		<script>
			document.getElementById("btn1").onclick = function(){
				//1、获取输入框中的内容
				var name = document.getElementById("name").value;
				if(name == null || name == '' || name == undefined){
					alert("输入内容不能为空"); 
					return;
				}
				
				//创建li标签
				var li = document.createElement("li");
				//给li标签设置文本节点
				li.innerHTML = name;
				//将创建的li标签添加到ul中
				var ul = document.getElementById("city");
				ul.appendChild(li);
			}
			
			document.getElementById("btn2").onclick = function(){
				//1、获取输入框中的内容
				var name = document.getElementById("name").value;
				if(name == null || name == '' || name == undefined){
					alert("输入内容不能为空"); 
					return;
				}
				//创建li标签
				var li = document.createElement("li");
				//给li标签设置文本节点
				li.innerHTML = name;
				//将创建的li标签添加到ul中并且在指定的wh之前
				var ul = document.getElementById("city");
				ul.insertBefore(li,document.getElementById("wh"))
			}
			function f3(){
				//获取ul标签
				//var ul = document.getElementById("city");
				//删除当前元素的指定子元素
				//ul.removeChild(document.getElementById("wh"));
				
				var wh = document.getElementById("wh");
				//删除当前元素及其所有的子元素
				wh.remove();
			}
		</script>
		
	</body>
</html>
```



### 四、 正则表达式



> 正则表达式是由一组特殊的符号，组成的表达式语言
>
> 作用：对 字符串验证(匹配)、获取、替换、切割等操作

> 创建正则表达式对象

```js
var reg = new RegExp("正则表达式规则","匹配模式");
var reg = /正则表达式规则/匹配模式			
```

> 匹配模式：用于执行区分大小写和全局匹配:

| 匹配模式 | 描述                                                     |
| -------- | -------------------------------------------------------- |
| i        | 执行对大小写不敏感的匹配。                               |
| g        | 执行全局匹配（查找所有匹配而非在找到第一个匹配后停止）。 |
| m        | 执行多行匹配。                                           |

> 方括号：用于查找某个范围内的字符

| 表达式             | 描述                               |
| ------------------ | ---------------------------------- |
| [abc\]             | 查找方括号之间的任何字符。         |
| [^abc\]            | 查找任何不在方括号之间的字符。     |
| [0-9]              | 查找任何从 0 至 9 的数字。         |
| [a-z]              | 查找任何从小写 a 到小写 z 的字符。 |
| [A-Z]              | 查找任何从大写 A 到大写 Z 的字符。 |
| [A-z]              | 查找任何从大写 A 到小写 z 的字符。 |
| [adgk]             | 查找给定集合内的任何字符。         |
| [^adgk]            | 查找给定集合外的任何字符。         |
| (red\|blue\|green) | 查找任何指定的选项。               |

> 转义符（Metacharacter）：是拥有特殊含义的字符：

| 转义符 | 描述                                        |
| ------ | ------------------------------------------- |
| .      | 查找单个字符，除了换行和行结束符。          |
| \w     | 查找单词字符。                              |
| \W     | 查找非单词字符。                            |
| \d     | 查找数字。                                  |
| \D     | 查找非数字字符。                            |
| \s     | 查找空白字符。                              |
| \S     | 查找非空白字符。                            |
| \b     | 匹配单词边界。                              |
| \B     | 匹配非单词边界。                            |
| \0     | 查找 NULL 字符。                            |
| \n     | 查找换行符。                                |
| \f     | 查找换页符。                                |
| \r     | 查找回车符。                                |
| \t     | 查找制表符。                                |
| \v     | 查找垂直制表符。                            |
| \xxx   | 查找以八进制数 xxx 规定的字符。             |
| \xdd   | 查找以十六进制数 dd 规定的字符。            |
| \uxxxx | 查找以十六进制数 xxxx 规定的 Unicode 字符。 |

> 量词：用于表示重复次数的含义

| 量词   | 描述                                                         |
| ------ | ------------------------------------------------------------ |
| n+     | 匹配任何包含至少一个 n 的字符串。                            |
| n*     | 匹配任何包含零个或多个 n 的字符串。                          |
| n?     | 匹配任何包含零个或一个 n 的字符串。                          |
| n{X}   | 匹配包含 X 个 n 的序列的字符串。                             |
| n{X,}  | X 是一个正整数。前面的模式 n 连续出现至少 X 次时匹配。       |
| n{X,Y} | X 和 Y 为正整数。前面的模式 n 连续出现至少 X 次，至多 Y 次时匹配 |
| n{X}   | 前面的模式 n 连续出现X 次时匹配                              |
| n$     | 匹配任何结尾为 n 的字符串。                                  |
| ^n     | 匹配任何开头为 n 的字符串。                                  |
| ?=n    | 匹配任何其后紧接指定字符串 n 的字符串。                      |
| ?!n    | 匹配任何其后没有紧接指定字符串 n 的字符串。                  |

> RegExp 对象方法

| 方法 | 描述                                       |
| ---- | ------------------------------------------ |
| test | 检索字符串中指定的值。返回 true 或 false。 |

> 支持正则表达式的 String 对象的方法

| 方法    | 描述                             |
| ------- | -------------------------------- |
| search  | 检索与正则表达式相匹配值的下标。 |
| match   | 找到一个或多个正则表达式的匹配。 |
| replace | 替换与正则表达式匹配的子串。     |
| split   | 把字符串分割为字符串数组。       |

```html
<!-- 
	正则表达式是用来处理字符串，主要对字符串进行   匹配(重点)、切割、替换、查找
	
	创建正则表达式对象：
		1、var reg = new RegExp("正则表达式","模式");
		2、var reg = /正则表达式/模式
		
		
		模式：i 表示不区分大小写  g  全局匹配    m 多行匹配
 -->

<script>
	//1、创建一个正则表达式对象
	//var reg = new RegExp("ab");
	// var reg = /ab/;
	// var str = "bacb";
	// console.log(reg.test(str))//匹配
	
	
	//字符类
	
	//判断字符串中是否包含字母
	// var reg = /[a-z]/;
	// var str = "123";
	// console.log(reg.test(str));
	
	
	//判断字符串中是否包含字母(不区分大小写)
	// var reg = /[a-z]/i;
	// var str = "ADMIN123";
	// console.log(reg.test(str));
	
	
	//判断字符串是否包含数字
	// var reg = /[0-9]/;
	// var str = "admin9";
	// console.log(reg.test(str));

	//判断字符串中是否包含   a、m、k
	// var reg = /[amk]/;
	// var str = "admin9";
	// console.log(reg.test(str));
	
	
	
	//转义字符串
	/**
	 * 
	 *  任意字符          .  
	 *  [0-9]            \d
	 *  [a-zA-Z0-9_]     \w
	 */
	// var reg = /[\d]/;
	// var str = "admin";
	// console.log(reg.test(str));
	
	
	//数量词
	/**
	 *   *     表示0次或者多次 
	 *   ?     表示0次或者一次
	 *   +     表示一次或多次
	 *   {n}   表示刚好n次
	 *   {n,}  表示至少n次
	 *   {n,m} 表示至少n次，最多m次
	 * 
	 */
	
	//用户名必须是数字、字母、下划线组成、长度必须6位以上
	// var reg = /\w{6,}/;
	// var str = "admin-1";
	// console.log(reg.test(str));
	
	
	//前缀 ^ 和 后缀  $       
	
	//判断字符串是否是纯数字
	// var reg = /^\d+$/;
	// var str = "123456a";
	// console.log(reg.test(str));


	//获取字符串中所有的数字
	// var str = "1a2b3-4e5";
	// var reg = /\D/;
	// console.log(str.split(reg)); //切割
	
	
	//替换字符串中所有的非数字
	// var str = "1A2b3C4e5";
	// var reg = /[a-z]/ig;
	// console.log(str.replace(reg,"")); // 替换
	
	
	
	//查找字符串中所有的 手机号码
	// var str = "大数据库大数据了肯定\n大健康来得及案例     \n13467384950\n123213423435\n13467384950\n34545435345";
	// var reg = /[1][3-8][\d]{9}/g;
	// console.log(str.match(reg)); //查找
	
	
	//手机号码
	/**
	 * 1、纯数字
	 * 2、11位
	 * 3、1开头
	 * 4、第二为 【3、4、5、6、7、8】
	 */
	// var reg = /^[1][3-8][\d]{9}$/;
	// var str = "134673849501";
	// console.log(reg.test(str));
	
	//qq号码
	/**
	 * 1、纯数字
	 * 2、第一位不能0
	 * 3、最少5位最多10位
	 */
	// var reg = new RegExp("^[1-9][0-9]{4,9}$");
	// var str = "128543985943";
	// console.log(reg.test(str));
	
	//邮箱
	/**
	 * 1、必须要有@
	 * 2、@之前	字母、数字、下划线   至少6位 至多12位
	 * 3、@之后  字母、数字
	 * 4、.(com、cn、edu、org)  
	 */
	var reg = /^\w{6,12}[@][a-z0-9]{2,10}(\.(com|cn|edu|org))+$/;
	var str = "12376875@qq.com.bbc";
	console.log(reg.test(str));
	
</script>
```





### 五、BOM(Broswer Object Model)



#### 5.1 Window

> 指整个浏览器对象
>
> - 所有浏览器都支持 window 对象。它表示浏览器窗口。
>
> - 所有 JavaScript 全局对象、函数以及变量均自动成为 window 对象的成员。
>
> - 全局变量是 window 对象的属性。
>
> - 全局函数是 window 对象的方法。

#### 5.2 Screen

> 包含屏幕信息
>
> - 可用宽度：screen.availWidth 属性返回访问者屏幕的宽度，以像素计，减去界面特性，比如窗口任务栏。
> - 可用高度：screen.availHeight 属性返回访问者屏幕的高度，以像素计，减去界面特性，比如窗口任务栏。

```javascript
console.log(screen.availWidth);
console.log(screen.availHeight);
```

#### 5.3 Navigator

> 包含浏览器内部信息
>
> - 浏览器代号:navigator.appCodeName
> - 浏览器名称: navigator.appName
> - 浏览器版本:navigator.appVersion
> - 硬件平台:navigator.platform
> - 用户代理:navigator.userAgent 

```html
<div id="example"></div>
<script>
    txt = "<p>浏览器代号: " + navigator.appCodeName + "</p>";
    txt+= "<p>浏览器名称: " + navigator.appName + "</p>";
    txt+= "<p>浏览器版本: " + navigator.appVersion + "</p>";
    txt+= "<p>启用Cookies: " + navigator.cookieEnabled + "</p>";
    txt+= "<p>硬件平台: " + navigator.platform + "</p>";
    txt+= "<p>用户代理: " + navigator.userAgent + "</p>";
    txt+= "<p>用户代理语言: " + navigator.systemLanguage + "</p>";
    document.getElementById("example").innerHTML=txt;
</script> 
```



#### 5.4 History

> 相当于浏览器上的前进后退
>
> - window.history 对象包含浏览器的历史。
>   - history.back() 
>   - history.forward()
>   - history.go(n)

#### 5.5 Location

> 浏览器地址栏信息

```html
//跳转到指定的页面
location.href = "http://www.baidu.com";
//刷新页面
location.reload();
```



#### 5.6 定时器

> - setTimeout   只执行一次
>   - 参数1：定时任务的函数， 参数2：多长时间之后执行(毫秒)
> - setInterval  执行多次
>   - 参数1：定时任务的函数， 参数2：执行的周期(毫秒)
> - clearInterval(t);  结束定时任务

```java
<script>
    //setTimeout：任务只会执行一次    参数1：定时任务的回调函数  参数2：延迟时间
    // window.setTimeout(function(){
    //  console.log("定时器执行了")
    // },2000)

    var t ;
    function f1(){
        //setInterval：任务会多次执行   参数1：定时任务的回调函数  参数2：执行周期
        t = window.setInterval(function(){
            console.log("定时器执行了")
        },1000);
    }
    function f2(){
        //结束定时器 参数：定时器对象
        window.clearInterval(t);
    }
</script>
```


