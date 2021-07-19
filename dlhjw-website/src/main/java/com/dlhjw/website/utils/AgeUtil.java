package com.dlhjw.website.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/7/1 9:27
 */
public class AgeUtil {

    //1.把出生日期字符串转换为日期格式。
    public static Date parse(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static  int getAge(Date birthDay) {
        Calendar cal = Calendar.getInstance();

        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        if( cal == null){
            return 0;
        }
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;//当前日期在生日之前，年龄减一
                }
            }else{
                age--;//当前月份在生日之前，年龄减一
            }
        }
        return age;
    }
}
