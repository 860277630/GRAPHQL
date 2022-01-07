package com.example.demo.Interfance;

import com.example.demo.entity.Card;
import com.example.demo.entity.User;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDataFatcher implements MyDataFetcher{

    @Override
    public String fieldName() {
        return "user";
    }


    //这个演示的是  userquery  里面的card  方法
    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {

        Long id = environment.getArgument("id");
        List<Card> cards  = new ArrayList<>();
        cards.add(new Card(id, "card1 by yourself"));
        cards.add(new Card(id, "card2 by yourself"));
        return  new User(id, "user by youself",15,new Card(id, "card3 by yourself"),cards);
    }

}
