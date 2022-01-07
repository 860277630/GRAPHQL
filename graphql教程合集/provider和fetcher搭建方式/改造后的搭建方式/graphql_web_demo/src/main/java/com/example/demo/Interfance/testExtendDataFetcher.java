package com.example.demo.Interfance;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.SonDemo;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class testExtendDataFetcher  implements MyDataFetcher{
    @Override
    public String fieldName() {
        return "testExtend";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        log.info("come in");
        //将初始化后的数据  转化为json
        SonDemo sonDemo = new SonDemo("1", "小红", "周口饭店", "张");

        //1、使用JSONObject
        //System.out.println(JSONObject.toJSONString(sonDemo));
        //return JSONObject.toJSONString(sonDemo);
        return sonDemo;
    }
}
