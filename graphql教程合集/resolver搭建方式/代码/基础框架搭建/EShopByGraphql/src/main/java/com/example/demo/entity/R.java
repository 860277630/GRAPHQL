package com.example.demo.entity;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class R {
    Integer code;
    String msg;
}
