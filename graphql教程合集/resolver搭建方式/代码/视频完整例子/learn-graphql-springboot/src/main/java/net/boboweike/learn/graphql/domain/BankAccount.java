package net.boboweike.learn.graphql.domain;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Value
public class BankAccount {
    UUID id;
    Client client;
    Currency currency;
    OffsetDateTime createdAt;
    LocalDate createdOn;
}
