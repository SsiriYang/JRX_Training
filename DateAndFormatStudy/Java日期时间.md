---
layout: Post
title: "Java日期时间"
date: 2020-5-20 11:44
comments: true
tags: 
	- Java日期时间及其格式化
---



# 日期

## Date （java.util.Date）

类图：![](/assets/blogImg/JavaUtilDate.png)

表示特定的瞬间，精确到毫秒。

### 构造函数

Date() : 分配 Date 对象并初始化此对象，以表示分配它的时间（精确到毫秒）。

Date(long date)：分配 Date 对象并初始化此对象，以表示自从标准基准时间，即 1970 年 1 月 1 日 00:00:00 GMT）以来的指定毫秒数。

### 常用方法

- `boolean after(Date date)`

  若当调用此方法的Date对象在指定日期之前返回true,否则返回false。

- `boolean before(Date date)`

  若当调用此方法的Date对象在指定日期之前返回true,否则返回false。

- `int compareTo(Date date)`

  比较当调用此方法的Date对象和指定日期。两者相等时候返回0。调用对象在指定日期之前则返回负数。调用对象在指定日期之后则返回正数。

- `long getTime( )`

  返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。

- `String toString( )`

  转换Date对象为String表示形式，并返回该字符串。

- `equals(Object obj)`

   比较两个日期的相等性。

### 学习Demo

```Java
//创建日期的对象
Date Nowdate = new Date();
SimpleDateFormat f = new SimpleDateFormat( "yyyy 年 M 月 dd 号 E HH 点 mm 分 ss 秒");
System.out.println(Nowdate);
System.out.println("今天是："+f.format(Nowdate));
//一天的毫秒数
long longms  =24*60*60*1000;
//当前时间的毫秒数
long longcms   = System.currentTimeMillis();
//获得昨天当前时间
Date yesterday = new Date(longcms-longms);
System.out.println(yesterday);
System.out.println("昨天是："+f.format(yesterday));
//若当调用此方法的Date对象在指定日期之后返回true,否则返回false。
Boolean resed = Nowdate.after(yesterday);
if(resed){
    System.out.println(f.format(yesterday)+"是过往");
}
//若当调用此方法的Date对象在指定日期之前返回true,否则返回false。
Boolean resing = yesterday.before(Nowdate);
if(resing){
    System.out.println(f.format(Nowdate)+"是当下");
}
//比较当调用此方法的Date对象和指定日期。两者相等时候返回0。调用对象在指定日期之前则返回负数。调用对象在指定日期之后则返回正数。
int ct1 = yesterday.compareTo(yesterday);
System.out.println(ct1);
int ct2 = yesterday.compareTo(Nowdate);
System.out.println(ct2);
int ct3 = Nowdate.compareTo(yesterday);
System.out.println(ct3);
// 比较两个日期的相等性。
System.out.println(yesterday.equals(Nowdate));
```

### Date(java.sql.Date)

类图：![](/assets/blogImg/JavaSQLDate.png)

java.sql.Date 是对应sql中的Date类型的。

日期格式为：年月日[只存储日期数据不存储时间数据] 。

 java.sql.Date类屏蔽了java.util.Date类的时间有关的方法（形如：hh:mm:ss）,因此，不可以通过这个类访问时间有关的信息。

### Time(java.sql.Time)Time

类图：![](/assets/blogImg/JavaSQLTime.png)

可见java.sql.Time是继承于java.util.Date，是用对Sql 中Time类型的支持的，其精度，是足以存放sql中的Time类型的。

java.sql.Time日期格式为：时分秒 。

 Java.sql.Time类屏蔽了java.util.Date的日期有关的字段（形如：yyyy-MM-dd）,因此，不能通过这个类访问日期有关的信息。

### Timestamp (java.sql.Timestamp)

