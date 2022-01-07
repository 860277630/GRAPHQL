package com.example.demo.Interfance;

import com.example.demo.entity.Card;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

//托管给spring
@Component
public class CardDataFatcher implements MyDataFetcher {

    @Override
    public String fieldName() {
        return "card";
    }


    //这个演示的是  userquery  里面的card  方法
    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {

        Long id = environment.getArgument("id");
        return  new Card(id, "card by yourself");
    }
}