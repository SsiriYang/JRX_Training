package com.codeyang.jrxtraining.ExceptionStudy;

import java.util.Scanner;

/**
 * @Author 41765
 * @Creater 2020/5/15 0:12
 * Description
 */
public class TryCatchfinallyDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入被除数：");
        int a = sc.nextInt();
        System.out.println("请输入除数：");
        int b = sc.nextInt();
        try{
            System.out.println(a/b);

            int[] arr={10,20,30,40};
            System.out.println(arr[1]);
            System.out.println("try执行结束");
        }catch(ArithmeticException e){
            System.out.println("除数不能是0");
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("数组下标越界");
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //不管程序是否有异常，该段代码都会执行      //java连接数据库     关闭资源
            System.out.println("finally");
        }
        System.out.println("程序运算成功");
    }
}
