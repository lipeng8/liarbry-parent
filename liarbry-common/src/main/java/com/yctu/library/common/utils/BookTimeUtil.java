package com.yctu.library.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:LiPeng
 * @Date:2018/4/28--18:15
 */
public class BookTimeUtil {
    public static String currentTimes() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");//可以方便地修改日期格式

        String time = dateFormat.format(now);
        return time;
    }
    public static double moneyTime(String stratTime, String endTime) {
        double money = 0;
        int x = Integer.valueOf(endTime.substring(0, 6)) - Integer.valueOf(stratTime.substring(0, 6)) - 30;
        if (x > 0) {
            money = x * 0.2;
        }
        return money;
    }
    public static Date opTimes() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        java.util.Date time=null;
        try {
            time= sdf.parse(sdf.format(new Date()));

        } catch (ParseException e) {

            e.printStackTrace();
        }
        return time;
    }
    public static Integer intTimes() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//可以方便地修改日期格式

        String time = dateFormat.format(now);
        return Integer.valueOf(time);
    }
}
