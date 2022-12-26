### 一、JDBC（Java Database Connectivity）

#### 1.1 什么是 JDBC？

> JDBC（Java Database Connectivity） Java 连接数据库的规范（标准），可以使用 Java 语言连接数据库完成 CRUD 操作

#### 1.2 JDBC 核心思想

> Java 中定义了访问数据库的接口，可以为多种关系型数据库提供统一的访问方式。由数据库厂商提供驱动实现类（Driver 数据库驱动）。

|                         JDBC核心思想                         |
| :----------------------------------------------------------: |
| ![image-20210630175316152](image\image-20210630175316152.png) |



### 二、JDBC开发步骤【重点】

```java
/**
 * JDBC的开发步骤：
 *    0、准备工作
 *         a、准备数据库和数据表
 *         b、导入jar包
 * 			 	    1、在工程下新建一个lib的文件，将驱动jar包放入到文件夹中 
 *  			  	2、右击jar包---> add as library
 *                  注意：类路径(classpath) 就是java代码生成.class文件的路径
 *    1、注册驱动
 *    2、获取数据库连接对象Connection
 *    3、获取数据库操作对象
 *    4、通过数据库操作对象执行SQL语句
 *    5、处理结果
 *    6、释放资源
 */
```

#### 2.0 环境准备

> 环境准备
>
> *    a、将数据库连接驱动包赋值到当前工程的lib文件夹下
> *    b、将jar包添加到类路径(class文件生成的位置)中。右击jar包 ---> add as library

#### 2.1 注册数据库驱动

```java
//1、注册数据库驱动
//实现方式一：不推荐使用
//Driver driver = new Driver();
//DriverManager.registerDriver(driver);
//实现方式二：推荐使用
Class.forName("com.mysql.jdbc.Driver");//主动触发类加载，执行静态代码块，进而注册驱动
```

#### 2.2 获取数据库的连接

```java
 // 2、获取数据库连接对象Connection
/**
 * 网络编程三要素
 *      协议+地址+端口
 *      jdbc:mysql://localhost:3306/数据库名?serverTimezone=UTC
 */      
Connection conn = 
    DriverManager.getConnection("jdbc:mysql://localhost:3306/java2105", "root", "123456");
```

#### 2.3 获取数据库操作对象Statement

```java
// 3、获取数据库操作对象
Statement statement = conn.createStatement();
```

#### 2.4 通过Statement对象执行SQL语句

```java
// 4、通过数据库操作对象执行SQL语句
int count = statement.executeUpdate(
    "insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) 
    values (6666,'张三','java',7369,'2021-05-01',30000,200,30)");

```

#### 2.5 处理返回结果

```java
// 5、处理结果
if(count > 0){
    System.out.println("插入成功！！");
}else{
    System.out.println("插入失败！！");
}
```

#### 2.6 释放资源

```java
//6、释放资源
statement.close();
conn.close();
```



### 三、ResultSet结果集

```java
//5、处理结果集
/**
 * ResultSet提供了一组方法
 *          next(); 判断是否有下一行数据，如果有返回true，并将游标移动到下一行
 *          getXXX("字段名");    XXX表示字段在java中的对应的类型
 *          getXXX(列的下标);    XXX表示字段在java中的对应的类型
 */
```

#### 3.1 查询案例

> 查询emp表的数据

```java
while(rs.next()){
    int empno = rs.getInt("empno");
    //int empno = rs.getInt(1);
    System.out.println(empno);
    String ename = rs.getString("ename");
    System.out.println(ename);
    String job = rs.getString("job");
    System.out.println(job);
    Date hiredate = rs.getDate("hiredate");
    System.out.println(hiredate);
    double sal = rs.getDouble("sal");
    System.out.println(sal);
}
```



### 四、综合案例【登录】

#### 4.1 登录分析

```java
/**
 * 登录的思路：
 *      1、根据用户输入的用户名和密码到数据库中查询
 *          select * from tb_user where username = "你输入的用户名" and password = "你输入的密码"
 *          select * from tb_user where username = admin and password = 123
 *          如果有结果：登录成功
 *          如果没有结果：登录失败
 */
```

#### 4.2 登录案例实现

```java
public class JDBCDemo05 {    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = 
            DriverManager.getConnection("jdbc:mysql:///java2105", "root", "123456");
        Statement statement = conn.createStatement();
        String sql = " select * from tb_user where username = '" + 
            username + "' and password = '" + password +"'";
        System.out.println(sql);
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next()){
            //登录成功
            System.out.println("登录成功");
        }else{
            //登录失败
            System.out.println("登录失败");
        }
        rs.close();
        statement.close();
        conn.close();
    }
}
```

