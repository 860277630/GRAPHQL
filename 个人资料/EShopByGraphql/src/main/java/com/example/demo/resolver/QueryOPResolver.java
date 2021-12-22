package com.example.demo.resolver;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.Currency;
import com.example.demo.entity.R;
import com.example.demo.entity.orderData;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class QueryOPResolver implements GraphQLQueryResolver {

    public R getOrders() {
        log.info("查询所有的数据");
        return R.builder().msg(orderData.getData().toString()).build();
    }

}
