### BootStrap

#### 一、概念

> 基于HTML、CSS、JavaScript的一套快速开发页面的前端框架。
>
> 特点：
>
> - 移动设备优先。（支持移动设备）
>
> - 响应式设计（布局），能够自动适配于台式机、pad和手机。
>
> - 主流浏览器支持。
>
> - 容易上手和使用。

#### 二、基本使用

> 1、本地使用
>
> 下载bootstrap.css和bootstrap.js
>
> [注意：]()由于bootstrap底层采用jQuery编写，所以需要导入就jQuery，而且需要在bootstrap.js之前导入。
>
> 2、使用CDN
>
> ```html
> <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
> <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
> 
> <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
> <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
> 
> <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
> <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
> ```
>
> 组成：
>
> css样式、组件和js插件。

#### 三、栅格系统

> 作用，解决页面响应式布局问题。
>
> 将整个页面分为12列，元素占据的列会根据页面大小的不同而发生变化。

> [注意：]()如果需要设置移动设备优先，需要在head标签中有如下设置：
> `<meta name="viewport" content="width=device-width, initial-scale=1">`

> [注意：]()整个页面body中的内容必须包裹在一个div中，而且需要设置该div的样式为container或者container-fluid。
>
> `.container` 类用于固定宽度并支持响应式布局的容器。
>
> ```
> <div class="container">
>   ...
> </div>
> ```
>
> `.container-fluid` 类用于 100% 宽度，占据全部视口（viewport）的容器。
>
> ```
> <div class="container-fluid">
>   ...
> </div>
> ```

|                       | 超小屏幕 手机 (<768px)     | 小屏幕 平板 (≥768px)                                | 中等屏幕 桌面显示器 (≥992px) | 大屏幕 大桌面显示器 (≥1200px) |
| :-------------------- | :------------------------- | :-------------------------------------------------- | :--------------------------- | :---------------------------- |
| 栅格系统行为          | 总是水平排列               | 开始是堆叠在一起的，当大于这些阈值时将变为水平排列C |                              |                               |
| `.container` 最大宽度 | None （自动）              | 750px                                               | 970px                        | 1170px                        |
| 类前缀                | `.col-xs-`                 | `.col-sm-`                                          | `.col-md-`                   | `.col-lg-`                    |
| 列（column）数        | 12                         |                                                     |                              |                               |
| 最大列（column）宽    | 自动                       | ~62px                                               | ~81px                        | ~97px                         |
| 槽（gutter）宽        | 30px （每列左右均有 15px） |                                                     |                              |                               |
| 可嵌套                | 是                         |                                                     |                              |                               |
| 偏移（Offsets）       | 是                         |                                                     |                              |                               |
| 列排序                | 是                         |                                                     |                              |                               |

```html
<!doctype html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <style>
    	div{
    		border: 1px solid red;
    	}
    </style>
  </head>
  <body>
  	<div class="container">
	    <div class="row">
			  <div class="col-md-1 col-sm-2 col-xs-4">.col-md-1</div>
			  <div class="col-md-1 col-sm-2 col-xs-4">.col-md-1</div>
			  <div class="col-md-1 col-sm-2 col-xs-4">.col-md-1</div>
			  <div class="col-md-1 col-sm-2 col-xs-4">.col-md-1</div>
			  <div class="col-md-1 col-sm-2 col-xs-4">.col-md-1</div>
			  <div class="col-md-1 col-sm-2 col-xs-4">.col-md-1</div>
			  <div class="col-md-1 col-sm-2 col-xs-4">.col-md-1</div>
			  <div class="col-md-1 col-sm-2 col-xs-4">.col-md-1</div>
			  <div class="col-md-1 col-sm-2 col-xs-4">.col-md-1</div>
			  <div class="col-md-1 col-sm-2 col-xs-4">.col-md-1</div>
			  <div class="col-md-1 col-sm-2 col-xs-4">.col-md-1</div>
			  <div class="col-md-1 col-sm-2 col-xs-4">.col-md-1</div>
			</div>
			<div class="row">
			  <div class="col-md-8 col-sm-8 col-xs-12">.col-md-8</div>
			  <div class="col-md-4 col-sm-4 col-xs-12">.col-md-4</div>
			</div>
			<div class="row">
			  <div class="col-md-4 col-sm-4 col-xs-12">.col-md-4</div>
			  <div class="col-md-4 col-sm-4 col-xs-12">.col-md-4</div>
			  <div class="col-md-4 col-sm-4 col-xs-12">.col-md-4</div>
			</div>
			<div class="row">
			  <div class="col-md-6 col-sm-6 col-xs-12">.col-md-6</div>
			  <div class="col-md-6 col-sm-6 col-xs-12">.col-md-6</div>
			</div>
	</div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
  </body>
</html>
```

#### 四、文本排版

> 标题排版：

```html
<div class="container">
    <div class="h1 text-right">标题效果h1</div>
    <div class="h3">标题效果h3</div>
    <div class="text-uppercase">adsfgfdert</div>
</div>
```

> 对齐方式：

