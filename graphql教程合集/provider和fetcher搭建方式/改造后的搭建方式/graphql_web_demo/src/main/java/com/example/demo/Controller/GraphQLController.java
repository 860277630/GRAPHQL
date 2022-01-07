package com.example.demo.Controller;

import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;

    @GetMapping("/graphql")
    @ResponseBody
   // public Map<String,Object> graphql(@RequestParam("query") String query){
        public Map<String,Object> graphql(){
        String query = null;
        //注意  这里的query和background  插件里的query是一样的！！！！！！！！！！

        //根据query  的json(类似json 而已)内容  决定访问  是card方法  还是user方法  以及对应的返回值
        //比如  第一个访问的就是  query方法  第二个访问的就是  user方法
        //内嵌的如果是实体或者数组  都按照下面的方式进行
        //query = "{card(id:1){id,address}}";
        //query = "{user(id:1){id,name,age,card{id,address},cards{id,address}}}";
        //query = "{baseType}";//测试回参是基本类型
        //query = "{testExtend{id,name,address,firstName,IS_LAST}}";// 继承关系
        //query = "{testInputBean(input: {id:\"1\",name:\"王五\"})}";//测试入参是bean类型
        query = "{testSelfType(num:5,myDateTime:\"2021-01-01 01:01\")}";//测试graphql里面的自定义类型
        return graphQL.execute(query).toSpecification();
    }
}