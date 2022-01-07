package com.example.demo.entity;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@Value
public class BankAccount {
    UUID id;
    String name;
    Currency Currency;
}
