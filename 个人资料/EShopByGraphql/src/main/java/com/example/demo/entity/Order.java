package com.example.demo.entity;

import lombok.Builder;
import lombok.Value;

//订单信息
@Builder
@Value
public class Order {
    private Commodity commodity;
    private Logistics logistics;
}
