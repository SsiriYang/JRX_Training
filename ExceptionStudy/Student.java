package com.codeyang.jrxtraining.ExceptionStudy;

/**
 * @Author 41765
 * @Creater 2020/5/15 0:16
 * Description
 */
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