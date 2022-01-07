package com.example.demo.resolver;

import com.example.demo.entity.R;
import com.example.demo.entity.orderData;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MutationOPResolver implements GraphQLMutationResolver {

    //根据输入的量  进行
    public R createOrdes(Integer num){
        log.info("进入订单创建的方法, 参数为 {}", num);
        orderData.createOrders(num);
        return R.builder()
                .msg("创建成功，订单的数量为: "+orderData.getData().size())
                .build();
    }
}
