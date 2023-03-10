### 1、 CSS简介

---

#### 1.1 什么是CSS

> - CSS :全称：Cascading Style Sheets  层叠样式表,定义如何显示HTML元素
> - 多个样式可以层层覆盖叠加，如果不同的css样式对同一html标签进行修饰，样式有冲突的
>   应用优先级高的，不冲突的共同作用 

#### 1.2 CSS能干什么

> - 修饰美化html网页。
> - 外部样式表可以提高代码复用性从而提高工作效率。
> - html内容与样式表现分离，便于后期维护。

#### 1.3 CSS书写规范

> CSS 规则由两个主要的部分构成：选择器，以及一条或多条声明
>
> - 选择器通常是您需要改变样式的 HTML 元素。
> - 每条声明由一个属性和一个值组成。

#### 1.4 基础语法

> 选择器｛属性：值;属性:值….. ｝

|          语法示例           |
| :-------------------------: |
| ![](image\css_selector.gif) |



> 注意事项：
>
> - 请使用花括号来包围声明
> - 如果值为若干单词，则要给值加引号
> - 多个声明之间使用分号;分开
> - css对大小不敏感，如果涉及到与html文档一起使用时，class与id名称对大小写敏感



### 2、 CSS导入方式

------

#### 2.1 内嵌方式(内联方式)

>把CSS样式嵌入到html标签当中，类似属性的用法

```html
<span style="color: red;font-size: 30px;">这是一个普通文字1</span>
```

#### 2.2 内部方式

>在head标签中使用style标签引入css

```css
<style>
    p{
        color: blue;
        font-size: 40px;
    }
</style>
```

#### 2.3 外部方式

>将css样式抽成一个单独文件，使用者直接引用

```html
<link href="css/my.css" rel="stylesheet">
```

#### 2.4 @import方式

>在页面中引入一个独立的单独文件

```html
<style>
    @import url("css/my.css");
</style>
```

> link和@import方式的区别：
>
> - link所有浏览器都支持，@import某些版本低的IE不支持
> - @import是等待html加载完成才加载
> - @import不支持js动态修改



### 3、 CSS选择器

---

>  主要用于选择需要添加样式的html元素

#### 3.1 基本选择器

>元素选择器： 在head中使用style标签引入在其中声明元素选择器:html标签{属性:属性值}

> id选择器： 给需要修改样式的html元素添加id属性标识，在head中使用style标签引入在其中声明id选择器: #id值{属性:属性值}

> class选择器：给需要修改样式的html元素添加class属性标识，在head中使用style标签引入在其中声明class选择器:  .class名{属性:属性值}

>  备注：以上基本选择器的优先级从高到低：id选择器，class选择器，元素选择器

#### 3.2 层次选择器

##### 3.2.1 后代选择器

> 后代选择器指的是被选择元素的所有后代
>
> 语法：选择器1   选择器2{属性名：属性值;....}

##### 3.2.2 子代选择器

> 子代选择器指的是被选择元素的所有子代（不包含孙子）
>
> 语法：选择器1>选择器2{属性名：属性值;....}

##### 3.2.3 相邻兄弟选择器

> 相邻兄弟选择器指的是被选择元素的相邻兄弟（必须是相邻）
>
> 语法：选择器1+选择器2{属性名：属性值;....}

##### 3.2.4 兄弟选择器

> 相邻兄弟选择器指的是被选择元素的相邻兄弟（不是必须相邻）
>
> 语法：选择器1~选择器2{属性名：属性值;....}

#### 3.3 组合选择器

> 组合选择器直接是多个选择器同时设置样式
>
> 语法：选择器1,选择器2,....{属性名：属性值;....}

#### 3.4 属性选择器

> 通过标签属性，选择对应的元素
>
> 语法：标签[属性名=属性值]{属性名：属性值;....}

#### 3.5 伪类选择器

> 语法： 选择器 :伪类名称{属性名：属性值;....}



### 4、 CSS属性

---

#### 4.1 文字属性

