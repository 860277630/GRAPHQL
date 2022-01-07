package com.example.demo.config;

import cn.hutool.core.date.DateUtil;
import com.example.demo.util.DateUtils;
import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//测试自定义标量  源码和ExtendedScalars  一致   但是目前来看  provider不支持  源码和ExtendedScalars
//参照官网 ：https://netflix.github.io/dgs/scalars/
public class DateTimeScalarType extends GraphQLScalarType {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

    public DateTimeScalarType() {
        //关于new Coercing的两个泛型 可以参照 源码  ，一般第二个都为String 类型  第一个是我们要用在graphql里面的类型 在java中的对应类型
        //Coercing  是一个接口  需要实例化  简称匿名内部类  里面的抽象方法 来自定义实现
        //name指的是  你在graphql声明的类型名称
        super("MyDateTime", "DateTime value", new Coercing<Date, String>() {
            //接口1：将LocalDate  转为  String  类型
            @Override
            public String serialize(Object o) {
                Date date = (Date) o;
                return DateUtils.format(date, DATE_FORMAT);
            }


            //接口2：将输入的object类型  转为  LocalDateTime类型
            @Override
            public Date parseValue(Object o) {
                String value = String.valueOf(o);
                if ("null".equalsIgnoreCase(value) || "".equalsIgnoreCase(value)) {
                    return null;
                }
                try {
                    return DateUtils.parseDate(value, DATE_FORMAT);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return null;
                }
            }


            //接口3：功能近似于接口2  所以实现方法可以一样
            @Override
            public Date parseLiteral(Object o) {
                //提取出   具体数据  以value和倒数第四个字符 进行分割
                String value = String.valueOf(o).substring(String.valueOf(o).indexOf("value")+7,String.valueOf(o).length()-2);
                if ("null".equalsIgnoreCase(value) || "".equalsIgnoreCase(value)) {
                    return null;
                }
                try {
                    return DateUtils.parseDate(value, DATE_FORMAT);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return null;
                }
            }

        });
    }

    public static void main(String[] args) {
        //String value = "StringValue{value='2021-01-01 01:01'}";
        String value = "2021-01-01 01:01";
        try {
            System.out.println(DateUtils.parseDate(value, DATE_FORMAT));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
