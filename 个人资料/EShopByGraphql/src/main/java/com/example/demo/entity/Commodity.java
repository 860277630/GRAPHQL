package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

//商品信息
@Builder
@Value
public class Commodity {
    String name;
    Integer num;
}
