package com.codeyang.jrxtraining.DateAndFormatStudy;

import org.junit.Test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @Author 41765
 * @Creater 2020/5/22 1:21
 * Description
 */
public class TimeZoneAndLocal {
    @Test
    public  void LocaleDemo(){
        Date date = new Date();
        Locale locale = Locale.CHINA;
        DateFormat shortDf = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL, locale);
        System.out.println("中国格式："+shortDf.format(date));
        locale = Locale.ENGLISH;
        shortDf = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL, locale);
        System.out.println("英国格式："+shortDf.format(date));
    }
    @Test
    public  void TimeZoneDemo() {
        Date date = new Date();
        Locale locale = Locale.CHINA;
        DateFormat shortDf = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL, locale);
        shortDf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println(TimeZone.getDefault().getID());
        System.out.println("中国当前日期时间：" + shortDf.format(date));
        locale = Locale.ENGLISH;
        shortDf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM, locale);
        shortDf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println("英国当前日期时间："+shortDf.format(date));
    }
}
