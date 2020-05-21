package com.codeyang.jrxtraining.ExceptionStudy;

import java.util.Scanner;

/**
 * @Author 41765
 * @Creater 2020/5/15 0:11
 * Description
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入被除数：");
        int a = sc.nextInt();
        System.out.println("请输入除数：");
        int b = sc.nextInt();
        try{
            System.out.println(a/b);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
        System.out.println("程序运算成功");
    }
}