```html
<div class="container">
    <p class="text-left">sdfsdf</p>
    <p class="text-center">sdfsdf</p>
    <p class="text-right">sdfsdf</p>
    <p class="text-justify">sdfsdf</p>
    <p class="text-nowrap">sdfsdf</p>
</div>
```

#### 五、表格

> table：设置一个默认的表格样式
>
> table-hover：鼠标悬停变色
>
> table-bordered：表格边框
>
> table-striped：隔行变色
>
> 给行设置颜色：
>
> active：灰色
>
> success：绿色
>
> info：蓝色
>
> warning：黄色
>
> danger：红色

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
	</head>
	<body>
		<div class="container">
			<table class="table table-hover table-bordered">
		      <thead>
		        <tr>
		          <th>#</th>
		          <th>First Name</th>
		          <th>Last Name</th>
		          <th>Username</th>
		        </tr>
		      </thead>
		      <tbody>
		        <tr>
		          <th scope="row">1</th>
		          <td>Mark</td>
		          <td>Otto</td>
		          <td>@mdo</td>
		        </tr>
		        <tr>
		          <th scope="row">2</th>
		          <td>Jacob</td>
		          <td>Thornton</td>
		          <td>@fat</td>
		        </tr>
		        <tr>
		          <th scope="row">3</th>
		          <td>Larry</td>
		          <td>the Bird</td>
		          <td>@twitter</td>
		        </tr>
		      </tbody>
		    </table>
		    
		    
		    <table class="table table-bordered">
		      <thead>
		        <tr>
		          <th>#</th>
		          <th>Column heading</th>
		          <th>Column heading</th>
		          <th>Column heading</th>
		        </tr>
		      </thead>
		      <tbody>
		        <tr class="active">
		          <th scope="row">1</th>
		          <td>Column content</td>
		          <td>Column content</td>
		          <td>Column content</td>
		        </tr>
		        <tr class="success">
		          <th scope="row">2</th>
		          <td>Column content</td>
		          <td>Column content</td>
		          <td>Column content</td>
		        </tr>
		        <tr class="info">
		          <th scope="row">3</th>
		          <td>Column content</td>
		          <td>Column content</td>
		          <td>Column content</td>
		        </tr>
		        <tr class="warning">
		          <th scope="row">4</th>
		          <td>Column content</td>
		          <td>Column content</td>
		          <td>Column content</td>
		        </tr>
		        <tr class="danger">
		          <th scope="row">5</th>
		          <td>Column content</td>
		          <td>Column content</td>
		          <td>Column content</td>
		        </tr>
		        <tr>
		          <th scope="row">6</th>
		          <td>Column content</td>
		          <td>Column content</td>
		          <td>Column content</td>
		        </tr>
		        <tr >
		          <th scope="row">7</th>
		          <td>Column content</td>
		          <td>Column content</td>
		          <td>Column content</td>
		        </tr>
		        <tr>
		          <th scope="row">8</th>
		          <td>Column content</td>
		          <td>Column content</td>
		          <td>Column content</td>
		        </tr>
		        <tr >
		          <th scope="row">9</th>
		          <td>Column content</td>
		          <td>Column content</td>
		          <td>Column content</td>
		        </tr>
		      </tbody>
		    </table>
		</div>
	</body>
</html>
```

#### 六、表单

> 

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
	</head>
	<body>
		<div class="container">
			<form>
			  <div class="form-group">
			    <label for="exampleInputEmail1">Email address</label>
			    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Password</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputFile">File input</label>
			    <input type="file" id="exampleInputFile">
			    <p class="help-block">Example block-level help text here.</p>
			  </div>
			  <div class="checkbox">
			    <label>
			      <input type="checkbox"> Check me out
			    </label>
			  </div>
			  <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</body>
</html>
```

#### 七、按钮

> 

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
	</head>
	<body>
		<div class="container">
			<input type="button" class="btn btn-danger" value="按钮1"/>
			<a href="" class="btn btn-success">按钮2</a>
			
			<!-- Standard button -->
			<button type="button" class="btn btn-default btn-lg">（默认样式）Default</button>
			
			<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
			<button type="button" class="btn btn-primary btn-sm">（首选项）Primary</button>
			
			<!-- Indicates a successful or positive action -->
			<button type="button" class="btn btn-success">（成功）Success</button>
			
			<!-- Contextual button for informational alert messages -->
			<button type="button" class="btn btn-info btn-xs">（一般信息）Info</button>
			
			<!-- Indicates caution should be taken with this action -->
			<button type="button" class="btn btn-warning">（警告）Warning</button>
			
			<!-- Indicates a dangerous or potentially negative action -->
			<button type="button" class="btn btn-danger">（危险）Danger</button>
			
			<!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
			<button type="button" class="btn btn-link">（链接）Link</button>
		</div>
	</body>
</html>
```

#### 八、图片

```html
<img width="200px" height="200px" src="img/14.png" alt="..." class="img-rounded">
<img width="200px" height="200px" src="img/14.png" alt="..." class="img-circle">
<img width="200px" height="200px" src="img/14.png" alt="..." class="img-thumbnail">
```