#### 4.3 登录案例分析

> 以上代码会出现SQL注入问题
>
> - 用户输入的数据中有 SQL 关键字或语法并且参与了 SQL 语句的编译，导致 SQL 语句编译后的条件含义为 true，一直得到正确的结果。这种现象称为 SQL 注入。
> - 字符串的拼接操作也是非常的不方便

#### 4.4 登录案例更新

```java
public class JDBCDemo06 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = 
            DriverManager.getConnection("jdbc:mysql:///java2105", "root", "123456");
        //3、获取数据库操作对象PreparedStatement    预加载SQL语句
        PreparedStatement ps =
            conn.prepareStatement("select * from tb_user where username = ? and password = ?");
        //3.1 设置占位符的值
        /**
         *  PreparedStatement对象中提供了一组方法
         *      setXXX(index从1开始,要传入的值)    XXX表示对应的java类型
         */
        ps.setString(1,username);
        ps.setString(2,password);
        System.out.println(ps);
        //4、执行SQL语句
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            //登录成功
            System.out.println("登录成功");
        }else{
            //登录失败
            System.out.println("登录失败");
        }
        rs.close();
        ps.close();
        conn.close();
    }
}
```

#### 4.5 PreparedStatement

> PreparedStatement 继承了 Statement 接口，执行 SQL 语句的方法无异。
>
> 作用：
>
> - 预编译SQL 语句，效率高。
> - 安全，避免SQL注入
>



### 五、ORM映射

#### 5.1 思想

> ORM （Object Relational Mapping)
>
> 将数据库中的表的数据，一行一行的映射到Java对象中

|                           ORM思想                            |
| :----------------------------------------------------------: |
| ![image-20210630180006259](image\image-20210630180006259.png) |

#### 5.2 实体类的规范

>  JavaBean设计规范
>  1、类名与表名一致，属性名和字段名一致
>
>  2、私有化属性对外提供set、get方法
>
>  3、提供有参和无参构造
>
>  4、基本数据类型要使用包装类(默认值)
>
>  5、在需要的时候实现序列化接口

#### 5.3 代码实现

> 查询

```java
public class JDBCDemo04 {
    public static void main(String[] args) throws Exception {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql:///java2105", "root", "123456");
        //3、获取数据库操作对象
        Statement statement = conn.createStatement();
        //4、执行SQL语句
        ResultSet rs = statement.executeQuery("select * from emp");
        //5、处理结果集
        //定义List集合保存所有的emp对象
        List<Emp> empList = new ArrayList<>();
        while(rs.next()){
            int empno = rs.getInt("empno");
            String ename = rs.getString("ename");
            String job = rs.getString("job");
            int mgr = rs.getInt("mgr");
            Date hiredate = rs.getDate("hiredate");
            double sal = rs.getDouble("sal");
            double comm = rs.getDouble("comm");
            int deptno = rs.getInt("deptno");
            //将查询的结果存放到Emp对象中
            Emp emp = new Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
            //将Emp对象添加到List中
            empList.add(emp);
        }
        //遍历集合中所有元素
        empList.forEach(System.out::println);
//        for(Emp emp : empList){
//            System.out.println(emp);
//        }
        //6、释放资源
        rs.close();
        statement.close();
        conn.close();
    }
}

```



### 六、封装工具类

> 1、注册数据库驱动（静态代码块） 
>
> 2、获取数据库连接 （方法：getConnection） 
>
> 3、释放资源  （方法：closeAll(Connection , Statement , ResultSet )）
>
> 4、将配置信息放到properties配置文件中，减少硬编码

#### 6.1 代码实现

> 工具类代码

```java
/**
* 数据库工具类
 */
public class JDBCUtils {
    /**
     * 1、注册驱动(只需要注册一次)
     *      可以将注册驱动的代码写到静态代码块中
     * 2、获取数据库连接
     *      提供静态一个方法，用于返回数据库连接对象
     * 3、关闭资源
     *      提供静态一个方法，用于释放资源
     * 4、硬编码问题(.xml  .properties)
     *      将数据源信息保存到配置文件中，然后在代码中进行读取
     *      properties文件的格式：key和value都是String类型
     *              key=value
     */
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static{
        try {
            //读取配置文件
            Properties properties = new Properties();
            //通过类对象读取当前类路径下的资源
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            //将配置文件中的信息读取到Properties集合中
            properties.load(in);
            //从集合中取出数据
            driver = properties.getProperty("driver123");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            //注册驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(Connection conn, Statement statement, ResultSet rs){
        try {
            if(rs!=null)
                rs.close();
            if(statement != null)
                statement.close();
            if(conn != null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
```

