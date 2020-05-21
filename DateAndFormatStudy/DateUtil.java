package com.codeyang.jrxtraining.DateAndFormatStudy;

import com.sun.org.glassfish.gmbal.Description;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author 41765
 * @Creater 2020/5/20 16:19
 * Description 日期的工具类
 * 传入一个日期能查看年份、月份、季度、日期、星期数、是365天中的那一天。
 */
public class DateUtil {
    //日期格式化未传指定格式，规定该变量为默认格式
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    //声明一个Calendar对象
    static Calendar ca = Calendar.getInstance();
    /**
     * 默认构造方法
     */
    private DateUtil() {

    }

    /**
     * @Description //获取传入日期的年份
     * @Date 16:20 2020/5/20
     * @Param Date类型
     * @return Int类型 如：2020
     **/
    public static int getYear(Date date){
        int year = -1;
        ca.setTime(date);
        year = ca.get(Calendar.YEAR);
        return year;
    }
    /**
     * @Description //获取传入日期的季度
     * @Date 16:21 2020/5/20
     * @Param Date类型
     * @return Int类型 如：2
     **/
    public static  int getQuarter(Date date){
        int Quarter = -1;
        int month = getMonth(date);
        Quarter = (month + 2)/ 3;
        return Quarter;
    }
    /**
     * @Description //获取传入日期的月份
     * @Date 16:23 2020/5/20
     * @Param Date类型
     * @return Int类型 如：5
     **/
    public static  int getMonth(Date date){
        int month = -1;
        month = ca.get(Calendar.MONTH);
        //月份是从0-11，因此在此处做++操作。
        month++;
        return month;
    }
    /**
     * @Description //获取传入日期的星期
     * @Date 16:25 2020/5/20
     * @Param Date类型
     * @return Int类型 如：21
     **/
    public static  int getWeek(Date date){
        int week = -1;
        week = ca.get(Calendar.WEEK_OF_YEAR);
        return week;
    }
    /**
     * @Description //获取传入日期的那一天
     * @Date 16:38 2020/5/20
     * @Param Date类型
     * @return Int类型 如：141
     **/
    public static  int getDay(Date date){
        int day = -1;
        day = ca.get(Calendar.DAY_OF_YEAR);
        return day;
    }
    /**
     * @Description //分析日期，获取以上所有
     * @Date 16:38 2020/5/20
     * @Param Date类型
     * @return String类型 如：2020年 第2季度 4月 21周141天
     **/
    public static String getAll(Date date){
        String res = "";
        int year = getYear(date);
        int quarter  = getQuarter(date);
        int month = getMonth(date);
        int week = getWeek(date);
        int day = getDay(date);
        res = year+"年第"+quarter+"季度"+month+"月"+week+"周"+day+"天";
        return res;
    }
    /**
     * @Description //对指定日期加月
     * @Date 17:00 2020/5/20
     * @Param Date类型：指定日期； int类型：要加几个月
     * @return Date类型
     **/
    public static Date addMonths(Date date, int addMonths) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, addMonths);
        return calendar.getTime();
    }
    /**
     * @Description //指定日期加天
     * @Date 17:01 2020/5/20
     * @Param Date类型：指定日期； int类型：要加几天
     * @return Date类型
     **/
    public static Date addDays(Date date, int addDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, addDays);
        return calendar.getTime();
    }
    /**
     * @Description //指定日期加小时
     * @Date 17:02 2020/5/20
     * @Param Date类型：指定日期； int类型：要加几小时
     * @return Date类型
     **/
    public static Date addHours(Date date, int addHours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, addHours);
        return calendar.getTime();
    }
    /**
     * @Description //指定要求格式化日期
     * @Date 17:07 2020/5/20
     * @Param Date类型：指定日期； String类型：格式 yyyy-MM-dd HH:mm:ss
     * @return String
     **/
    public static String format(Date date, String pattern) {
        Date tempDate = null;
        if (date != null) {
            tempDate = date;
        } else {
            tempDate = Calendar.getInstance().getTime();
        }
        if (pattern == null || pattern.equals("")) {
            pattern = DATETIME_FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(tempDate);
    }
}
