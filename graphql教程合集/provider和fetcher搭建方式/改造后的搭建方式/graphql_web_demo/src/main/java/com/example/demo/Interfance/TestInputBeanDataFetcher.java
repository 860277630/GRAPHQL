package com.example.demo.Interfance;

import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


//测试入参是  bean类型
@Slf4j
@Component
public class TestInputBeanDataFetcher implements MyDataFetcher{
    @Override
    public String fieldName() {
        return "testInputBean";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        log.info("come in");
        //这里要捕捉input
        Object testInputBean = environment.getArgument("input");
        return testInputBean.toString();
    }
}