> 配置文件 db.properties

```properties
driver123=com.mysql.jdbc.Driver
url=jdbc:mysql:///java2105
username=root
password=123456
```

#### 6.2 工具类测试

```java
public class JDBCDemo01 {
    public static void main(String[] args) throws SQLException {
        //2、获取数据库连接
        Connection conn = JDBCUtils.getConnection();
        //3、获取数据库操作对象
        PreparedStatement ps = conn.prepareStatement("select * from emp");
        //4、执行SQL语句
        ResultSet rs = ps.executeQuery();
        //5、处理结果集
        while(rs.next()){
            int empno = rs.getInt("empno");
            String ename = rs.getString("ename");
            String job = rs.getString("job");
            int mgr = rs.getInt("mgr");
            Date hiredate = rs.getDate("hiredate");
            double sal = rs.getDouble("sal");
            double comm = rs.getDouble("comm");
            int deptno = rs.getInt("deptno");
            System.out.println(ename);
        }
        //6、释放资源
        JDBCUtils.closeAll(conn,ps,rs);
    }
}
```



### 七、DAO （Data Access Object）【掌握】

> DAO 实现了业务逻辑与数据库访问相分离。
>
> - 对同一张表的所有操作封装在XxxDaoImpl对象中。
> - 根据增删改查的不同功能实现具体的方法（insert、update、delete、select、selectAll）。

#### 7.1 开发流程

##### 7.1.1 EmpDao接口

```java
public interface EmpDao {
    //增加员工
    int insertEmp(Emp emp) throws SQLException;
    //删除员工
    int deleteEmp(int empno);
    //修改员工
    int updateEmp(Emp emp) throws SQLException;
    //查询所有员工
    List<Emp> selectAll() throws SQLException;
    //查询单个员工
    Emp selectOne(int empno);
}
```

##### 7.1.2 实体类

> com.qf.pojo包下创建实体类

```java
public class Emp {
   private Integer empno;
   private String ename;
   private String job;
   private Integer mgr;
   private Date hiredate;
   private Double sal;
   private Double comm;
   private Integer deptno;
    //省略get、set、构造方法
}
```

##### 7.1.3 EmpDao实现类

```java
public class EmpDaoImpl implements EmpDao {
    @Override
    public int insertEmp(Emp emp) throws SQLException {
        //2、获取数据库连接对象
        Connection conn = JDBCUtils.getConnection();
        //3、获取数据库操作对象
        PreparedStatement ps = conn.prepareStatement("insert into emp values(?,?,?,?,?,?,?,?)");
        //3.1设置占位符的值
        ps.setInt(1,emp.getEmpno());
        ps.setString(2,emp.getEname());
        ps.setString(3,emp.getJob());
        ps.setInt(4,emp.getMgr());
        //将util.date 转换成 sql.date
        ps.setDate(5,new Date(emp.getHireadate().getTime()));
        ps.setDouble(6,emp.getSal());
        ps.setDouble(7,emp.getComm());
        ps.setInt(8,emp.getDeptno());
        //4、执行SQL语句
        int count = ps.executeUpdate();
        //5、处理结果
        //6、释放资源
        JDBCUtils.closeAll(conn,ps,null);
        return count;
    }

    @Override
    public int deleteEmp(int empno) {
        return 0;
    }

    @Override
    public int updateEmp(Emp emp) throws SQLException {
        //2、获取数据库连接对象
        Connection conn = JDBCUtils.getConnection();
        //3、获取数据库操作对象
        PreparedStatement ps = conn.prepareStatement("update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno = ?");
        //3.1设置占位符的值
        ps.setString(1,emp.getEname());
        ps.setString(2,emp.getJob());
        ps.setInt(3,emp.getMgr());
        //将util.date 转换成 sql.date
        ps.setDate(4,new Date(emp.getHireadate().getTime()));
        ps.setDouble(5,emp.getSal());
        ps.setDouble(6,emp.getComm());
        ps.setInt(7,emp.getDeptno());
        ps.setInt(8,emp.getEmpno());
        //4、执行SQL语句
        int count = ps.executeUpdate();
        //5、处理结果
        //6、释放资源
        JDBCUtils.closeAll(conn,ps,null);
        return count;
    }

    @Override
    public List<Emp> selectAll() throws SQLException {
        //2、获取数据库连接对象
        Connection conn = JDBCUtils.getConnection();
        //3、获取数据库操作对象
        PreparedStatement ps = conn.prepareStatement("select * from emp");
        //4、执行SQL语句
        ResultSet rs = ps.executeQuery();
        //5、处理结果集
        List<Emp> empList = new ArrayList<>();
        while(rs.next()){
            int empno = rs.getInt("empno");
            String ename = rs.getString("ename");
            String job = rs.getString("job");
            int mgr = rs.getInt("mgr");
            Date hiredate = rs.getDate("hiredate");
            double sal = rs.getDouble("sal");
            double comm = rs.getDouble("comm");
            int deptno = rs.getInt("deptno");
            //将查询的结果存放到Emp对象中
            Emp emp = new Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
            //将Emp对象添加到List中
            empList.add(emp);
        }
        //6、释放资源
        JDBCUtils.closeAll(conn,ps,rs);
        return empList;
    }

    @Override
    public Emp selectOne(int empno) {
        return null;
    }
}
```

