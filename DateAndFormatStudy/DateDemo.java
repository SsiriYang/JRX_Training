package com.codeyang.jrxtraining.DateAndFormatStudy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 41765
 * @Creater 2020/5/20 12:09
 * Description
 */
public class DateDemo {
    public static void main(String[] args) {
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
    }
}

