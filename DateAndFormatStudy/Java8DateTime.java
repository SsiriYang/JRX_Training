package com.codeyang.jrxtraining.DateAndFormatStudy;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Set;

/**
 * @Author 41765
 * @Creater 2020/5/20 21:18
 * Description
 */
public class Java8DateTime {

    @Test
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
    @Test
    public void testFormat(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE));
        //自定义格式转换
        System.out.println(now.format(DateTimeFormatter.ofPattern("现在是" + "yyyy 年 M 月 dd 号 E HH 点 mm 分 ss 秒")));
    }

    @Test
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
        System.out.println(between.getDays());
    }
    @Test
    public void testZone(){
        ZoneId zoneId = ZoneId.systemDefault();
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
    }
}