##### 7.1.4 测试类

```java
public class TestEmpDao {
    public static void main(String[] args) throws Exception {
        //测试查询所有
//        EmpDao empDao = new EmpDaoImpl();
//        List<Emp> empList = empDao.selectAll();
//        System.out.println(empList);
        
        //测试增加
//        EmpDao empDao = new EmpDaoImpl();
//        Emp emp = new Emp(9000,"韩梅梅","mysql",7369,new Date(),4000d,200d,30);
//        System.out.println(empDao.insertEmp(emp));

        //测试修改
        EmpDao empDao = new EmpDaoImpl();
        Emp emp = new Emp(9000,"李雷","java",7369,new Date(),40000d,200d,30);
        System.out.println(empDao.updateEmp(emp));
    }
}
```



### 八、Service 业务 【掌握】

#### 8.1 什么是业务

> 代表用户完成的一个业务功能，可以由一个或多个DAO的调用组成。（软件所提供的一个功能都叫业务）

#### 8.2 转账业务开发

|                         转账业务分析                         |
| :----------------------------------------------------------: |
| ![image-20201203170157904](image\image-20201203170157904.png) |

```java
public class AccountServiceImpl implements AccountService {
    AccountDao accountDao = new AccountDaoImpl();
    @Override
    public String zhuanZhang(String fromName, String password, String toName, double money) {
        try {
            //1、验证我方用户密码
            Account account = accountDao.selectAccount(fromName);
            if(account == null){
                return "用户名不存在";
            }
            if(!account.getPassword().equals(password)){
                return "用户密码不正确";
            }
            //2、验证余额
            if(account.getMoney() < money){
                return "用户余额不足";
            }
            //3、验证敌方用户
            if(accountDao.selectAccount(toName) == null){
                return "敌方用户名不存在";
            }
            //4、我方扣钱
            accountDao.updateAccount(fromName,-money);

            System.out.println(10/0);

            //5、敌方加钱
            accountDao.updateAccount(toName,money);

            return "转账成功";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "转账失败";
    }
}
```



### 九、事务【理解】

> 在JDBC 中，获得 Connection 对象开始事务--提交或回滚--关闭连接。其事务操作是
>
> - conn.setAutoCommit(false);//设置事务为手动提交
> - conn.commit();//手动提交事务
> - conn.rollback();//手动回滚事务

#### 9.1 转账业务实现

```java
public class AccountServiceImpl2 implements AccountService {
    AccountDao accountDao = new AccountDaoImpl();
    @Override
    public String zhuanZhang(String fromName, String password, String toName, double money) {
        Connection conn = JDBCUtils.getConnection();
        try {           
            //1、验证我方用户密码
            Account account = accountDao.selectAccount(fromName);
            if(account == null){
                return "用户名不存在";
            }
            if(!account.getPassword().equals(password)){
                return "用户密码不正确";
            }
            //2、验证余额
            if(account.getMoney() < money){
                return "用户余额不足";
            }
            //3、验证敌方用户
            if(accountDao.selectAccount(toName) == null){
                return "敌方用户名不存在";
            }
            //4、我方扣钱
            accountDao.updateAccount(fromName,-money);
            //System.out.println(10/0);
            //5、敌方加钱
            accountDao.updateAccount(toName,money);
            //提交事务
             conn.commit();
            return "转账成功";
        } catch (Exception throwables) {
            throwables.printStackTrace();
           try {
                //回滚事务
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return "转账失败";
    }
}
```

