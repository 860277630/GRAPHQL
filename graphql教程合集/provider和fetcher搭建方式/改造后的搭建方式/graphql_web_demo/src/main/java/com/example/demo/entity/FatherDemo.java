package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FatherDemo {
    private static final String IS_LAST = "ISLAST";
    private String address;
    private String firstName;
}
