package net.boboweike.learn.graphql.domain;

import lombok.Builder;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Builder
public class Client {
    UUID id;
    String firstName;
    String lastName;
}