[注意：此时Service中的Connection与Dao中的Connection对象不一致，无法实现事务回滚]()

#### 9.2 解决方案1：传递 Connection

> - 如果使用传递Connection，容易造成接口污染（BadSmell）。
> - 定义接口是为了更容易更换实现，而将 Connection定义在接口中，会造成污染当前接口。

#### 9.3 解决方案2：ThreadLocal

> - 可以将整个线程中（单线程）中，存储一个共享值。
> - 线程拥有一个类似 Map 的属性，键值对结构<ThreadLocal对象，值>。

#### 9.4  使用ThreadLocal更新JDBC工具类

```java
/**
 * ThreadLocal<T>:能保存对象，能保证在同一个线程下获取到的对象是同一个
 *     set(T);
 *     get();
 *     remove();
 */
static ThreadLocal<Connection> tl = new ThreadLocal<>();

public static Connection getConnection(){
    //1、从ThreadLocal获取Connection
    //2、获取获取到了connection对象直接返回
    //3、创建Connection对象并存到ThreadLocal中，在进行返回
    Connection conn = tl.get();
    try {
        if(conn == null){
            conn = DriverManager.getConnection(url,username,password);
            tl.set(conn);
        }
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    return conn;
}
```

> [此时需要注意，如果关闭了Connetion连接，但是在ThreadLocal中还是保存着Connetion对象。下次会获取到一个已经关闭的Connection对象，所以需要从ThreadLocal中移除]()

#### 9.5 事务封装

> 将事务的开启、提交、回滚都封装在工具类中，业务层调用即可。

```java
 //封装事务操作的三个方法
public static void begin(){
    //1、获取Connection对象
    Connection conn = getConnection();
    try {
        //2、开启事务
        conn.setAutoCommit(false);
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
}
public static void commit(){
    //1、获取Connection对象
    Connection conn = getConnection();
    try {
        //2、提交事务
        conn.commit();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }finally {
        try {
            //3、关闭Connection资源
            conn.close();
            //从ThreadLocal中将connection移除掉
            tl.remove();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
public static void rollback(){
    //1、获取Connection对象
    Connection conn = getConnection();
    try {
        //2、回滚事务
        conn.rollback();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }finally {
        try {
            //3、关闭Connection资源
            conn.close();
            //从ThreadLocal中将connection移除掉
            tl.remove();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
```

#### 9.6 最终的转账业务

```java
public class AccountServiceImpl2 implements AccountService {
    AccountDao accountDao = new AccountDaoImpl();
    @Override
    public String zhuanZhang(String fromName, String password, String toName, double money) {
        try {
            //开启事务
            JDBCUtils.begin();
            //1、验证我方用户密码
            Account account = accountDao.selectAccount(fromName);
            if(account == null){
                return "用户名不存在";
            }
            if(!account.getPassword().equals(password)){
                return "用户密码不正确";
            }
            //2、验证余额
            if(account.getMoney() < money){
                return "用户余额不足";
            }
            //3、验证敌方用户
            if(accountDao.selectAccount(toName) == null){
                return "敌方用户名不存在";
            }
            //4、我方扣钱
            accountDao.updateAccount(fromName,-money);
            //System.out.println(10/0);
            //5、敌方加钱
            accountDao.updateAccount(toName,money);
            //提交事务
            JDBCUtils.commit();
            return "转账成功";
        } catch (Exception throwables) {
            throwables.printStackTrace();
            //回滚事务
            JDBCUtils.rollback();
        }
        return "转账失败";
    }
}
```



### 十 、三层架构【理解】

|                         三层架构原理                         |
| :----------------------------------------------------------: |
| ![image-20210701173922112](image\image-20210701173922112.png) |

|        三层架构下包结构         |
| :-----------------------------: |
| ![](image\三层架构下包结构.png) |



### 十一、单元测试

#### 11.1 单元测试

```java
/**
 * 单元测试：对已经编写完成的类、模块、方法进行测试
 
 * 使用步骤：
 *  1、导入单元测试的jar包(与驱动包导入一致)
 *  2、编写方法进行测试
 
 * 常用的注解：
 *    @Test         单元测试的方法
 *    @Before       在单元测试方法之前执行
 *    @After        在单元测试方法之后执行
 *    @BeforeClass  在类加载之前执行
 *    @AfterClass   在类卸载之后执行
 *
 * 单元测试需要注意的问题
 *    1、@BeforeClass测试的方法必须要加static修饰
 *    2、单元测试的方法不能有参数，不能有返回值
 *    3、不能再单元测试中写Scanner输入内容	
 */
```

