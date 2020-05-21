package com.codeyang.jrxtraining.DateAndFormatStudy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 41765
 * @Creater 2020/5/20 11:50
 * Description
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) {
        // 创建一个Date对象，获取当前时间
        Date now = new Date();
        // 指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("现在是" + "yyyy 年 M 月 dd 号 E HH 点 mm 分 ss 秒");
        // 将当前时间袼式化为指定的格式
        System.out.println(f.format(now));
    }
}
