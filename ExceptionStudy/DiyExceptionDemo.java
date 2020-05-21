package com.codeyang.jrxtraining.ExceptionStudy;

/**
 * @Author 41765
 * @Creater 2020/5/15 0:14
 * Description
 */
public class DiyExceptionDemo {

    public static void main(String[] args) {
        Student stu = new Student();
        try{
            stu.setAge(-150);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("程序运行结束");
    }
}