```java
@BeforeClass
public static void testBeforeClass(){
    System.out.println("BeforeClass类加载的时候执行");
}

@Before
public void testBefore(){
    System.out.println("Before在单元测试方法之前执行(自动执行)");
}

@Test
public void test01(){
    System.out.println("单元测试");
}
@After
public void testAfter(){
    System.out.println("After在单元测试方法之后执行(自动执行)");
}
@AfterClass
public static void testAfterClass(){
    System.out.println("BeforeClass类卸载的时候执行");
}
```

> 执行结果

```
BeforeClass类加载的时候执行
Before在单元测试方法之前执行(自动执行)
单元测试
After在单元测试方法之后执行(自动执行)
BeforeClass类卸载的时候执行
```

#### 11.2 实际应用

> 在实际开发过程中，我们需要对写好的DAO层代码、Service层代码进行测试
>
> 一般就是对DAO、Service层中的每一个方法进行测试

```java
public class AccountTest {
    @Test
    public void testZhuanZhang(){
        AccountService accountService = new AccountServiceImpl2();
        String s = accountService.zhuanZhang("jack","123","rose",200);
        System.out.println(s);
    }
}
```



### 十二、连接池【理解掌握】

#### 12.1 Druid连接池

> 在程序初始化时，预先创建指定数量的数据库连接对象存储在池中。当需要连接数据库时，从连接池中取出现有连接；使用完毕后，也不会进行关闭，而是放回池中，实现复用，节省资源。

> - 创建 db.properties 配置文件。
> - 引入druid的jar 文件。

#### 12.2 db.properties

```properties
driverClass=com.mysql.jdbc.Driver
url=jdbc:mysql:///java2105?useSSL=false
username=root
password=123456
#初始化连接   （初始化连接池的，里面默认就已经存在了20个Connection连接）
initialSize=20
#最大连接数量  （当初始的20个连接不够的时候，最大会创建到50个）
maxActive=50
#最小空闲连接  (当连接池中的连接，没有被使用，就会减少到5个)
minIdle=5
#超时等待时间  (当连接数超过最大连接数，会等待5秒，如果5秒后还没有空闲连接，就会抛出异常)
maxWait=5000
```

#### 12.3 最终版JDBC工具类

```java
public class JDBCUtils {
    //定义数据库连接池
    private static DataSource dataSource;

    //初始化连接池对象
    static{
        try {
            Properties properties = new Properties();
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(in);
            //初始化连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //返回连接池对象
    public static DataSource getDataSource(){
        return dataSource;
    }
    //使用ThreadLocal保证Connection在同一个线程下唯一
    static ThreadLocal<Connection> tl = new ThreadLocal<>();
    public static Connection getConnection(){
        Connection conn = tl.get();
        try {
            if(conn == null){
                conn = dataSource.getConnection();
                tl.set(conn);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static void begin(){
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void commit(){
        Connection conn = getConnection();
        try {
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conn.close();
                tl.remove();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void rollback(){
        Connection conn = getConnection();
        try {
            conn.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conn.close();
                tl.remove();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
```

#### 12.4 连接池测试

```java
public class TestDruidDataSource {
    public static void main(String[] args) throws SQLException {
//        Connection conn1 = JDBCUtils.getConnection();
//        System.out.println(conn1);
//        Connection conn2 = JDBCUtils.getConnection();
//        System.out.println(conn2);
        for (int i = 0; i < 51; i++) {
            Connection connection = JDBCUtils.getDataSource().getConnection();
            System.out.println(connection);
            connection.close();//并不是关闭连接，而是归还到连接池中
        }
    }
}
```



### 十三、DaoUtils工具类【理解】

> 将Dao层中增删改的代码进行封装

#### 13.1 工具类实现

