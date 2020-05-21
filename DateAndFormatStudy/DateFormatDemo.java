package com.codeyang.jrxtraining.DateAndFormatStudy;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Author 41765
 * @Creater 2020/5/20 11:44
 * Description
 *
    SHORT：完全为数字，如20-5-20。
    MEDIUM：较长，如 2020-5-20||11:46:07
    LONG：更长，如 2020年5月20日||上午11时46分07秒
    FULL：是完全指定，如 2020年5月20日 星期三||上午11时46分07秒 CST
 */
public class DateFormatDemo {
    public static void main(String[] args) {
        Date today = new Date();

        // 以默认语言环境格式打印日期
        Locale defaultLocale = Locale.getDefault();
        printLocaleDetails(defaultLocale);
        printDate(defaultLocale, today);

        // 以法语 打印日期
        printLocaleDetails(Locale.FRANCE);
        printDate(Locale.FRANCE, today);
    }

    public static void printLocaleDetails(Locale locale) {
        String languageCode = locale.getLanguage();
        String languageName = locale.getDisplayLanguage();
        String countryCode = locale.getCountry();
        String countryName = locale.getDisplayCountry();
        // 打印语言环境信息
        System.out.println("Language: " + languageName + "(" + languageCode + "); "
                + "Country: " + countryName + "(" + countryCode + ")");
    }

    public static void printDate(Locale locale, Date date) {
        //SHORT，FULL，MEDIUM，LONG
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        String formattedDate = formatter.format(date);
        System.out.println("SHORT: " + formattedDate);

        formatter = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        formattedDate = formatter.format(date);
        System.out.println("MEDIUM: " + formattedDate+"\n");
    }
}
