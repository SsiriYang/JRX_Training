package com.codeyang.jrxtraining.DateAndFormatStudy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author 41765
 * @Creater 2020/5/20 16:51
 * Description
 * Calendar是java util包下的一个工具类，提供了很方便的不同日期格式的处理。
 */
public class CalendarDemo {
    public static void main(String[] args) {
        System.out.println("------------Calendar无参构造------------");
        //Calendar对象，不传参数，默认为当前日期
        Calendar calendar =new GregorianCalendar();
        //获取当前年份
        System.out.println(calendar.get(Calendar.YEAR));
        //获取当前月份 从0开始，0代表一月，1代表二月，以此类推
        System.out.println(calendar.get(Calendar.MONTH));
        //获取当前日期 也可以使用DAY_OF_MONTH
        System.out.println(calendar.get(Calendar.DATE));
        //获取当前时 24小时进制
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        //获取当前分
        System.out.println(calendar.get(Calendar.MINUTE));
        //获取当前秒
        System.out.println(calendar.get(Calendar.SECOND));

        //获取今天是这个月的第几个星期
        System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));
        //获取今天是星期几  1表示星期天，2表示星期一，以此类推
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));


        System.out.println("------------Calendar有参构造------------");
        /**
         * 有参构造 分别代表年月日时分秒，写法简单明了，很符合我们人类的思维
         * 注意月份的设置是从0开始的，这里设置的是月份是6，实际是设置了7月份
         */
        calendar =new GregorianCalendar(2019, 6, 14, 16, 15,30);
        /**
         * 除了在构造方法直接设置之外，也可以通过set方法设置
         * 第一个参数表示设置的参数类型，第二个表示具体值
         */
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 20);

        System.out.println("------------Calendar和Date转换------------");
        Date now = calendar.getTime();
        calendar.setTime(now);


        System.out.println("------------Calendar日期计算以及判断------------");
        calendar = new GregorianCalendar();
        Calendar calendar2 = new GregorianCalendar();
        calendar2.set(Calendar.YEAR, 2200);
        //是否在某个时间(calendar2)之后
        System.out.println(calendar.after(calendar2));
        //是否在某个时间(calendar2)之前
        System.out.println(calendar.before(calendar2));
        //增加多少年年，月日以及时分秒同理
        calendar.add(Calendar.YEAR, -10);

    }

}
