package com.example.demo.Interfance;

import cn.hutool.core.date.DateTime;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


//这个类用来测试自定义类型
@Component
@Slf4j
public class TestSelfTypeDataFetcher implements MyDataFetcher{
    @Override
    public String fieldName() {
        return "testSelfType";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        log.info("num ,{}",environment.getArgument("num").toString());
        log.info("myDateTime,{}",environment.getArgument("myDateTime").toString());

        Long num = environment.getArgument("num");
        Date myDateTime = environment.getArgument("myDateTime");
        Map<String,Object>  map = new HashMap<>();
        map.put("num",num);
        map.put("myDateTime",myDateTime);
        return map;
    }
}
