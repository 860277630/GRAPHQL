package com.example.demo.entity;

import lombok.Builder;
import lombok.Value;

//物流信息
@Builder
@Value
public class Logistics {
    String orderNum;
    String company;
}
