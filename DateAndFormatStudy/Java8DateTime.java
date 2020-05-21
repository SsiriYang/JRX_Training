package com.codeyang.jrxtraining.DateAndFormatStudy;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Set;

/**
 * @Author 41765
 * @Creater 2020/5/20 21:18
 * Description
 */
public class Java8DateTime {
    @Test
    public void testInstant(){
        Instant begin = Instant.now();
        int j = 0;
        for (int i=0;i<100000;i++){
            j=j+i+j;
        }
        Instant end = Instant.now();
        System.out.println(Duration.between(begin,end).toNanos());
    }
    @Test
    public void testLocalZone(){
        LocalDate now = LocalDate.now();
        // 构造实例 2019-9-22 21:42:59
        LocalDate localDate = LocalDate.of(2019, Month.SEPTEMBER, 22);
        LocalTime localTime = LocalTime.of(21, 42, 59);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());

        int year = localDate.getYear();
        LocalDate localDatePlus = localDate.plusYears(1);
        LocalDate localDateWithYear = localDate.withYear(2017);

        boolean after = localDate.isAfter(LocalDate.now());
        System.out.println(localDateWithYear);
    }
    @Test
    public void testFormat(){
        LocalDateTime now = LocalDateTime.now();
        // yyyy-MM-dd
        System.out.println(now.format(DateTimeFormatter.ISO_DATE));
        // yyyy-MM-ddTHH:mm:ss
        System.out.println(now.format(DateTimeFormatter.ISO_DATE_TIME));
        // yyyy-MM-dd HH:mm:ss
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    }
    @Test
    public void testParser(){
        System.out.println(LocalDate.parse("2019-09-22"));
        System.out.println(LocalDateTime.parse("2019-09-22T21:05:22"));
        System.out.println(LocalDateTime.parse("2019-09-22 21:05:22",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    }

    @Test
    public void testPeriodDuration(){
        // 两周的时间间隔
        Period periodWeeks = Period.ofWeeks(2);
        // 一天的时长
        Duration duration = Duration.ofDays(1);
        // 一年三个月零二天的间隔
        Period custom = Period.of(1, 3, 2);
        // 获取间隔天数
        int days = periodWeeks.getDays();
        // 计算2015/6/16 号到现在过了几天了
        LocalDate now = LocalDate.now();
        LocalDate customDate = LocalDate.of(2015, 6, 16);
        Period between = Period.between(customDate, now);
        System.out.println(between.getYears()+":"+between.getMonths()+":"+between.getDays());

        Period plusDays = between.plusDays(1);
        Period withDays = between.withDays(4);
    }
    @Test
    public void testZone(){
        ZoneId zoneId = ZoneId.systemDefault();
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
    }


}