|   属性名    |           取值           |     描述     |
| :---------: | :----------------------: | :----------: |
|  font-size  |           数值           | 设置字体大小 |
| font-family |    默体、宋体、楷体等    | 设置字体样式 |
| font-style  | normal正常; italic斜体;  | 设置斜体样式 |
| font-weight | 100~900数值;bold;bolder; |   粗体样式   |

#### 4.2 文本属性

|     属性名      |                          取值                           |         描述         |
| :-------------: | :-----------------------------------------------------: | :------------------: |
|      color      |              十六进制;表示颜色的英文单词;               |     设置文本颜色     |
|   text-indent   |       5px缩进5像素;20%缩进父容器宽度的百分之二十;       | 缩进元素中文本的首行 |
| text-decoration |             none;underline;overline;blink;              |     文本的装饰线     |
|   text-align    |                    left;right;center                    |   文本水平对齐方式   |
|  word-spacing   |                     normal;固定值;                      |    单词之间的间隔    |
|   line-height   |                     normal;固定值;                      |    设置文本的行高    |
|   text-shadow   | 四个取值依次是： 水平偏移；垂直偏移；模糊值；阴影颜色； |  设置阴影及模糊效果  |

#### 4.3 背景属性

|       属性名        |                取值                 |          描述          |
| :-----------------: | :---------------------------------: | :--------------------: |
|  background-color   |   16进制;用于表示颜色的英语单词;    |       设置背景色       |
|  background-image   |           url('图片路径')           |      设置背景图片      |
|  background-repeat  | repeat-y;repeat-x;repeat;no-repeat; |  设置背景图的平铺方向  |
| background-position |   top;bottom;left;right ; center;   | 改变图像在背景中的位置 |

#### 4.4 列表属性

|       属性名        |      取值       |               描述               |
| :-----------------: | :-------------: | :------------------------------: |
|   list-style-type   |     disc等      |        改变列表的标识类型        |
|  list-style-image   | url("图片地址") |          用图像表示标识          |
| list-style-position | inside;outside  | 标识出现在列表项内容之外还是内部 |

#### 4.5 尺寸属性

> - width:设置元素的宽度
> - height:设置元素的高度

#### 4.6 显示属性

> 显示属性display ，以下是常用取值：
>
> - none:不显示
> - block:块级显示
> - inline:行级显示
> - inline-block:行级块显示

#### 4.7 轮廓属性

> 绘制于元素周围的一条线，位于边框边缘的外围，可起到突出元素的作用。常用属性：

|    属性名     |                  取值                   |      描述      |
| :-----------: | :-------------------------------------: | :------------: |
| outline-style | solid(实线)/dotted(虚线)/dashed(虚线)等 | 设置轮廓的样式 |
| outline-color |        16进制;用于表示颜色的英文        | 设置轮廓的颜色 |
| outline-width |                  数值                   | 设置轮廓的宽度 |

#### 4.8 浮动属性float

> - 浮动的框可以向左或向右移动，直到它的外边缘碰到包含框或另一个浮动框的边框为止。由于浮动框不在文档的普通流中，所以文档的普通流中的块框表现得就像浮动框不存在一样。
>
> - 请看下图，当把框 1 向右浮动时，它脱离文档流并且向右移动，直到它的右边缘碰到包含框的右边缘：

|         浮动示例图         |
| :------------------------: |
| ![](image\positioning.gif) |



> - 再请看下图，当框 1 向左浮动时，它脱离文档流并且向左移动，直到它的左边缘碰到包含框的左边缘。因为它不再处于文档流中，所以它不占据空间，实际上覆盖住了框 2，使框 2 从视图中消失。
>
> - 如果把所有三个框都向左移动，那么框 1 向左浮动直到碰到包含框，另外两个框向左浮动直到碰到前一个浮动框。

|         浮动示例图          |
| :-------------------------: |
| ![](image\positioning2.gif) |



> 如下图所示，如果包含框太窄，无法容纳水平排列的三个浮动元素，那么其它浮动块向下移动，直到有足够的空间。如果浮动元素的高度不同，那么当它们向下移动时可能被其它浮动元素“卡住”：

