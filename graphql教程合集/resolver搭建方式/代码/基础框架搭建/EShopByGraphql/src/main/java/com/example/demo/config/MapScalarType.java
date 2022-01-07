package com.example.demo.config;

import graphql.schema.*;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.stereotype.Component;

import java.util.Map;

//定义用于  graphql的  map类型  复杂类
@Component
public class MapScalarType extends GraphQLScalarType {
    public MapScalarType(){
        //Coercing  是一个接口  需要实例化  简称匿名内部类  里面的抽象方法 来自定义实现
        super("SelfMap","User-defined Type",new Coercing<Map<String,Object>,String>(){
            //模仿官网  将Map<String,Object>类型转化为  String类型
            @Override
            public String serialize(Object o) throws CoercingSerializeException {
                System.out.println("come in");
                return String.valueOf(o);
            }

            //接口2：将输入的object类型  转化为  map类型
            @Override
            public Map<String, Object> parseValue(Object o) throws CoercingParseValueException {
                System.out.println("come in again");
                return new BeanMap(o);
            }

            //接口3：和接口2类似
            @Override
            public Map<String, Object> parseLiteral(Object o) throws CoercingParseLiteralException {
                System.out.println("come in 2");
                return new BeanMap(o);
            }
        });

    }

}
