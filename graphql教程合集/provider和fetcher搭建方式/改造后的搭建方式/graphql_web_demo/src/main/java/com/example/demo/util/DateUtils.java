package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //Date 转  String
    public static String format(Date date,String format){
        return new SimpleDateFormat(format).format(date);
    }

    //String 转  Date
    public static Date parseDate(String dateStr,String format) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return  df.parse(dateStr);
    }
}