类图：![](/assets/blogImg/JavaSQLTimestamp.png)

 同样java.sql.Timestamp也是继承于java.util.Date，它是对sql中Timestamp的支持，精度达到纳秒级。它是由java.util.Date与单独的纳秒数值共同组合而成的。

java.sql.Timestamp日期格式为：年月日时分秒纳秒（毫微秒）。

Java.sql.Timestamp字段则对java.util.Date这个类进行了扩充，它在java.util.Date类的基础上增加了毫秒的时间访问控制，可以通过`getNanos（）`方法去获取时间的毫微秒数（注意此处获取的时间是以毫微秒为单位的,1秒等于十亿毫微秒）



## Calendar

可以产生实现特定语言和日历风格的日期时间格式化所需的所有日历字段值

### 构造方法

- Calendar()
  	构建具有默认时区和默认的 FORMAT语言环境的日历。

- Calendar(TimeZone zone, Locale aLocale)
  	构造具有指定时区和区域设置的日历。

## 常用方法

- add(int field, int amount)
  		根据日历的规则，将指定的时间量添加或减去给定的日历字段。
- after(Object when)
  		返回 Calendar是否 Calendar指定时间之后的时间 Object 。
- before(Object when)
  		返回此 Calendar是否 Calendar指定的时间之前指定的时间 Object 。
- getInstance()
  		使用默认时区和区域设置获取日历。
- getInstance(Locale aLocale)
  		使用默认时区和指定的区域设置获取日历。
- getInstance(TimeZone zone)
  		使用指定的时区和默认语言环境获取日历。
- getInstance(TimeZone zone, Locale aLocale)
  		获取具有指定时区和区域设置的日历。

## TimeZone

TimeZone表示时区偏移量

### 构造方法

TimeZone()

### 常用方法

- getDefault()
  	获取Java虚拟机的默认值 TimeZone 。
- getID()
  	获取此时区的ID。
- setDefault(TimeZone zone)
  	设置 TimeZone由返回 getDefault方法。

# 日期格式化	

Java库提供了两个用于格式化日期的类：

- java.text.DateFormat

- java.text.SimpleDateFormat

  `DateFormat`是一个抽象类，我们可以使用`DateFormat`该类以预定义格式设置日期格式。

由于它是抽象的，因此我们无法对`DateFormat`使用`new`创建实例。

我们必须使用其`getXxxInstance()`方法之一来创建新实例。

​		`SimpleDateFormat`继承了`DateFormat`，要创建自定义日期格式，我们可以使用`SimpleDateFormat`类。

## DateFormat

类图：![](/assets/blogImg/DateFormat.png)



### 构造方法

- `DateFormat()`

  创建一个新的日期格式。

### 常用方法

- `String format(Date date)`--最常用

  将 Date 格式化日期/时间字符串

- `Calendar getCalendar()`

  获取与此日期/时间格式相关联的日历

- `static DateFormat getDateInstance()`

  获取具有默认格式化风格和默认语言环境的日期格式

- `static DateFormat getDateInstance(int style)`

  获取具有指定格式化风格和默认语言环境的日期格式

- `static DateFormat getDateInstance(int style,
  Locale locale)`

  获取具有指定格式化风格和指定语言环境的日期格式

- `static DateFormat getDateTimeInstance()`

  获取具有默认格式化风格和默认语言环境的日期/时间
  格式

- `static DateFormat getDateTimeInstance(int
  dateStyle,int timeStyle)`

  获取具有指定日期/时间格式化风格和默认语言环境的
  日期/时间格式

- `static DateFormat getDateTimeInstance(int
  dateStyle,int timeStyle,Locale locale)`

  获取具有指定日期/时间格式化风格和指定语言环境的
  日期/时间格式

- `static DateFormat getDateTimeInstance(int
  dateStyle,int timeStyle,Locale locale)`

  获取具有默认格式化风格和默认语言环境的时间格式

- `static DateFormat getTimeInstance(int style)`

  获取具有指定格式化风格和默认语言环境的时间格式

