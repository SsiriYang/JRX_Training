---
layout: Post
title: "Java异常处理"
date: 2020-5-15 0:44
comments: true
tags: 
	- Java异常
---

# Java的异常

![](/assets/blogImg/yichang.png)

这是异常的类图。

**Throwable**是Error和Exception的父类，用来定义所有可以作为异常被抛出来的类。

**Erro**r和**Exception**区分：

**Error**:编译时错误和系统错误，系统错误在除特殊情况下，都不需要你来关心，基本不会出现。而编译时错误，如果你使用了编译器，那么编译器会提示。

**Exception**:是可以被抛出的基本类型，我们需要主要关心的也是这个类。

Exception又分为RunTimeException和其他Exception。

RunTimeException和其他Exception区分：

1. 其他Exception，受检查异常。可以理解为错误，必须要开发者解决以后才能编译通过，解决的方法有两种，1：throw到上层，2，try-catch处理。
2. RunTimeException：运行时异常，又称不受检查异常，所以在代码中可能会有RunTimeException时Java编译检查时不会告诉你有这个异常，但是在实际运行代码时则会暴露出来，比如经典的1/0，空指针等。如果不处理也会被Java自己处理。

# 异常处理

通常使用try catch finally；

## try/catch

```
try{
   // 程序代码
}catch(异常类型1 异常的变量名1){
  // 程序代码
}catch(异常类型2 异常的变量名2){
  // 程序代码
}catch(异常类型2 异常的变量名2){
  // 程序代码
}
```

## throws/throw

- 如果一个方法没有捕获一个检查性异常，那么该方法必须使用 throws 关键字来声明
- throws 关键字放在方法签名的尾部
- 也可以使用 throw 关键字抛出一个异常
- 一个方法可以声明抛出多个异常，多个异常之间用逗号隔开

### finally

- finally 关键字用来创建在 try 代码块后面执行的代码块。
- 无论是否发生异常，finally 代码块中的代码总会被执行。
- 在 finally 代码块中，可以运行清理类型等收尾善后性质的语句。
- finally 代码块出现在 catch 代码块最后

```
try{
  // 程序代码
}catch(异常类型1 异常的变量名1){
  // 程序代码
}catch(异常类型2 异常的变量名2){
  // 程序代码
}finally{
  // 程序代码
}
```

## Throwable下有两个方法需要常用

- public String getMessage() //返回关于发生的异常的详细信息
- public void printStackTrace()//打印toString()结果和栈层次到System.err，即错误输出流

# 自定义异常

一般会选择继承Exception和RuntimeException，如果不要求调用者一定要处理抛出的异常，就继承RuntimeException。

Student类

```java
public class Student {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        //给Student类的setAge方法做判断
        if(age<0 || age>130){
            //throw new ArithmeticException("年龄输入不符合规则");
            throw new AgeException("年龄输入不符合规则");
        }
        this.age = age;
    }
}
```

自定义的异常类

```java

public class AgeException extends Exception {
    public AgeException(String msg)
    {
        super(msg);
    }
}
```

测试

```java
public static void main(String[] args) {
    Student stu = new Student();
    try{
        stu.setAge(-150);
    }catch(Exception e){
        e.printStackTrace();
    }

    System.out.println("程序运行结束");
}

-----------------------------------------------------------
com.codeyang.jrxtraining.ExceptionStudy.AgeException: 年龄输入不符合规则
	at com.codeyang.jrxtraining.ExceptionStudy.Student.setAge(Student.java:20)
	at com.codeyang.jrxtraining.ExceptionStudy.DiyExceptionDemo.main(DiyExceptionDemo.java:13)
程序运行结束

```