```java
public class DaoUtils {
    //更新操作(增删改) insert into emp values(?,?,?,?,?,?,?,?)
    public static int commonsUpdate(String sql,Object... args) throws SQLException {
        //1、获取数据库连接对象
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        try {
            //2、获取数据库操作对象
           ps = conn.prepareStatement(sql);
            //3、设置占位符的值
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //4、执行sql语句
            int count = ps.executeUpdate();
            //5、处理结果
            return count;
        } finally {
            //6、关闭资源
            JDBCUtils.closeAll(null,ps,null);
        }
    }
    public static <T> List<T> commonsQuery(String sql, Class c, Object... args) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1、获取数据库连接对象
            Connection conn = JDBCUtils.getConnection();
            //2、获取数据库操作对象
            ps = conn.prepareStatement(sql);
            //3、设置占位符的值
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //4、执行SQL语句
            rs = ps.executeQuery();
            //5、处理结果集
            List<T> list = new ArrayList<>();
            while(rs.next()){
                //通过类对象获取类的属性
                Field[] fields = c.getDeclaredFields();
                T obj = (T) c.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    //暴力反射
                    fields[i].setAccessible(true);
                    fields[i].set(obj,rs.getObject(i+1));
                }
                //将对象装到List集合中
                list.add(obj);
            }
            return list;
        }finally {
            JDBCUtils.closeAll(null,ps,rs);
        }
    }
}
```

#### 13.2 DaoUtils工具类使用

```java
public class EmpDaoImpl implements EmpDao {
    @Override
    public int insertEmp(Emp emp) throws SQLException {
        String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
        Object[] args = {emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHireadate(),emp.getSal(),emp.getComm(),emp.getDeptno()};
        return DaoUtils.commonsUpdate(sql,args);
    }

    @Override
    public int updateEmp(Emp emp) throws SQLException {
        String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno = ?";
        Object[] args = {emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHireadate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno()};
        return  DaoUtils.commonsUpdate(sql,args);
    }

    @Override
    public int deleteEmp(int empno) throws SQLException {
        String sql = "delete from emp where empno = ?";
        Object[] args = {empno};
        return DaoUtils.commonsUpdate(sql,args);
    }

    @Override
    public List<Emp> selectAll() throws Exception {
        String sql = "select * from emp";
        return DaoUtils.commonsQuery(sql,Emp.class);
    }
}
```



### 十四、DBUtils工具类【熟练掌握】

#### 14.1 DBUtils简介

> DbUtils是Java编程中数据库操作实用小工具，小巧、简单、实用
>
> - 对于数据表的查询操作，可以把结果转换为List、Array、Set等集合。便于操作。
> - 对于数据表的DML操作，也变得很简单(只需要写SQL语句)。

#### 14.2 DbUtils核心API

> - ResultSetHandler接口：转换类型接口
>   - BeanHandler类：实现类，把一条记录转换成对象
>   - BeanListHandler类：实现类，把多条记录转换成List集合。
>   - ScalarHandler类：实现类，适合获取一行一列的数据。
>   - MapHandler类： 实现类，把一条记录转换成Map集合
>   - MapListHandler类：实现类，把多条记录转换成List集合。
> - QueryRunner：执行sql语句的类
>   - 增、删、改：update();
>   - 查询：query();

#### 14.3 DbUtils的使用步骤

> 导入jar包
>
> - mysql连接驱动jar包
> - 导入druid 的jar包
> - database.properties配置文件
> - [导入commons-dbutils的jar包]()

#### 14.4 DBUtils使用

> 使用DBUtils实现增删改查

```java
public class EmpDaoImpl implements EmpDao {
    @Override
    public int insertEmp(Emp emp) throws SQLException {
        //1、创建QueryRunner对象
        //如果是更新（增删改）操作,那么就用无参的构造
        QueryRunner qr = new QueryRunner();
        //2、通过QueryRunner对象调用update
        String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
        Object[] args = {emp.getEmpno(),emp.getEname1(),emp.getJob(),emp.getMgr(),emp.getHireadate(),emp.getSal(),emp.getComm(),emp.getDeptno()};
        return qr.update(JDBCUtils.getConnection(),sql,args);
    }

    @Override
    public int updateEmp(Emp emp) throws SQLException {
        //1、创建QueryRunner对象
        //如果是更新（增删改）操作,那么就用无参的构造
        QueryRunner qr = new QueryRunner();
        //2、通过QueryRunner对象调用update
        String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno = ?";
        Object[] args = {emp.getEname1(),emp.getJob(),emp.getMgr(),emp.getHireadate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno()};
        return qr.update(JDBCUtils.getConnection(),sql,args);
    }

    @Override
    public int deleteEmp(int empno) throws SQLException {
        //1、创建QueryRunner对象
        //如果是更新（增删改）操作,那么就用无参的构造
        QueryRunner qr = new QueryRunner();
        //2、通过QueryRunner对象调用update
        String sql = "delete from emp where empno = ?";
        Object[] args = {empno};
        return qr.update(JDBCUtils.getConnection(),sql,args);
    }
    @Override
    public List<Emp> selectAll() throws Exception {
        //1、创建QueryRunner对象
        //如果是查询操作,那么就用有参的构造，传递连接池对象（使用完成之后QueryRunner会自动关闭(回收)）
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //2、通过QueryRunner对象调用query
        String sql = "select empno,ename ename1,job,mgr,hiredate hireadate,sal,comm,deptno from emp";
        //如果是集合就创建BeanListHandler对象，如果是实体类就创建BeanHandler对象
        List<Emp> empList = qr.query(sql, new BeanListHandler<Emp>(Emp.class));
        return empList;
    }
    @Override
    public Emp selectOne(int empno) throws SQLException {
        //1、创建QueryRunner对象
        //如果是查询操作,那么就用有参的构造，传递连接池对象（使用完成之后QueryRunner会自动关闭(回收)）
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //2、通过QueryRunner对象调用query
        String sql = "select * from emp where empno = ?";
        Object[] args = {empno};
        Emp emp = qr.query(sql, new BeanHandler<Emp>(Emp.class),args);
        return emp;
    }

    @Override
    public long count() throws SQLException {
        //1、创建QueryRunner对象
        //如果是查询操作,那么就用有参的构造，传递连接池对象（使用完成之后QueryRunner会自动关闭(回收)）
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select count(*) from emp";
        Long count = qr.query(sql, new ScalarHandler<Long>());
        return count;
    }
}
```