- `static DateFormat getTimeInstance(int style,
  Locale locale)`

  获取具有指定格式化风格和指定语言环境的时间格式

- `void setCalendar(Calendar newCalendar)`

  为此格式设置日历

- `Date parse(String source)`

  将给定的字符串解析成日期/时间

### DateFormat学习Demo

```Java
public static void main(String[] args) {
    Date today = new Date();

    // 以默认语言环境格式打印日期
    Locale defaultLocale = Locale.getDefault();
    printLocaleDetails(defaultLocale);
    printDate(defaultLocale, today);

    // 以法语 打印日期
    printLocaleDetails(Locale.FRANCE);
    printDate(Locale.FRANCE, today);
}

public static void printLocaleDetails(Locale locale) {
    String languageCode = locale.getLanguage();
    String languageName = locale.getDisplayLanguage();
    String countryCode = locale.getCountry();
    String countryName = locale.getDisplayCountry();
    // 打印语言环境信息
    System.out.println("Language: " + languageName + "(" + languageCode + "); "
            + "Country: " + countryName + "(" + countryCode + ")");
}

public static void printDate(Locale locale, Date date) {
    //SHORT，FULL，MEDIUM，LONG
    DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT, locale);
    String formattedDate = formatter.format(date);
    System.out.println("SHORT: " + formattedDate);

    formatter = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
    formattedDate = formatter.format(date);
    System.out.println("MEDIUM: " + formattedDate+"\n");
}
```

### SimpleDateFormat

类图：

![](/assets/blogImg/SimpleDateFormate.png)

#### 构造方法

- `SimpleDateFormat()`

  用默认的格式和默认的语言环境构造 SimpleDateFormat。

- `SimpleDateFormat(String pattern)`

  用指定的格式和默认的语言环境构造 SimpleDateF ormat。

- `SimpleDateFormat(String pattern,Locale locale)`

  用指定的格式和指定的语言环境构造 SimpleDateF ormat。

- `SimpleDateFormat(String pattern, DateFormatSymbols formatSymbols)`

  用给定的模式和日期符号构造 SimpleDateFormat。

#### 自定义格式中常用的字母及含义

- y:年份。一般用 yy 表示两位年份，yyyy 表示 4 位年份
- M:月份。一般用 MM 表示月份，如果使用 MMM，则会根据语言环境显示不同语言的月份

- d:月份中的天数。一般用 dd 表示天数
- D:年份中的天数。表示当天是当年的第几天， 用 D 表示
- E:星期几。用 E 表示，会根据语言环境的不同， 显示不同语言的星期几
- H:一天中的小时数（0~23)。一般用 HH 表示小时数
- h:一天中的小时数（1~12)。一般使用 hh 表示小时数
- m:分钟数。一般使用 mm 表示分钟数
- s:秒数。一般使用 ss 表示秒数
- S:毫秒数。一般使用 SSS 表示毫秒数

#### SimpleDateFormat学习Demo

```Java
public static void main(String[] args) {
    // 创建一个Date对象，获取当前时间
    Date now = new Date();
    // 指定格式化格式
    SimpleDateFormat f = new SimpleDateFormat("现在是" + "yyyy 年 M 月 dd 号 E HH 点 mm 分 ss 秒");
    // 将当前时间袼式化为指定的格式
    System.out.println(f.format(now));
}
```

# Java8-Date Time API 

java为什么要重新修订日期包？

在旧版的 Java 中，日期时间 API 存在诸多问题，其中有：

- **非线程安全** − java.util.Date 是非线程安全的，所有的日期类都是可变的，这是Java日期类最大的问题之一。
- **设计很差** −  Java的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类，此外用于格式化和解析的类在java.text包中定义。java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有相同的名字，这本身就是一个非常糟糕的设计。
- **时区处理麻烦** − 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有的问题。

