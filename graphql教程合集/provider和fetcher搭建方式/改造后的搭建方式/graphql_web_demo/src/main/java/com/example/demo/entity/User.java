package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private Card card;
    private List<Card> cards;

}