#### 14.5 字段与属性名不一致

##### 14.5 通过SQL别名解决

> [如果数据库的字段名与实体类中的属性名不一致，则无法完成映射，值会显示null]()
>
> [解决：在查询语句中取别名]()

```java
@Override
public List<Emp> selectAll() throws Exception {
    //1、创建QueryRunner对象
    //如果是查询操作,那么就用有参的构造，传递连接池对象（使用完成之后QueryRunner会自动关闭(回收)）
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    //2、通过QueryRunner对象调用query
    //通过别名进行数据映射
  String sql = "select empno,ename ename1,job,mgr,hiredate hireadate,sal,comm,deptno from emp";
    //如果是集合就创建BeanListHandler对象，如果是实体类就创建BeanHandler对象
    List<Emp> empList = qr.query(sql, new BeanListHandler<Emp>(Emp.class));
    return empList;
}
```

```java
public class Emp {
    private Integer empno;
    private String ename1; //这个与数据库字段不一致
    private String job;
    private Integer mgr;
    private Date hireadate; //这个与数据库字段不一致
    private Double sal;
    private Double comm;
    private Integer deptno;
	//省略set、get、构造方法
}
```

#### 14.6 多表关联查询

##### 14.6.1 MapListHandler解决

> 现阶段先试用MapListHandler解决，后面使用自定义映射解决(开发常用)

> 需求：查询员工信息及其部门信息

```java
@Override
public List<Map<String,Object>> selectAll() throws Exception {
    //1、创建QueryRunner对象
    //如果是查询操作,那么就用有参的构造，传递连接池对象（使用完成之后QueryRunner会自动关闭(回收)）
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    //2、通过QueryRunner对象调用query
    //通过别名进行数据映射
    String sql = "select empno,ename,job,mgr,hiredate,sal,comm,e.deptno,dname,location from emp e left join dept d on e.deptno = d.deptno";
    //如果结果无法直接映射到实体类中，可以暂时映射到List<Map>中，默认使用查询的字段名作为map集合的key
    List<Map<String,Object>> empList = qr.query(sql, new MapListHandler<>());
    return empList;
}
```



### 十五、Lombok插件

> Lombok简化编写类的构造方法、setget方法以及toString方法

> 使用步骤

| 安装插件，需要重启[目前IDEA版本已经自带此插件无需安装]() |
| :------------------------------------------------------: |
|          ![](image\image-20200727095902064.png)          |

|            开启IEDA注解可用            |
| :------------------------------------: |
| ![](image\image-20200727100138148.png) |

|               新版本使用lombok插件需要添加配置               |
| :----------------------------------------------------------: |
|            **-Djps.track.ap.dependencies=false**             |
| ![image-20210325172557819](image\image-20210325172557819.png) |

|                          导入jar包                           |
| :----------------------------------------------------------: |
| ![image-20210325172427908](image\image-20210325172427908.png) |

|                          编写实体类                          |
| :----------------------------------------------------------: |
| ![image-20210325172345907](image\image-20210325172345907.png) |

> [以上步骤需要在setting中进行设置还需要在setting for newproject中设置]()