Java 8日期/时间API是为了克服旧的日期/时间API实现中所有的缺陷，一些设计原则如下：

- 不变性：新的日期/时间API中，所有的类都是不可变的，这种设计有利于并发编程。
- 关注点分离：新的API将人可读的日期时间和机器时间（unix timestamp）明确分离，它为日期（Date）、时间（Time）、日期时间（DateTime）、时间戳（unix timestamp）以及时区定义了不同的类。
- 清晰：在所有的类中，方法都被明确定义用以完成相同的行为。举个例子，要拿到当前实例我们可以使用now()方法，在所有的类中都定义了format()和parse()方法，而不是像以前那样专门有一个独立的类。为了更好的处理问题，所有的类都使用了工厂模式和策略模式，一旦你使用了其中某个类的方法，与其他类协同工作并不困难。
- 实用操作：所有新的日期/时间API类都实现了一系列方法用以完成通用的任务，如：加、减、格式化、解析、从日期/时间中提取单独部分等操作。
- 可扩展性：新的日期/时间API是工作在ISO-8601日历系统上的，但我们也可以将其应用在非IOS的日历上。

## 常用类及其使用

新的日期时间工具全部都在 `java.time` 及其子包中；

- **Instant：** 表示时间线上的一个点
- **LocalDate：** 日期值对象如 2019-09-22
- **LocalTime：**时间值对象如 21:25:36
- **LocalDateTime：**日期+时间值对象
- **ZoneId：**时区
- **ZonedDateTime：**日期+时间+时区值对象
- **DateTimeFormatter：**用于日期时间的格式化
- **Period：**用于计算日期间隔
- **Duration：**用于计算时间间隔

### `LocalDate`、`LocalTime`、`LocalDateTime`、`ZonedDateTime` ，用于表示时间的

```java
    public void testLocal(){
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.of(2020,5, 20);
        LocalTime localTime = LocalTime.of(5, 20, 21);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        int year = localDate.getYear();
        int hour = localTime.getHour();
        //加减年份
        LocalDate localDateAS = localDate.plusYears(1);
        //某年的今日
        LocalDate localDateWithYear = localDate.withYear(2017);

        System.out.println(localDateAS);
    }
```

### `ZoneId` 用来操作时区，它提供了获取所有时区和本地时区的方法

```java
ZoneId zoneId = ZoneId.systemDefault();
Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
```

### `Period`，`Duration` 用于计算时间间隔

```java
    public void testPeriodDuration(){
        // 间隔一周
        Period periodWeeks = Period.ofWeeks(2);
        // 间隔一天
        Duration duration = Duration.ofDays(1);
        // 当下
        LocalDate now = LocalDate.now();
        //设置过去的一个事件
        LocalDate customDate = LocalDate.of(2020, 2, 16);
        Period between = Period.between(customDate, now);
        System.out.println(between);
    }
```

### **DateTimeFormatter**  用于日期时间的格式化

```Java
public void testFormat(){
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);
    System.out.println(now.format(DateTimeFormatter.ISO_DATE));
    //自定义格式转换
    System.out.println(now.format(DateTimeFormatter.ofPattern("现在是" + "yyyy 年 M 月 dd 号 E HH 点 mm 分 ss 秒")));
}
```

### 与 Date,Calendar 的转换

通过 `Instant`做中间转换实现`Date`，`Calendar` 与 `LocalDateTime`，`ZonedDateTime`，`LocalDate` 的互相转换。

```java
// LocalDateTime 转 Date
Date localDateTimeDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
// LocalDateTime 转 Calendar
Calendar localDateTimeCalendar = GregorianCalendar.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()));

// Date 转 LocalDateTime
LocalDateTime dateLocalDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
// Calendar 转 LocalDateTime
LocalDateTime calendarLocalDateTime = LocalDateTime.ofInstant(calendar.toInstant(), ZoneOffset.systemDefault());
```