|         浮动示例图          |
| :-------------------------: |
| ![](image\positioning3.gif) |



> clear 属性：规定元素的哪一侧不允许其他浮动元素。它的取值如下：

|  取值   |                 描述                  |
| :-----: | :-----------------------------------: |
|  left   |        在左侧不允许浮动元素。         |
|  right  |        在右侧不允许浮动元素。         |
|  both   |     在左右两侧均不允许浮动元素。      |
|  none   |   默认值。允许浮动元素出现在两侧。    |
| inherit | 规定应该从父元素继承 clear 属性的值。 |



#### 4.9 定位属性

>相对定位(relative)：元素框偏移某个距离，元素仍保持其未定位前的形状，它原本所占的空间仍保留。

>  绝对定位(absolute)：元素框从文档流完全删除，并相对于其包含块进行定位。包含块可能是文档中的另一个元素或者是初始包含块。元素原先在正常文档流中所占的空间会关闭，就好像元素原来不存在一样。元素定位后生成一个块级框。

>  固定定位(fixed)：元素框的表现类似于将 position 设置为 absolute，不过其包含块是视窗本身。



### 5、 CSS盒子模型

------

|         盒子模型图         |
| :------------------------: |
| ![盒子模型](image/box.png) |

#### 5.1 边框相关属性  

|    属性名     |             取值             |      描述      |
| :-----------: | :--------------------------: | :------------: |
| border-style  | solid;double;dashed;dotted等 | 设置边框的样式 |
| border-color  |  16进制;用于表示颜色的英文;  | 设置边框的颜色 |
| border-width  |             数值             |  设置边框的粗  |
| border-radius |             数值             |  设置圆角边框  |

#### 5.2 外边距相关属性

> margin：外间距,边框和边框外层的元素的距离

|    属性名     |         取值          |      描述      |
| :-----------: | :-------------------: | :------------: |
|    margin     | top;right;bottom;left | 四个方向的距离 |
|  margin-top   |         数值          |     上间距     |
| margin-bottom |         数值          |     下间距     |
|  margin-left  |         数值          |     左间距     |
| margin-right  |         数值          |     右间距     |

#### 5.3 内边距相关属性

> padding：内间距,元素内容和边框之间的距离((top right bottom left)) 

|     属性值     |   描述   |
| :------------: | :------: |
|  padding-left  | 左内边距 |
| padding-right  | 右内边距 |
|  padding-top   | 上内边距 |
| padding-bottom | 下内边距 |



### 6、弹性布局

------

> 容器默认存在两根轴：水平的主轴（main axis）和垂直的交叉轴（cross axis）

> 常用属性
>
> - flex-direction
>   - 决定主轴的方向
>     - row（默认值）：主轴为水平方向，起点在左端。
>     - row-reverse：主轴为水平方向，起点在右端。
>     - column：主轴为垂直方向，起点在上沿。
>     - column-reverse：主轴为垂直方向，起点在下沿。
> - flex-wrap
>   - 定义如果一条轴线排不下，如何换行。
>     -  nowrap :不换行
>     -  wrap : 换行，第一行在上方。
>     -  wrap-reverse:换行，第一行在下方。 
> - flex-flow
>   - flex-direction属性和flex-wrap属性的简写形式，默认值为row nowrap
> - justify-content
>   - 定义主轴上的对齐方式
>     - flex-start（默认值）：左对齐
>     - flex-end：右对齐
>     - center： 居中
>     - space-between：两端对齐，项目之间的间隔都相等。
>     - space-around：每个项目两侧的间隔相等。所以，项目之间的间隔比项目与边框的间隔大一倍。
> - align-items
>   - 定义交叉轴上如何对齐
>     - flex-start：交叉轴的起点对齐。
>     - flex-end：交叉轴的终点对齐。
>     - center：交叉轴的中点对齐。
>     - baseline: 项目的第一行文字的基线对齐。
>     - stretch（默认值）：如果项目未设置高度或设为auto，将占满整个容器的高度。
> - align-content
>   - 定义了多根轴线的对齐方式。如果项目只有一根轴线，该属性不起作用。

