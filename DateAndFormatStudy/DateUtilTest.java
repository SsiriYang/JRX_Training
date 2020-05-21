package com.codeyang.jrxtraining.DateAndFormatStudy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author 41765
 * @Creater 2020/5/20 17:28
 * Description
 */
public class DateUtilTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("-----begin-----");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("------end-------");
    }

    @Test
    public void getYear() {
        Date date = new Date();
        int year = DateUtil.getYear(date);
        System.out.println("年："+year);
    }

    @Test
    public void getQuarter() {
        Date date = new Date();
        int quarter = DateUtil.getQuarter(date);
        System.out.println("季度："+quarter);
    }

    @Test
    public void getMonth() {
        Date date = new Date();
        int month = DateUtil.getMonth(date);
        System.out.println("月："+month);
    }

    @Test
    public void getWeek() {
        Date date = new Date();
        int week = DateUtil.getWeek(date);
        System.out.println("周："+week);
    }

    @Test
    public void getDay() {
        Date date = new Date();
        int day = DateUtil.getDay(date);
        System.out.println("天："+day);
    }

    @Test
    public void getAll() {
        Date date = new Date();
        String all = DateUtil.getAll(date);
        System.out.println(all);
    }

    @Test
    public void addMonths() {
        Date date = new Date();
        Date date1 = DateUtil.addMonths(date,5);
        String addmonths = DateUtil.format(date1,"yyyy-MM-dd");
        System.out.println(addmonths);
    }

    @Test
    public void addDays() {
        Date date = new Date();
        Date date1 = DateUtil.addDays(date,5);
        String addDays = DateUtil.format(date1,"");
        System.out.println(addDays);
    }

    @Test
    public void addHours() {
        Date date = new Date();
        Date date1 = DateUtil.addHours(date,5);
        String addHours = DateUtil.format(date1,"");
        System.out.println(addHours);
    }

    @Test
    public void format() {
        Date date = new Date();
        String formatTest = DateUtil.format(date,"yyyy-M-d");
        System.out.println(formatTest);
    }
}