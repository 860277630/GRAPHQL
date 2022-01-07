package com.mx.server.entity;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@Value
public class BankAccount {
    UUID id;
    String name;
    Currency currency;
}
